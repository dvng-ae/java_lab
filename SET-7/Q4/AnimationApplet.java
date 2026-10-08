import java.applet.Applet;
import java.awt.Graphics;

public class AnimationApplet extends Applet implements Runnable {
    int x = 0;
    Thread t;
    boolean running = false;

    public void init() {
        x = 0;
    }
    public void start() {
        if (t == null) {
            t = new Thread(this);
            running = true;
            t.start();
        }
        else {
            running = true;
        }
    }
    public void run() {
        while (true) {
            if (running) {
                x = x + 5;

                if (x > getWidth()) {
                    x = 0;
                }

                repaint();
            }

            try {
                Thread.sleep(100);
        }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
  }

    public void stop() {
        running = false;
    }
    public void paint(Graphics g) {
        g.drawString("Moving Circle", 20, 30);
        g.fillOval(x, 70, 50, 50);
    }
}