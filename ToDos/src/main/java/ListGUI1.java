import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class ListGUI1 {

    // attributes
    private JFrame myFrame;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JButton addButton;
    private JButton trashButton;
    private ArrayList<JLabel> myTaskBoxes;
    private JPanel listTaskPanel;
    private List myList;
    private Box myBox;

    // constructor
    public ListGUI1(String title) {
        prepareGUI(title);
        prepareEvent();
        //create List
        myList = new List();
    }


    private void prepareGUI(String title) {
        //create components
        myFrame = new JFrame(title);
        northPanel = new JPanel();
        centerPanel = new JPanel();
        addButton = new JButton(new ImageIcon("D:\\HUONG\\2nd year\\SE\\Todoapp\\src\\main\\java\\add.png"));
        trashButton = new JButton("trash");
        listTaskPanel = new JPanel();
        myTaskBoxes = new ArrayList<JLabel>();
        myBox = Box.createVerticalBox();

        //frame setting
        myFrame.setSize(300, 400);
        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        //panel setting
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
        northPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        northPanel.add(addButton);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(trashButton);
        northPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        //addButton setting
        addButton.setActionCommand("Add Task");
        addButton.setBounds(15, 10, 25, 25);
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);

        //add components to frame
        listTaskPanel.add(myBox);
        myFrame.add(listTaskPanel);
        myFrame.add(northPanel, BorderLayout.NORTH);

    }

    private void prepareEvent() {
        addButton.addActionListener(new ClickButtonAction());
    }

    // implement ClickButtonAction
    private class ClickButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Add Task")) {
                String textBox;
                textBox = JOptionPane.showInputDialog("Enter the new plan: ");
                //JOptionPane.showMessageDialog(null,textBox);
                JLabel TaskLabel = new JLabel(textBox);
                TaskLabel.setBounds(15, 50, 200, 50);
                TaskLabel.setVisible(true);
                myBox.add(TaskLabel);
                myList.add(new Task(textBox));
                System.out.println("You've successfully added new task: " + textBox);
                myList.showList();
                myFrame.setVisible(true);

                //pack();
            }
        }
    }

    public static void main(String[] args) {
        new ListGUI1("Todo List");
    }

    // public void actionPerformed(ActionEvent e) {
    //     // do somethings
    // }
}