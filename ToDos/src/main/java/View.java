import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class View {
    private JFrame myFrame;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JButton addButton;
    private JButton trashButton;
    private Box myBox;

    public View(ArrayList<Task> myList){
        myFrame = new JFrame("ToDo List");
        northPanel = new JPanel();
        centerPanel = new JPanel();
        addButton = new JButton("add");
        trashButton = new JButton("delete");
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

        //trashButton setting
        trashButton.setActionCommand("Delete All");
        trashButton.setBounds(15, 10, 25, 25);
        trashButton.setBorder(BorderFactory.createEmptyBorder());
        trashButton.setContentAreaFilled(false);
        trashButton.setFocusPainted(false);

        //add components to frame
        centerPanel.add(myBox);
        myFrame.add(centerPanel);
        myFrame.add(northPanel, BorderLayout.NORTH);

        //show tasks
        for(Task task : myList){
            JTextArea taskField = new JTextArea(task.getContent());
            taskField.setLineWrap(true);
            taskField.setWrapStyleWord(true);
            Border taskFieldBorder = BorderFactory.createLineBorder(Color.BLUE,1);
            taskField.setBorder(taskFieldBorder);
            myBox.add(taskField);
            myBox.add(Box.createRigidArea(new Dimension(0,5)));
            myFrame.setVisible(true);
        }

    }

    public void updateView(ArrayList<Task> myList){
        myBox.removeAll();
        myFrame.setVisible(true);
        for(Task task : myList){
            JTextArea taskField = new JTextArea(task.getContent());
            taskField.setLineWrap(true);
            taskField.setWrapStyleWord(true);
            Border taskFieldBorder = BorderFactory.createLineBorder(Color.BLUE,1);
            taskField.setBorder(taskFieldBorder);
            myBox.add(taskField);
            myBox.add(Box.createRigidArea(new Dimension(0,5)));
            myFrame.setVisible(true);
        }

    }

    public void addNewTask(Task myTask){
        JTextArea taskField = new JTextArea(myTask.getContent());
        taskField.setLineWrap(true);
        taskField.setWrapStyleWord(true);
        Border taskFieldBorder = BorderFactory.createLineBorder(Color.BLUE,1);
        taskField.setBorder(taskFieldBorder);
        myBox.add(taskField);
        myBox.add(Box.createRigidArea(new Dimension(0,5)));
        myFrame.setVisible(true);
    }

    public String getInputFromDialog(){
        return JOptionPane.showInputDialog("Enter your plan: ");
    }

    public JButton getAddButton(){
        return addButton;
    }
    public JButton getTrasshButton(){
        return trashButton;
    }


}