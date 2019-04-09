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
    private JScrollPane scrollPanel;
    private JPanel southPanel;
    private JLabel statusLabel;
    private ArrayList<TaskPanel> taskPanels;
    private JLabel ToDoLabel;

    public View(ArrayList<Task> myList) {
        taskPanels = new ArrayList<TaskPanel>();

        myFrame = new JFrame("ToDo List");
        ToDoLabel = new JLabel("Todo List");
        northPanel = new JPanel();
        southPanel = new JPanel();
        centerPanel = new JPanel();

        statusLabel = new JLabel("Hi there!");
        // addButton = new JButton(new ImageIcon("C:\\Users\\HP\\Documents\\ICT\\Software Engineering\\USTH-SE-2019\\ToDos\\src\\main\\java\\AddButton.png"));
        // trashButton = new JButton(new ImageIcon("C:\\Users\\HP\\Documents\\ICT\\Software Engineering\\USTH-SE-2019\\ToDos\\src\\main\\java\\TrashButton.png"));
        //addButton = new JButton(new ImageIcon("/home/doan/Desktop/USTH-SE-2019/ToDos/src/main/java/AddButton.png"));
        //trashButton = new JButton(new ImageIcon("/home/doan/Desktop/USTH-SE-2019/ToDos/src/main/java/TrashButton.png"));
        addButton = new JButton(new ImageIcon("/home/doan/Desktop/USTH-SE-2019/ToDos/src/main/java/AddButton.png"));
        trashButton = new JButton(new ImageIcon("/home/doan/Desktop/USTH-SE-2019/ToDos/src/main/java/TrashButton.png"));
        myBox = Box.createVerticalBox();
        myBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        //myBox.setAutoscrolls(true);

        //frame setting
        myFrame.setSize(300, 400);
        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        //panel setting
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
        northPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        northPanel.add(addButton);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(ToDoLabel);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(trashButton);
        northPanel.add(Box.createRigidArea(new Dimension(10, 50)));

        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.add(statusLabel);

        // TodoLabel setting
        ToDoLabel.setFont(new Font("Cooper Black", Font.BOLD, 30));

        //addButton setting
        addButton.setActionCommand("Add Task");
        //addButton.setBounds(15, 10, 25, 25);
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);

        //trashButton setting
        trashButton.setActionCommand("Delete All");
        //trashButton.setBounds(15, 10, 25, 25);
        trashButton.setBorder(BorderFactory.createEmptyBorder());
        trashButton.setContentAreaFilled(false);
        trashButton.setFocusPainted(false);

        //add components to frame
        centerPanel.add(myBox);
        scrollPanel = new JScrollPane(centerPanel);
        scrollPanel.setBorder(null);
        myFrame.add(scrollPanel);

        myFrame.add(southPanel, BorderLayout.SOUTH);
        myFrame.add(northPanel, BorderLayout.NORTH);


    }


    public void addTask(TaskPanel myTaskPanel) {
        taskPanels.add(myTaskPanel);
        myTaskPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        myBox.add(myTaskPanel);
        myFrame.setVisible(true);
    }

    /*public void addNewTask(Task myTask){
        TaskPanel taskPanel = new TaskPanel(myTask.getContent());
        taskPanel.setLineWrap(true);
        taskPanel.setWrapStyleWord(true);
        Border taskPanelBorder = BorderFactory.createLineBorder(Color.BLUE,1);
        taskPanel.setBorder(taskPanelBorder);
        myBox.add(taskPanel);
        myBox.add(Box.createRigidArea(new Dimension(0,5)));
        myFrame.setVisible(true);
    }*/

    public String getInputFromDialog() {
        return JOptionPane.showInputDialog("Enter your plan: ");
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getTrasshButton() {
        return trashButton;
    }

    public JFrame getMyFrame() {
        return myFrame;
    }

    public Box getBox() {
        return myBox;
    }

    public ArrayList<TaskPanel> getTaskPanels() {
        return taskPanels;
    }
    public void DeleteConfirmDialog(Controller me, List model){
        int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete all tasks?", "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Yes button clicked");
            model.clear();
            me.updateView(true);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }
}