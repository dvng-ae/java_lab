import java.awt.*;
import java.awt.event.*;

class Q1 extends Frame implements ActionListener {

    TextField name, roll;
    Choice course;
    Checkbox java, python;
    Button submit, clear;

    Q1() {

        setTitle("Student Registration");
        setSize(400, 300);
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        name = new TextField(20);
        add(name);

        add(new Label("Roll No:"));
        roll = new TextField(20);
        add(roll);

        add(new Label("Course:"));
        course = new Choice();
        course.add("BCA");
        course.add("BSc");
        course.add("MCA");
        add(course);

        add(new Label("Subjects:"));

        java = new Checkbox("Java");
        python = new Checkbox("Python");

        add(java);
        add(python);

        submit = new Button("Submit");
        clear = new Button("Clear");

        add(submit);
        add(clear);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            System.out.println("Student Details");
            System.out.println("Name: " + name.getText());
            System.out.println("Roll No: " + roll.getText());
            System.out.println("Course: " + course.getSelectedItem());

            if (java.getState())
                System.out.println("Subject: Java");

            if (python.getState())
                System.out.println("Subject: Python");
        }

        if (e.getSource() == clear) {
            name.setText("");
            roll.setText("");
            java.setState(false);
            python.setState(false);
        }
    }

    public static void main(String[] args) {
        new Q1();
    }
}