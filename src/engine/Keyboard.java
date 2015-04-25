/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Matthew 'siD' Van der Bijl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package engine;

import java.util.HashMap;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class Keyboard implements Destroyable, Keys {

    private GLFWKeyCallback keyCallback;

    private final HashMap<Integer, Boolean> currentKeys;
    private final HashMap<Integer, Boolean> downKeys;
    private final HashMap<Integer, Boolean> upKeys;

    public Keyboard(long windowID) {
        this.currentKeys = new HashMap<>();
        this.downKeys = new HashMap<>();
        this.upKeys = new HashMap<>();

        GLFW.glfwSetKeyCallback(windowID, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (action == GLFW_PRESS) {
                    currentKeys.put(key, true);
                    downKeys.put(key, true);
                    upKeys.put(key, false);
                } else if (action == GLFW_RELEASE) {
                    upKeys.put(key, true);
                    downKeys.put(key, false);
                    currentKeys.put(key, false);
                }
            }
        });
    }

    public void update() {
        for (int key : currentKeys.keySet()) {
            if (currentKeys.get(key) && downKeys.get(key)) {
                currentKeys.put(key, false);
            } else if (upKeys.get(key) && !downKeys.get(key)) {
                upKeys.put(key, false);
            }
        }
    }

    public GLFWKeyCallback getKeyCallback() {
        return this.keyCallback;
    }

    public void setKeyCallback(GLFWKeyCallback keyCallback) {
        this.keyCallback = keyCallback;
    }

    public HashMap<Integer, Boolean> getCurrentKeys() {
        return this.currentKeys;
    }

    public HashMap<Integer, Boolean> getDownKeys() {
        return this.downKeys;
    }

    public HashMap<Integer, Boolean> getUpKeys() {
        return this.upKeys;
    }

    @Override
    public void destroy() {
        this.currentKeys.clear();
        this.downKeys.clear();
        this.upKeys.clear();

        this.keyCallback.release();
    }

    //========================================================================
    // Keyboard events
    //========================================================================
    
    /**
     * Checks whether a certain key is down.
     *
     * @param keyCode the key code of the key to be tested
     * @return true if the key is down, otherwise it will return false.
     */
    public boolean isKeyDown(int keyCode) {
        try {
            return downKeys.get(keyCode);
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Checks whether a certain key is down.
     *
     * @param keyName the name of the key to be tested
     * @throws IllegalArgumentException keyName not recognised
     * @return true if the key is down, otherwise it will return false.
     */
    public boolean isKeyDown(String keyName) throws IllegalArgumentException {
        return isKeyDown(getKeyCode(keyName));
    }

    /**
     * checks if a key is down for a single frame, callback function triggered
     * when a key is pressed.
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is pressed down for that frame
     */
    public boolean isKeyPressed(int keyCode) {
        try {
            return currentKeys.get(keyCode);
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * checks if a key is down for a single frame, callback function triggered
     * when a key is pressed.
     *
     * @param keyName the name of the key to be tested
     * @throws IllegalArgumentException keyName not recognised
     * @return if a key is pressed down for that frame
     */
    public boolean isKeyPressed(String keyName) throws IllegalArgumentException {
        return isKeyPressed(getKeyCode(keyName));
    }

    /**
     * checks if a key is released, callback function triggered when a key is
     * released.
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is released up for that frame
     */
    public boolean isKeyReleased(int keyCode) {
        try {
            return upKeys.get(keyCode);
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * checks if a key is released, callback function triggered when a key is
     * released.
     *
     * @param keyName the name of the key to be tested
     * @throws IllegalArgumentException keyName not recognised
     * @return if a key is released up for that frame
     */
    public boolean isKeyReleased(String keyName) throws IllegalArgumentException {
        return isKeyReleased(getKeyCode(keyName));
    }

    /**
     * Gets a key's "name".
     *
     * @param name The key code to be tested
     * @throws IllegalArgumentException will throw if no suitable result is
     * found
     * @return the name of the key
     */
    public int getKeyCode(String name) throws IllegalArgumentException {
        switch (name.toLowerCase()) {
            case "0":
                return KEY_0;
            case "1":
                return KEY_1;
            case "2":
                return KEY_2;
            case "3":
                return KEY_3;
            case "4":
                return KEY_4;
            case "5":
                return KEY_5;
            case "6":
                return KEY_6;
            case "7":
                return KEY_7;
            case "8":
                return KEY_8;
            case "9":
                return KEY_9;
            case "a":
                return KEY_A;
            case "apostrophe":
                return KEY_APOSTROPHE;
            case "b":
                return KEY_B;
            case "backslash":
                return KEY_BACKSLASH;
            case "backspace":
                return KEY_BACKSPACE;
            case "c":
                return KEY_C;
            case "caps lock":
                return KEY_CAPS_LOCK;
            case "d":
                return KEY_D;
            case "delete":
                return KEY_DELETE;
            case "down":
                return KEY_DOWN;
            case "e":
                return KEY_E;
            case "end":
                return KEY_END;
            case "equal":
                return KEY_EQUAL;
            case "escape":
                return KEY_ESCAPE;
            case "f":
                return KEY_F;
            case "f1":
                return KEY_F1;
            case "f10":
                return KEY_F10;
            case "f11":
                return KEY_F11;
            case "f12":
                return KEY_F12;
            case "f13":
                return KEY_F13;
            case "f14":
                return KEY_F14;
            case "f15":
                return KEY_F15;
            case "f16":
                return KEY_F16;
            case "f17":
                return KEY_F17;
            case "f18":
                return KEY_F18;
            case "f19":
                return KEY_F19;
            case "f20":
                return KEY_F20;
            case "f21":
                return KEY_F21;
            case "f22":
                return KEY_F22;
            case "f23":
                return KEY_F23;
            case "f24":
                return KEY_F24;
            case "f25":
                return KEY_F25;
            case "f3":
                return KEY_F3;
            case "f4":
                return KEY_F4;
            case "f5":
                return KEY_F5;
            case "f6":
                return KEY_F6;
            case "f7":
                return KEY_F7;
            case "f8":
                return KEY_F8;
            case "f9":
                return KEY_F9;
            case "g":
                return KEY_G;
            case "grave accent":
                return KEY_GRAVE_ACCENT;
            case "h":
                return KEY_H;
            case "home":
                return KEY_HOME;
            case "i":
                return KEY_I;
            case "insert":
                return KEY_INSERT;
            case "j":
                return KEY_J;
            case "k":
                return KEY_K;
            case "numpad 0":
                return KEY_KP_0;
            case "numpad 1":
                return KEY_KP_1;
            case "numpad 2":
                return KEY_KP_2;
            case "numpad 3":
                return KEY_KP_3;
            case "numpad 4":
                return KEY_KP_4;
            case "numpad 5":
                return KEY_KP_5;
            case "numpad 6":
                return KEY_KP_6;
            case "numpad 7":
                return KEY_KP_7;
            case "numpad 8":
                return KEY_KP_8;
            case "numpad 9":
                return KEY_KP_9;
            case "numpad add":
                return KEY_KP_ADD;
            case "numpad decimal":
                return KEY_KP_DECIMAL;
            case "numpad divide":
                return KEY_KP_DIVIDE;
            case "numpad enter":
                return KEY_KP_ENTER;
            case "numpad equal":
                return KEY_KP_EQUAL;
            case "numpad multiply":
                return KEY_KP_MULTIPLY;
            case "numpad subtract":
                return KEY_KP_SUBTRACT;
            case "l":
                return KEY_L;
            case "last":
                return KEY_LAST;
            case "left":
                return KEY_LEFT;
            case "left alt":
                return KEY_LEFT_ALT;
            case "left bracket":
                return KEY_LEFT_BRACKET;
            case "left control":
                return KEY_LEFT_CONTROL;
            case "left shift":
                return KEY_LEFT_SHIFT;
            case "left super":
                return KEY_LEFT_SUPER;
            case "m":
                return KEY_M;
            case "menu":
                return KEY_MENU;
            case "minus":
                return KEY_MINUS;
            case "n":
                return KEY_N;
            case "num lock":
                return KEY_NUM_LOCK;
            case "p":
                return KEY_P;
            case "page down":
                return KEY_PAGE_DOWN;
            case "page up":
                return KEY_PAGE_UP;
            case "pause":
                return KEY_PAUSE;
            case "period":
                return KEY_PERIOD;
            case "print screen":
                return KEY_PRINT_SCREEN;
            case "q":
                return KEY_Q;
            case "r":
                return KEY_R;
            case "right":
                return KEY_RIGHT;
            case "right alt":
                return KEY_RIGHT_ALT;
            case "right bracket":
                return KEY_RIGHT_BRACKET;
            case "right control":
                return KEY_RIGHT_CONTROL;
            case "right shift":
                return KEY_RIGHT_SHIFT;
            case "right super":
                return KEY_RIGHT_SUPER;
            case "s":
                return KEY_S;
            case "scroll lock":
                return KEY_SCROLL_LOCK;
            case "semicolon":
                return KEY_SEMICOLON;
            case "slash":
                return KEY_SLASH;
            case "space":
                return KEY_SPACE;
            case "t":
                return KEY_T;
            case "tab":
                return KEY_TAB;
            case "u":
                return KEY_U;
            case "up":
                return KEY_UP;
            case "v":
                return KEY_V;
            case "w":
                return KEY_W;
            case "world 1":
                return KEY_WORLD_1;
            case "world 2":
                return KEY_WORLD_2;
            case "x":
                return KEY_X;
            case "y":
                return KEY_Y;
            case "z":
                return KEY_Z;
            default:
                throw new IllegalArgumentException("keycode '" + name + "' is not recognised");
        }
    }
}
