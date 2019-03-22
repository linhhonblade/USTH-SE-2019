import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ListGUI1 {

  // attributes
  private JFrame myFrame;
  private String textBox;
  private List myList;
  private JButton addButton;
  private ArrayList<JTextArea> myTaskBoxes;
  private JPanel listTaskPanel;

  // constructor
  public ListGUI1(String title){
    myFrame = new JFrame(title);
    prepareGUI();
    prepareEvent();
    //create List
    myList = new List();
  }

  // private void showTasks(){
    
  // }

  private void prepareGUI(){
    //create "add" button.
    addButton = new JButton(new ImageIcon("/home/mailovemisa/Desktop/github/linhhonblade/USTH-SE-2019/ToDos/src/main/java/add.png"));
    addButton.setActionCommand("Add Task");
    addButton.setBounds(15,10,25,25);
    addButton.setBorder(BorderFactory.createEmptyBorder());
    addButton.setContentAreaFilled(false);
    addButton.setFocusPainted(false);

    //add "add" Button into frame
    myFrame.add(addButton);
    myFrame.setSize(300,400);
    myFrame.setLayout(null);
    myFrame.setVisible(true);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setLocationRelativeTo(null);

    //create listTaskPanel
    listTaskPanel = new JPanel();
    myFrame.add(listTaskPanel);

    //create myTaskBoxes
    myTaskBoxes = new ArrayList<JTextArea>();
  }

  private void prepareEvent(){
    addButton.addActionListener(new ClickButtonAction());
  }

  // implement ClickButtonAction
  private class ClickButtonAction implements ActionListener{
      public void actionPerformed(ActionEvent e){
          String command = e.getActionCommand();
          if (command.equals("Add Task")){
            String textBox;
            textBox = JOptionPane.showInputDialog("Enter the new plan: ");
            //JOptionPane.showMessageDialog(null,textBox);
            myList.add(new Task(textBox));
            System.out.println("You've successfully added new task: " + textBox);
            myList.showList();
            JTextArea taskBox = new JTextArea(textBox);
            myTaskBoxes.add(taskBox);
            myFrame.add(taskBox);
            taskBox.setVisible(true);
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