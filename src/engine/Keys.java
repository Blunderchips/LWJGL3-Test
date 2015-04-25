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

/**
 * Holds all Key constants.
 */
public interface Keys {

    /**
     * Printable keys.
     */
    public static final int
            KEY_SPACE = org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE,
            KEY_APOSTROPHE = org.lwjgl.glfw.GLFW.GLFW_KEY_COMMA,
            KEY_MINUS = org.lwjgl.glfw.GLFW.GLFW_KEY_MINUS,
            KEY_PERIOD = org.lwjgl.glfw.GLFW.GLFW_KEY_PERIOD,
            KEY_SLASH = org.lwjgl.glfw.GLFW.GLFW_KEY_SLASH,
            KEY_0 = org.lwjgl.glfw.GLFW.GLFW_KEY_0,
            KEY_1 = org.lwjgl.glfw.GLFW.GLFW_KEY_1,
            KEY_2 = org.lwjgl.glfw.GLFW.GLFW_KEY_2,
            KEY_3 = org.lwjgl.glfw.GLFW.GLFW_KEY_3,
            KEY_4 = org.lwjgl.glfw.GLFW.GLFW_KEY_4,
            KEY_5 = org.lwjgl.glfw.GLFW.GLFW_KEY_5,
            KEY_6 = org.lwjgl.glfw.GLFW.GLFW_KEY_6,
            KEY_7 = org.lwjgl.glfw.GLFW.GLFW_KEY_7,
            KEY_8 = org.lwjgl.glfw.GLFW.GLFW_KEY_8,
            KEY_9 = org.lwjgl.glfw.GLFW.GLFW_KEY_9,
            KEY_SEMICOLON = org.lwjgl.glfw.GLFW.GLFW_KEY_SEMICOLON,
            KEY_EQUAL = org.lwjgl.glfw.GLFW.GLFW_KEY_EQUAL,
            KEY_A = org.lwjgl.glfw.GLFW.GLFW_KEY_A,
            KEY_B = org.lwjgl.glfw.GLFW.GLFW_KEY_B,
            KEY_C = org.lwjgl.glfw.GLFW.GLFW_KEY_C,
            KEY_D = org.lwjgl.glfw.GLFW.GLFW_KEY_D,
            KEY_E = org.lwjgl.glfw.GLFW.GLFW_KEY_E,
            KEY_F = org.lwjgl.glfw.GLFW.GLFW_KEY_F,
            KEY_G = org.lwjgl.glfw.GLFW.GLFW_KEY_G,
            KEY_H = org.lwjgl.glfw.GLFW.GLFW_KEY_H,
            KEY_I = org.lwjgl.glfw.GLFW.GLFW_KEY_I,
            KEY_J = org.lwjgl.glfw.GLFW.GLFW_KEY_J,
            KEY_K = org.lwjgl.glfw.GLFW.GLFW_KEY_K,
            KEY_L = org.lwjgl.glfw.GLFW.GLFW_KEY_L,
            KEY_M = org.lwjgl.glfw.GLFW.GLFW_KEY_M,
            KEY_N = org.lwjgl.glfw.GLFW.GLFW_KEY_N,
            KEY_O = org.lwjgl.glfw.GLFW.GLFW_KEY_O,
            KEY_P = org.lwjgl.glfw.GLFW.GLFW_KEY_P,
            KEY_Q = org.lwjgl.glfw.GLFW.GLFW_KEY_Q,
            KEY_R = org.lwjgl.glfw.GLFW.GLFW_KEY_R,
            KEY_S = org.lwjgl.glfw.GLFW.GLFW_KEY_S,
            KEY_T = org.lwjgl.glfw.GLFW.GLFW_KEY_T,
            KEY_U = org.lwjgl.glfw.GLFW.GLFW_KEY_U,
            KEY_V = org.lwjgl.glfw.GLFW.GLFW_KEY_V,
            KEY_W = org.lwjgl.glfw.GLFW.GLFW_KEY_W,
            KEY_X = org.lwjgl.glfw.GLFW.GLFW_KEY_X,
            KEY_Y = org.lwjgl.glfw.GLFW.GLFW_KEY_Y,
            KEY_Z = org.lwjgl.glfw.GLFW.GLFW_KEY_Z,
            KEY_LEFT_BRACKET = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_BRACKET,
            KEY_BACKSLASH = org.lwjgl.glfw.GLFW.GLFW_KEY_BACKSLASH,
            KEY_RIGHT_BRACKET = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_BRACKET,
            KEY_GRAVE_ACCENT = org.lwjgl.glfw.GLFW.GLFW_KEY_GRAVE_ACCENT,
            KEY_WORLD_1 = org.lwjgl.glfw.GLFW.GLFW_KEY_WORLD_1,
            KEY_WORLD_2 = org.lwjgl.glfw.GLFW.GLFW_KEY_WORLD_2;

    /**
     * Function keys.
     */
    public static final int 
            KEY_ESCAPE = org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE,
            KEY_ENTER = org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER,
            KEY_TAB = org.lwjgl.glfw.GLFW.GLFW_KEY_TAB,
            KEY_BACKSPACE = org.lwjgl.glfw.GLFW.GLFW_KEY_BACKSPACE,
            KEY_INSERT = org.lwjgl.glfw.GLFW.GLFW_KEY_INSERT,
            KEY_DELETE = org.lwjgl.glfw.GLFW.GLFW_KEY_DELETE,
            KEY_RIGHT = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT,
            KEY_LEFT = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT,
            KEY_DOWN = org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN,
            KEY_UP = org.lwjgl.glfw.GLFW.GLFW_KEY_UP,
            KEY_PAGE_UP = org.lwjgl.glfw.GLFW.GLFW_KEY_PAGE_UP,
            KEY_PAGE_DOWN = org.lwjgl.glfw.GLFW.GLFW_KEY_PAGE_DOWN,
            KEY_HOME = org.lwjgl.glfw.GLFW.GLFW_KEY_HOME,
            KEY_END = org.lwjgl.glfw.GLFW.GLFW_KEY_END,
            KEY_CAPS_LOCK = org.lwjgl.glfw.GLFW.GLFW_KEY_CAPS_LOCK,
            KEY_SCROLL_LOCK = org.lwjgl.glfw.GLFW.GLFW_KEY_SCROLL_LOCK,
            KEY_NUM_LOCK = org.lwjgl.glfw.GLFW.GLFW_KEY_NUM_LOCK,
            KEY_PRINT_SCREEN = org.lwjgl.glfw.GLFW.GLFW_KEY_PRINT_SCREEN,
            KEY_PAUSE = org.lwjgl.glfw.GLFW.GLFW_KEY_PAUSE,
            KEY_F1 = org.lwjgl.glfw.GLFW.GLFW_KEY_F1,
            KEY_F2 = org.lwjgl.glfw.GLFW.GLFW_KEY_F2,
            KEY_F3 = org.lwjgl.glfw.GLFW.GLFW_KEY_F3,
            KEY_F4 = org.lwjgl.glfw.GLFW.GLFW_KEY_F4,
            KEY_F5 = org.lwjgl.glfw.GLFW.GLFW_KEY_F5,
            KEY_F6 = org.lwjgl.glfw.GLFW.GLFW_KEY_F6,
            KEY_F7 = org.lwjgl.glfw.GLFW.GLFW_KEY_F7,
            KEY_F8 = org.lwjgl.glfw.GLFW.GLFW_KEY_F8,
            KEY_F9 = org.lwjgl.glfw.GLFW.GLFW_KEY_F9,
            KEY_F10 = org.lwjgl.glfw.GLFW.GLFW_KEY_F10,
            KEY_F11 = org.lwjgl.glfw.GLFW.GLFW_KEY_F11,
            KEY_F12 = org.lwjgl.glfw.GLFW.GLFW_KEY_F12,
            KEY_F13 = org.lwjgl.glfw.GLFW.GLFW_KEY_F13,
            KEY_F14 = org.lwjgl.glfw.GLFW.GLFW_KEY_F14,
            KEY_F15 = org.lwjgl.glfw.GLFW.GLFW_KEY_F15,
            KEY_F16 = org.lwjgl.glfw.GLFW.GLFW_KEY_F16,
            KEY_F17 = org.lwjgl.glfw.GLFW.GLFW_KEY_F17,
            KEY_F18 = org.lwjgl.glfw.GLFW.GLFW_KEY_F18,
            KEY_F19 = org.lwjgl.glfw.GLFW.GLFW_KEY_F19,
            KEY_F20 = org.lwjgl.glfw.GLFW.GLFW_KEY_F20,
            KEY_F21 = org.lwjgl.glfw.GLFW.GLFW_KEY_F21,
            KEY_F22 = org.lwjgl.glfw.GLFW.GLFW_KEY_F22,
            KEY_F23 = org.lwjgl.glfw.GLFW.GLFW_KEY_F23,
            KEY_F24 = org.lwjgl.glfw.GLFW.GLFW_KEY_F24,
            KEY_F25 = org.lwjgl.glfw.GLFW.GLFW_KEY_F25,
            KEY_KP_0 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_0,
            KEY_KP_1 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_1,
            KEY_KP_2 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_2,
            KEY_KP_3 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_3,
            KEY_KP_4 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_4,
            KEY_KP_5 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_5,
            KEY_KP_6 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_6,
            KEY_KP_7 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_7,
            KEY_KP_8 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_8,
            KEY_KP_9 = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_9,
            KEY_KP_DECIMAL = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_DECIMAL,
            KEY_KP_DIVIDE = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_DIVIDE,
            KEY_KP_MULTIPLY = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_MULTIPLY,
            KEY_KP_SUBTRACT = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_SUBTRACT,
            KEY_KP_ADD = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_ADD,
            KEY_KP_ENTER = org.lwjgl.glfw.GLFW.GLFW_KEY_KP_ENTER,
            KEY_KP_EQUAL = org.lwjgl.glfw.GLFW.GLFW_KEY_EQUAL,
            KEY_LEFT_SHIFT = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SHIFT,
            KEY_LEFT_CONTROL = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_CONTROL,
            KEY_LEFT_ALT = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_ALT,
            KEY_LEFT_SUPER = org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SUPER,
            KEY_RIGHT_SHIFT = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT,
            KEY_RIGHT_CONTROL = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_CONTROL,
            KEY_RIGHT_ALT = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_ALT,
            KEY_RIGHT_SUPER = org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SUPER,
            KEY_MENU = org.lwjgl.glfw.GLFW.GLFW_KEY_MENU,
            KEY_LAST = KEY_MENU;
}
