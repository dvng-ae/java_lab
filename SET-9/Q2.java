import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Q2 extends JFrame implements ActionListener {

    JTextField n1, n2, result;
    JButton add, sub, mul, div;

    Q2() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("First Number:"));
        n1 = new JTextField();
        add(n1);

        add(new JLabel("Second Number:"));
        n2 = new JTextField();
        add(n2);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());
            double r = 0;

            if (e.getSource() == add)
                r = a + b;
            else if (e.getSource() == sub)
                r = a - b;
            else if (e.getSource() == mul)
                r = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                r = a / b;
            }

            result.setText(String.valueOf(r));

        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Q2();
    }
}