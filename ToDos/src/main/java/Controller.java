import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Controller {
    protected Controller me;
    protected View view;
    protected List model;

    public Controller(List model, View view){
        me = this;
        this.model = model;
        this.view = view;
    }
    public void setListener(){
        view.getAddButton().addActionListener(new ClickButtonAction());
        view.getTrasshButton().addActionListener(new ClickButtonAction());
        
    }

    public void updateView(boolean isFirstTime){
        if(isFirstTime==true){
            view.getBox().removeAll();
            for(Task task : model){
                task.getRemoveMe().addActionListener(new ClickButtonAction());
                view.addTask(task);
            }
            view.getMyFrame().setVisible(true);
            
        } else {
            view.getMyFrame().setVisible(true);
        }
    }

    private class ClickButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("Add Task")){
                String textBox = view.getInputFromDialog();
                if(textBox.length() != 0){
                    Task myTask = new Task(textBox);
                    myTask.getRemoveMe().addActionListener(new ClickButtonAction());
                    model.add(myTask);
                    model.showList();
                }
            }

            else if (command.equals("Delete All")){
                model.clear();
                me.updateView(true);
            }
            else if (command.equals("Remove Me")){
                JButton source = (JButton)e.getSource();
                model.remove(source.getParent());
                me.updateView(true);
                model.showList();
            }
        }
    }
}