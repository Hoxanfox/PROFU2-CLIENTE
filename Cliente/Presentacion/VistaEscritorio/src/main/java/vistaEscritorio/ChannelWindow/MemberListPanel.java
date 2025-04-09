package vistaEscritorio.ChannelWindow;

import javax.swing.*;
import java.awt.*;

public class MemberListPanel extends JPanel {

    private JLabel memberLabel;

    public MemberListPanel(String[] members) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        String memberText = "Members: " + String.join(", ", members) + " (" + members.length + ")";
        memberLabel = new JLabel(memberText);
        add(memberLabel);
    }
}
