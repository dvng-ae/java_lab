import java.awt.*;
import java.awt.event.*;

class Q5 extends Frame implements ActionListener {

    TextField name, mark1, mark2, mark3, result;
    Button calculate;

    Q5() {
        setTitle("Student Performance");
        setSize(450, 300);
        setLayout(new FlowLayout());

        Panel p = new Panel();
        p.setLayout(new GridLayout(6, 2, 5, 5));

        p.add(new Label("Student Name:"));
        name = new TextField();
        p.add(name);

        p.add(new Label("Mark 1:"));
        mark1 = new TextField();
        p.add(mark1);

        p.add(new Label("Mark 2:"));
        mark2 = new TextField();
        p.add(mark2);

        p.add(new Label("Mark 3:"));
        mark3 = new TextField();
        p.add(mark3);

        calculate = new Button("Calculate");
        p.add(calculate);

        p.add(new Label("Result:"));
        result = new TextField();
        result.setEditable(false);
        p.add(result);

        add(p);

        calculate.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double m1 = Double.parseDouble(mark1.getText());
            double m2 = Double.parseDouble(mark2.getText());
            double m3 = Double.parseDouble(mark3.getText());

            double total = m1 + m2 + m3;
            double average = total / 3;

            result.setText("Total = " + total + "  Average = " + average);

        } catch (NumberFormatException ex) {
            result.setText("Enter valid marks");
        }
    }

    public static void main(String[] args) {
        new Q5();
    }
}