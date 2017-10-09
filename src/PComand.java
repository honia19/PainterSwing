import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PComand
{
    PData sets = null;
    PFrame frame = null;
	JTabbedPane tabs = null;
	
    ColorRed clRed = new ColorRed();
    ColorBlue clBlue = new ColorBlue();
    ColorGreen clGreen = new ColorGreen();
    Width10 width10 = new Width10();
    Width40  width40= new Width40();
    Width60 width60 = new Width60();
    RoundRect roundRect = new RoundRect();
    Rect rect = new Rect();
    Circle circle = new Circle();
    Line line = new Line();
    Curve curve = new Curve();
    About about = new About();
    Choose choose = new Choose();
    SliderDialog chooseWidth = new SliderDialog();
    SaveToRastr saveToRastr = new SaveToRastr();
    OpenInRastr openInRastr = new OpenInRastr();
    Exit exit = new Exit();
    AddTab tab = new AddTab();
    RemoveTab removeTab = new RemoveTab();
    
    int i = 1;
    ArrayList<PPanel> listOfPanels = new ArrayList<PPanel>();
    
   public PComand(PData sets,PFrame frame,JTabbedPane tabs)
	{
		this.sets = sets;
		this.frame = frame;
		this.tabs = tabs;
	}

    class AddTab implements ActionListener
    {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			listOfPanels.add(new PPanel(frame.cmd));
			tabs.addTab("Tab "+i++, listOfPanels.get(listOfPanels.size()-1));	
		}
    }
    class RemoveTab implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int select = tabs.getSelectedIndex();
            if (select >= 0)
            {
               tabs.removeTabAt(select);
            }
		
		}
	}
    class Exit implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            System.exit(0);
        }

    }

    class OpenInRastr implements ActionListener
    {
        BufferedImage image = null;

        public BufferedImage getImage()
        {
            return image;
        }

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            try
            {
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    FileInputStream out = new FileInputStream(fc.getSelectedFile());
                    image = ImageIO.read(out);
                    out.close();
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    class SaveToRastr implements ActionListener
    {
        RenderedImage image = null;
        public void setImage(RenderedImage image)
        {
            this.image=image;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fc = new JFileChooser();
            int resault = fc.showSaveDialog(null);
            if (resault==JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    FileOutputStream out = new FileOutputStream(fc.getSelectedFile());
                    ImageIO.write(image,"png",out);
                    out.close();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    class SliderDialog implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            PSlider pSlider = new PSlider(sets);
        }
    }
    class Choose implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JColorChooser jColorChooser = new JColorChooser();
            Color color = jColorChooser.showDialog(null,"Color",Color.cyan);
            sets.color = color;
        }
    }

    class About implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            PAbout about = new PAbout();
        }
    }
    class RoundRect implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.shape=PShapes.PRoundRect;

        }
    }
    class Rect implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.shape=PShapes.PRect;

        }
    }
    class Line implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.shape=PShapes.PLine;

        }
    }
    class Curve implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.shape=PShapes.PCurve;

        }
    }
    class Circle implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.shape=PShapes.PCircle;

        }
    }

    class ColorRed implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.color= Color.RED;

        }
    }
    class ColorBlue implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.color= Color.BLUE;

        }
    }
    class ColorGreen implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.color= Color.GREEN;

        }
    }
    class Width10 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.width=10;

        }
    }
    class Width40 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.width=40;

        }
    }
    class Width60 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            sets.width=60;

        }
    }

}
