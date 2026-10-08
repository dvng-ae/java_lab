import java.awt.*;
import java.awt.event.*;

class Q2 extends Frame implements ActionListener {

    TextField n1, n2, result;
    Button add, sub, mul, div;

    Q2() {

        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        add(new Label("First Number:"));
        n1 = new TextField(10);
        add(n1);

        add(new Label("Second Number:"));
        n2 = new TextField(10);
        add(n2);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        result = new TextField(20);
        result.setEditable(false);
        add(new Label("Result:"));
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

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
            result.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new Q2();
    }
}