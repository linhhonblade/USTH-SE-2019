package com.todo.view;

import java.awt.*;
import javax.swing.*;

public class TaskPanel extends JPanel {
    TaskPanel me;
    private JCheckBox myCheckBox;
    private JButton removeMe;
    private JTextArea textArea;

    public TaskPanel(String content) {
        super();
        me = this;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        // removeMe button setting
        removeMe = new JButton(new ImageIcon("icons/RemoveButton.png"));
        removeMe.setActionCommand("Remove Me");
        removeMe.setBorder(BorderFactory.createEmptyBorder());
        removeMe.setContentAreaFilled(false);
        removeMe.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Checkbox
        myCheckBox = new JCheckBox();
        myCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        myCheckBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(myCheckBox);

        // TextArea setting to contain task
        textArea = new JTextArea(content, 1, 15);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setOpaque(false);
        add(textArea);
        add(Box.createHorizontalGlue());
        add(removeMe);
        add(Box.createRigidArea(new Dimension(5, 0)));
    }

    public JButton getRemoveMe() {
        return removeMe;
    }

    public JCheckBox getMyCheckBox(){
        return myCheckBox;
    }
}