import javax.swing.*;
import java.awt.*;


public class PButtonPanel extends JPanel
{
    public PButtonPanel(PComand cmd)
    {
        JButton curve = new JButton("Curve");
        JButton line = new JButton("Line");
        JButton circle = new JButton("Circle");
        JButton rect = new JButton("Rect");
        JButton roundRect = new JButton("RoundRect");
        JButton green = new JButton("Green");
        JButton blue = new JButton("Blue");
        JButton red = new JButton("Red");
        JButton width10 = new JButton("Width10");
        JButton width40 = new JButton("Width40");
        JButton width60 = new JButton("Width60");
        JButton addTab = new JButton("AddTab");
        JButton delTab = new JButton("DelTab");

        add(line);
        add(curve);
        add(circle);
        add(rect);
        add(roundRect);
        add(green);
        add(red);
        add(blue);
        add(width10);
        add(width40);
        add(width60);
        add(addTab);
        add(delTab);

        red.addActionListener(cmd.clRed);
        blue.addActionListener(cmd.clBlue);
        green.addActionListener(cmd.clGreen);
        width10.addActionListener(cmd.width10);
        width40.addActionListener(cmd.width40);
        width60.addActionListener(cmd.width60);
        addTab.addActionListener(cmd.tab);
        delTab.addActionListener(cmd.removeTab);

        curve.addActionListener(cmd.curve);
        rect.addActionListener(cmd.rect);
        roundRect.addActionListener(cmd.roundRect);
        circle.addActionListener(cmd.circle);
        line.addActionListener(cmd.line);

        setLayout(new GridLayout(6,2,40,40));

    }
}
