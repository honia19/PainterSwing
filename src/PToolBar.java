import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class PToolBar extends JToolBar
{
    PComand cmd = null;
    PPanel painerPanel = null;
    public  PToolBar(PComand cmd, PPanel painterPanel)
    {
        this.painerPanel = painterPanel;
        this.cmd = cmd;
        JButton openInVector = new JButton("Open");
        JButton saveToVector = new JButton("Save");
        JButton about = new JButton("About");
        JButton exit = new JButton("Exit");

        openInVector.setIcon(new ImageIcon("icon/folder-icon.png"));
        saveToVector.setIcon(new ImageIcon("icon/save-icon.png"));
        about.setIcon(new ImageIcon("icon/computer-icon.png"));
        exit.setIcon(new ImageIcon("icon/close-icon.png"));

        add(openInVector);
        addSeparator();
        add(saveToVector);
        addSeparator();
        add(about);
        addSeparator();
        add(exit);

        about.addActionListener(cmd.about);
        exit.addActionListener(cmd.exit);

        openInVector.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser dialog = new JFileChooser();
                int result = dialog.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        painerPanel.openFromVector(dialog.getSelectedFile().toString());
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    catch (ClassNotFoundException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });
        saveToVector.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser dialog = new JFileChooser();
                int result = dialog.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        painerPanel.saveToVector(dialog.getSelectedFile().toString());
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
