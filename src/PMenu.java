import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PMenu extends JMenuBar
{
    PComand cmd = null;
    PPanel painerPanel = null;
    public PMenu(PComand cmd, PPanel painterPanel)
    {

        this.cmd = cmd;
        this.painerPanel = painterPanel;
        add(createFileMenu());
        add(createFileColor());
        add(createFileWidth());
        add(createFileDrawMenu());
        add(createFileTabed());
        add(createFileAbout());

    }
    private JMenu createFileTabed()
    {
    	JMenu tab = new JMenu("Open Tab");
    	JMenuItem addTab = new JMenuItem("Add Tab");
    	tab.add(addTab);
    	addTab.addActionListener(cmd.tab);
    	return tab;
	}
    private JMenu createFileMenu()
    {
        JMenu file = new JMenu("File");
        JMenuItem saveToVector = new JMenuItem("SaveToVector");
        JMenuItem saveToRastr = new JMenuItem("SaveToRastr");
        JMenuItem openInVector= new JMenuItem("OpenInVector");
        JMenuItem openInRastr = new JMenuItem("OpenInRastr");
        JMenuItem exit = new JMenuItem("Exit");

        file.add(saveToRastr);
        file.add(saveToVector);
        file.add(openInRastr);
        file.add(openInVector);
        file.addSeparator();
        file.add(exit);

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

        openInRastr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BufferedImage image = new BufferedImage(728, 537, BufferedImage.TYPE_INT_RGB);
                cmd.openInRastr.actionPerformed(e);
                image = cmd.openInRastr.getImage();
                painerPanel.draw(image);
            }
        });
        saveToRastr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BufferedImage image = new BufferedImage(728, 537, BufferedImage.TYPE_INT_RGB);
                painerPanel.paint(image.getGraphics());
                cmd.saveToRastr.setImage(image);
                cmd.saveToRastr.actionPerformed(e);
            }
        });

        return file;
    }


    private JMenu createFileAbout()
    {
        JMenu about = new JMenu("About");
        JMenuItem content = new JMenuItem("About");
        content.addActionListener(cmd.about);
        about.add(content);
        return about;
    }
    private  JMenu createFileColor()
    {
        JMenu color = new JMenu("Color");
        JMenuItem red1 = new JMenuItem("Red");
        JMenuItem blue = new JMenuItem("Blue");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem choose = new JMenuItem("Choose");

        color.add(red1);
        color.add(blue);
        color.add(green);
        color.addSeparator();
        color.add(choose);

        red1.addActionListener(cmd.clRed);
        blue.addActionListener(cmd.clBlue);
        green.addActionListener(cmd.clGreen);
        choose.addActionListener(cmd.choose);
        return color;
    }
    private  JMenu createFileDrawMenu()
    {
        JMenu draw = new JMenu("Draw Figure");
        JMenuItem line = new JMenuItem("Line");
        JMenuItem rect = new JMenuItem("Rect");
        JMenuItem roundrect = new JMenuItem("Round Rect");
        JMenuItem circle = new JMenuItem("Circle");
        JMenuItem curve = new JMenuItem("Curve");

        draw.add(line);
        draw.add(rect);
        draw.add(roundrect);
        draw.add(circle);
        draw.add(curve);

        line.addActionListener(cmd.line);
        rect.addActionListener(cmd.rect);
        roundrect.addActionListener(cmd.roundRect);
        circle.addActionListener(cmd.circle);
        curve.addActionListener(cmd.curve);
        return draw;
    }
    private JMenu createFileWidth()
    {
        JMenu width = new JMenu("Width");
        JMenuItem width10 = new JMenuItem("Width 10");
        JMenuItem width40 = new JMenuItem("Width 40");
        JMenuItem width60 = new JMenuItem("Width 60");
        JMenuItem chooseWidth = new JMenuItem("Choose Width");

        width.add(width10);
        width.add(width40);
        width.add(width60);
        width.addSeparator();
        width.add(chooseWidth);

        width10.addActionListener(cmd.width10);
        width40.addActionListener(cmd.width40);
        width60.addActionListener(cmd.width60);
        chooseWidth.addActionListener(cmd.chooseWidth);
        return width;
    }
}

