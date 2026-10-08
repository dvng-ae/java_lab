import java.awt.*;
import java.awt.event.*;

class Q4 extends Frame {

    Label label;

    Q4() {
        setTitle("Mouse and Keyboard");
        setSize(400, 200);
        setLayout(new FlowLayout());

        label = new Label("Move mouse or press a key");
        add(label);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked");
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse: " + e.getX() + ", " + e.getY());
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                label.setText("Key: " + e.getKeyChar());
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q4();
    }
}