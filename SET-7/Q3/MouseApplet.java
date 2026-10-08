import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseApplet extends Applet implements MouseListener {
    int x = 0;
    int y = 0;
    boolean clicked = false;

    public void init() {
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        if (clicked) {
            g.drawString("Mouse clicked at: (" + x + ", " + y + ")", 50, 80);
        }
        else {
            g.drawString("Move the mouse inside the applet", 50, 80);
        }
    }
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        clicked = true;
        repaint();
    }
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}