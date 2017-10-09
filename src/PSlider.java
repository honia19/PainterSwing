import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladislav on 30.06.2017.
 */
public class PSlider extends JDialog
{
    PData pData = null;
    public PSlider(PData pData)
    {

        setTitle("Slider");
        this.pData=pData;
        setBounds(50,50,250,250);
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
        JButton button = new JButton("OK");

        add(BorderLayout.SOUTH,button);

        button.addActionListener(new ClassOK());
        slider.addChangeListener(new ChangeSlider());

        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);
        setModal(true);
        setVisible(true);
    }
    class ClassOK implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
    }
    class ChangeSlider implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e)
        {
            JSlider source = (JSlider)e.getSource();
            pData.width=source.getValue();
        }
    }
}
