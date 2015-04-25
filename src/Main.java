
import engine.Keyboard;
import engine.core.Engine;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;

public final class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Engine() {

            private Keyboard Keyboard;

            @Override
            public void load() {
                this.Keyboard = new Keyboard(getWindowID());
            }

            @Override
            public void update(float dt) {
                if (Keyboard.isKeyPressed("up")) {
                    System.out.println("pressed");
                }
                if (Keyboard.isKeyReleased("up")) {
                    System.out.println("up");
                }
                if (Keyboard.isKeyDown("up")) {
                    System.out.println("down");
                }

                this.Keyboard.update();
            }

            @Override
            public void render() {
                GL11.glBegin(GL_TRIANGLES);
                {
                    GL11.glColor3f(1, 0, 0);
                    GL11.glVertex2f(0, 0.75f);
                    GL11.glColor3f(0, 1, 0);
                    GL11.glVertex2f(-0.75f, -0.75f);
                    GL11.glColor3f(0, 0, 1);
                    GL11.glVertex2f(0.75f, -0.75f);
                }
                GL11.glEnd();
            }

            @Override
            public void onCloseRequested() {
                super.close(false);
            }

            @Override
            public void destroy() {
                Keyboard.destroy();
                super.destroy();
            }
        }.start();
    }
}
