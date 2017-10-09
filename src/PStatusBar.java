import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class PStatusBar extends JPanel
{
     static JLabel status = new JLabel();

    public PStatusBar(String s)
    {
        setLayout(new BorderLayout());
        status.setText(s);
        status.setBorder(new EtchedBorder());
        add(status, BorderLayout.SOUTH);
    }

    public static void setStatus(String s)
    {
        status.setText(s);
    }
}
