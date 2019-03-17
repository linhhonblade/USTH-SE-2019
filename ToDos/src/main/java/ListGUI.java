import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListGUI extends JFrame implements ActionListener {

    // make a box to add new plan
    private String textBox;

    ListGUI(String title){
        super(title);

        //create "add" button.
        JButton addButton=new JButton(new ImageIcon("C:\\Users\\HP\\Documents\\ICT\\Software Engineering\\USTH-SE-2019\\ToDos\\src\\main\\java\\add.png"));
        addButton.setActionCommand("Add");
        addButton.addActionListener(this);
        addButton.setBounds(15,10,25,25);
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);

        // add function for button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textBox=JOptionPane.showInputDialog("Enter the new plan: ");
//                JOptionPane.showMessageDialog(null,textBox);
                System.out.print(textBox);
            }
        });


        //add "add" Button into frame
        this.add(addButton);
        this.setSize(300,400);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


    }
    public static void main(String[] args) {
        new ListGUI("Todo List");
    }

    public void actionPerformed(ActionEvent e) {
        // do somethings
    }
}