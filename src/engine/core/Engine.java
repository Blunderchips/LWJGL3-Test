package engine.core;

import java.nio.ByteBuffer;

import engine.Destroyable;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.util.Dimension;
import org.lwjgl.util.ReadableDimension;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_MODULATE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_ENV;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_ENV_MODE;
import static org.lwjgl.opengl.GL11.GL_TRUE;

public abstract class Engine extends Object implements Runnable, Destroyable {

    private final long windowID;
    private final GLFWErrorCallback errorCallback;

    public Engine() {
        this(null, new Dimension(800, 600));
    }

    public Engine(String title, ReadableDimension dimensions)
            throws IllegalStateException {
        GLFW.glfwSetErrorCallback(errorCallback = Callbacks.errorCallbackPrint(System.err));

        if (GLFW.glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW.");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        GLFW.glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        this.windowID = GLFW.glfwCreateWindow(
                dimensions.getWidth(),
                dimensions.getHeight(),
                title,
                MemoryUtil.NULL,
                MemoryUtil.NULL
        );

        if (windowID == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window.");
        }
        ByteBuffer vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(
                this.windowID,
                (GLFWvidmode.width(vidMode) - dimensions.getWidth()) / 2,
                (GLFWvidmode.height(vidMode) - dimensions.getHeight()) / 2
        );

        GLFW.glfwMakeContextCurrent(windowID);
        GLFW.glfwSwapInterval(1);
    }

    /**
     * This function is called exactly once at the beginning of the game.
     */
    public abstract void load();

    /**
     * Callback function used to update the state of the game every frame.
     *
     * @param dt Delta Time is the time it takes for the computer to go through
     * all the processing/rendering for a single frame. It is dynamically
     * updated, so it can fluctuate depending on what level of processing the
     * last frame required.
     */
    public abstract void update(float dt);

    /**
     * Callback function used to render on the screen every frame.
     */
    public abstract void render();

    /**
     * Runs on close requested.
     */
    public abstract void onCloseRequested();

    public void start() {
        this.run();
    }

    @Override
    public void run() {
        GLFW.glfwShowWindow(windowID);
        GLContext.createFromCurrent();

        this.intitGL();

        long currentTime;
        long lastUpdateTime = System.nanoTime();

        this.load();
        while (true) {
            currentTime = System.nanoTime();

            if (GLFW.glfwWindowShouldClose(windowID) == GL_FALSE) {
                GL11.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

                this.update((float) (currentTime - lastUpdateTime) / 1000000000);
                this.render();

                GLFW.glfwSwapBuffers(windowID);
                GLFW.glfwPollEvents();
            } else {
                this.onCloseRequested();
            }

            lastUpdateTime = currentTime;
        }
    }

    @Override
    public void destroy() {
        GLFW.glfwSetWindowShouldClose(windowID, GL_TRUE);
        GLFW.glfwDestroyWindow(windowID);
        GLFW.glfwTerminate();
        this.errorCallback.release();
    }

    public void close(boolean asCrash) {
        this.destroy();
        System.exit(asCrash ? 1 : 0);
    }

    public GLFWErrorCallback getErrorCallback() {
        return this.errorCallback;
    }

    public long getWindowID() {
        return this.windowID;
    }

    /**
     * Initializes <a href='http://www.opengl.org/'>OpenGL</a>.
     */
    private void intitGL() {
        GL11.glMatrixMode(GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL_MODELVIEW);
        GL11.glClearColor(0xff, 0xff, 0xff, GL_COLOR_BUFFER_BIT);

        GL11.glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

        GL11.glEnable(GL_BLEND);
        GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        GL11.glDisable(GL_DEPTH_TEST);
        GL11.glEnable(GL_COLOR_MATERIAL);
        GL11.glEnable(GL_ALPHA_TEST);
        GL11.glEnable(GL_BLEND);
        GL11.glEnable(GL_TEXTURE_2D);
        GL11.glShadeModel(GL_SMOOTH);
    }
}
