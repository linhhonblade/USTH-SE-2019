import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Controller {
    protected View view;
    protected List model;
    
    public Controller(List model, View view){
        this.model = model;
        this.view = view;
    }
    public void setListener(){
        view.getAddButton().addActionListener(new ClickButtonAction());
        view.getTrasshButton().addActionListener(new ClickButtonAction());
    }

    private class ClickButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("Add Task")){
                String textBox = view.getInputFromDialog();
                Task myTask = new Task(textBox);
                model.add(myTask);
                view.updateView(model);
            }
            else if (command.equals("Delete All")){
                model.clear();
                view.updateView(model);
            }
        }
    }
}