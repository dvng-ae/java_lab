import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Q3 extends JFrame implements ActionListener {

    JTextField name, regNo, m1, m2, m3;
    JTextArea result;
    JButton calculate, clear, exit;

    Q3() {
        setTitle("Student Mark List");
        setSize(400, 450);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new JLabel("Student Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Register Number:"));
        regNo = new JTextField();
        add(regNo);

        add(new JLabel("Subject 1 Mark:"));
        m1 = new JTextField();
        add(m1);

        add(new JLabel("Subject 2 Mark:"));
        m2 = new JTextField();
        add(m2);

        add(new JLabel("Subject 3 Mark:"));
        m3 = new JTextField();
        add(m3);

        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        add(calculate);
        add(clear);
        add(exit);

        result = new JTextArea();
        result.setEditable(false);
        add(new JLabel("Result:"));
        add(result);

        calculate.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {
            try {
                double a = Double.parseDouble(m1.getText());
                double b = Double.parseDouble(m2.getText());
                double c = Double.parseDouble(m3.getText());

                if (a < 0 || a > 100 || b < 0 || b > 100 ||
                    c < 0 || c > 100) {
                    JOptionPane.showMessageDialog(this,
                        "Marks must be between 0 and 100");
                    return;
                }

                double total = a + b + c;
                double average = total / 3;
                String grade;

                if (average >= 90)
                    grade = "A";
                else if (average >= 75)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 40)
                    grade = "D";
                else
                    grade = "Fail";

                result.setText(
                    "Name: " + name.getText() +
                    "\nRegister No: " + regNo.getText() +
                    "\nTotal: " + total +
                    "\nAverage: " + average +
                    "\nGrade: " + grade
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Please enter valid marks");
            }
        }

        if (e.getSource() == clear) {
            name.setText("");
            regNo.setText("");
            m1.setText("");
            m2.setText("");
            m3.setText("");
            result.setText("");
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Q3();
    }
}