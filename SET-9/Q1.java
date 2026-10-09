import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Q1 extends JFrame implements ActionListener {

    JTextField name, regNo;
    JRadioButton male, female;
    JCheckBox reading, sports, music;
    JComboBox<String> course;
    JButton submit, clear;

    Q1() {
        setTitle("Student Registration Form");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Student Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Register Number:"));
        regNo = new JTextField();
        add(regNo);

        add(new JLabel("Gender:"));
        JPanel gender = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        gender.add(male);
        gender.add(female);
        add(gender);

        add(new JLabel("Course:"));
        String courses[] = {"BCA", "BSc", "BCom", "MCA"};
        course = new JComboBox<>(courses);
        add(course);

        add(new JLabel("Hobbies:"));
        JPanel hobbies = new JPanel();
        reading = new JCheckBox("Reading");
        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");

        hobbies.add(reading);
        hobbies.add(sports);
        hobbies.add(music);
        add(hobbies);

        submit = new JButton("Submit");
        clear = new JButton("Clear");
        add(submit);
        add(clear);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            String gender = "Not selected";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";

            String hobbies = "";
            if (reading.isSelected()) hobbies += "Reading ";
            if (sports.isSelected()) hobbies += "Sports ";
            if (music.isSelected()) hobbies += "Music ";

            JOptionPane.showMessageDialog(this,
                "Name: " + name.getText() +
                "\nRegister Number: " + regNo.getText() +
                "\nGender: " + gender +
                "\nCourse: " + course.getSelectedItem() +
                "\nHobbies: " + hobbies);
        }

        if (e.getSource() == clear) {
            name.setText("");
            regNo.setText("");
            male.setSelected(false);
            female.setSelected(false);
            reading.setSelected(false);
            sports.setSelected(false);
            music.setSelected(false);
            course.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new Q1();
    }
}