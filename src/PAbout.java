import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PAbout extends JDialog implements ActionListener
{

    public PAbout()
    {
        setTitle("About");
        setBounds(250,250,250,100);
        JLabel label = new JLabel("Version Painter 1.0");
        label.setFont(Font.getFont("Verdana"));
        JButton button = new JButton("OK");
        add(BorderLayout.CENTER,label);
        add(BorderLayout.SOUTH,button);

        button.addActionListener(this);
        setModal(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
}
