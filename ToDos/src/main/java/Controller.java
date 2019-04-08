import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static javax.swing.JOptionPane.*;

public class Controller {
    protected Controller me;
    protected View view;
    protected List model;

    public Controller(List model, View view) {
        me = this;
        this.model = model;
        this.view = view;
    }

    public void setListener() {
        view.getAddButton().addActionListener(new ClickButtonAction());
        view.getTrasshButton().addActionListener(new ClickButtonAction());

    }

    public void updateView(boolean isFirstTime) {
        if (isFirstTime == true) {
            view.getBox().removeAll();
            view.getTaskPanels().clear();
            for (Task task : model) {
                TaskPanel newTaskPanel = new TaskPanel(task.getContent());

                newTaskPanel.getRemoveMe().addActionListener(new ClickButtonAction());
                view.addTask(newTaskPanel);
            }
            view.getMyFrame().setVisible(true);

        } else {
            view.getMyFrame().setVisible(true);
        }
    }


    private class ClickButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Add Task")) {
                String textBox = view.getInputFromDialog();
                if (textBox.length() != 0) {
                    Task myTask = new Task(textBox);
                    TaskPanel myTaskPanel = new TaskPanel(textBox);
                    myTaskPanel.getRemoveMe().addActionListener(new ClickButtonAction());
                    model.add(myTask);
                    model.showList();
                    me.updateView(true);
                }
            } else if (command.equals("Delete All")) {
                view.DeleteConfirmDialog(me,model);
                //JDialog.setDefaultLookAndFeelDecorated(true);
                /*int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete all tasks?", "Warning",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    System.out.println("Yes button clicked");
                    model.clear();
                    me.updateView(true);
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }*/

            } else if (command.equals("Remove Me")) {
                JButton source = (JButton) e.getSource();
                int id = view.getTaskPanels().indexOf(source.getParent());
                view.getTaskPanels().remove(source.getParent());
                model.remove(id);
                me.updateView(true);
                model.showList();
            }
        }
    }
}