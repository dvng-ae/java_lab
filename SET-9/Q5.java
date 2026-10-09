import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Q5 extends JFrame implements ActionListener {

    JTextField idField, titleField, authorField;
    JComboBox<String> categoryBox;
    JTable bookTable;
    DefaultTableModel tableModel;
    JButton addButton, deleteButton, clearButton;

    public Q5() {
        setTitle("Library Book Management");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));

        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();

        categoryBox = new JComboBox<>(
            new String[]{"Fiction", "Science", "History", "Other"}
        );

        inputPanel.add(new JLabel("Book ID:"));
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(new JLabel("Category:"));

        inputPanel.add(idField);
        inputPanel.add(titleField);
        inputPanel.add(authorField);
        inputPanel.add(categoryBox);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
            new String[]{"Book ID", "Title", "Author", "Category"}, 0
        );

        bookTable = new JTable(tableModel);
        add(new JScrollPane(bookTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add Book");
        deleteButton = new JButton("Delete Selected");
        clearButton = new JButton("Clear Fields");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            tableModel.addRow(new Object[]{
                idField.getText(),
                titleField.getText(),
                authorField.getText(),
                categoryBox.getSelectedItem()
            });

            clearFields();
        }
        else if (e.getSource() == deleteButton) {
            int row = bookTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(
                    this, "Select a book to delete."
                );
            } else {
                tableModel.removeRow(row);
            }
        }
        else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    public void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        categoryBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        Q5 window = new Q5();
        window.setVisible(true);
    }
}
