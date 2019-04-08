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

        removeMe = new JButton(new ImageIcon("/home/doan/Desktop/USTH-SE-2019/ToDos/src/main/java/RemoveButton.png"));
        removeMe.setActionCommand("Remove Me");
        //removeMe.setBounds(15, 10, 25, 25);
        removeMe.setBorder(BorderFactory.createEmptyBorder());
        removeMe.setContentAreaFilled(false);
        //removeMe.setFocusPainted(false);
        removeMe.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Checkbox
        myCheckBox = new JCheckBox();
        myCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        myCheckBox.setAlignmentY(Component.CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(5, 0)));
        add(myCheckBox);

        textArea = new JTextArea(content, 1, 15);
        //textArea.setBounds();
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


}