import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Task extends JPanel{
    Task me;
    private JCheckBox myCheckBox;
    private JButton removeMe;
    private String content;
    private Calendar dueDate;
    private String state;
    private JTextArea textArea;
    
    // Task constructor
    public Task(String content){
        super();
        me = this;
        this.content = content;
        
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        // Remove me button
        removeMe = new JButton("remove me");
        removeMe.setActionCommand("Remove Me");

        // Checkbox
        myCheckBox = new JCheckBox();
        myCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        myCheckBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(myCheckBox);

        // Check Box content store in a JTextArea
        textArea = new JTextArea(content);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10,10,10,10));
        textArea.setOpaque(false);
        
        add(textArea);
        add(Box.createHorizontalGlue());
        add(removeMe);
        add(Box.createRigidArea(new Dimension(5, 0)));
    }
    public Task(String newContent, int date, int month, int year) {
        this.content = newContent;
        month = month - 1;
        this.dueDate = Calendar.getInstance();
        this.dueDate.set(year, month, date);
        this.dueDate.set(Calendar.HOUR, 0);
        this.dueDate.set(Calendar.MINUTE, 0);
        this.dueDate.set(Calendar.MILLISECOND, 0);

    }

    //add new content
    public void addContent(String newContent) {
        this.content = newContent;
        //return true;
    }

    public void addContent() {
        Scanner scan = new Scanner(System.in);
        content = scan.nextLine();
    }

    //get content
    public String getContent() {
        return this.content;
    }

    //print content in console
    public void printContent() {
        System.out.println(this.content);
    }

    //set state for task
    public void setState(String currentstate) {
        this.state = currentstate;
    }

    //set duedate
    public void setDueDate(int year, int month, int date) {
        month = month - 1;
        this.dueDate = Calendar.getInstance();
        this.dueDate.set(year, month, date);
        this.dueDate.set(Calendar.HOUR, 0);
        this.dueDate.set(Calendar.MINUTE, 0);
        this.dueDate.set(Calendar.MILLISECOND, 0);
    }

    //get DueDate
    public String getDueDate() {
        return this.dueDate.getTime().toString();
    }

    //set state
    public void setState() {
        Calendar today = Calendar.getInstance();
        if (today.compareTo(this.dueDate) > 0) {    //dueDate is after today
            this.state = "Overdue";
        } else if (today.compareTo(this.dueDate) < 0) {  //dueDate is before today
            this.state = "Not done";
        }
        //else this.state="done";
    }

    // get task's state
    public String getState() {
        return this.state;
    }

    

    public JButton getRemoveMe(){
        return removeMe;
    }

}
