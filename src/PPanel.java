import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class PPanel extends JPanel implements MouseListener,MouseMotionListener
{
	int x, x2, y, y2;
	BufferedImage im = null;
	PData pData = null;
	Graphics2D gg = null;
	ArrayList<PShape> list = new ArrayList<>();
	PStatusBar statusBar = null;
	PComand cmd = null;

	public PPanel(PComand cmd)
	{
		this.cmd = cmd;
		pData = cmd.sets;
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void setStatusBar(PStatusBar statusBar)
	{
		this.statusBar = statusBar;
	}
	public void saveToVector(String path) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		fos.close();
		oos.close();
	}

	public void openFromVector(String path) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		list = (ArrayList)ois.readObject();
		fis.close();
		ois.close();
		repaint();
	}
	public void draw(BufferedImage im)
	{
		this.im = im;
		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		gg = (Graphics2D) g;
		gg.drawImage(im, null, 0, 0);
		for(PShape p: list)
		{
			p.draw(gg);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(pData.shape == PShapes.PLine)
		{
			list.add(new PLine(x, y, x2, y2, pData.color.getRGB(), pData.width));
		}

		if(pData.shape == PShapes.PCircle)
		{
			list.add(new PCircle(x,y,x2,y2,pData.color.getRGB(),pData.width));
		}
		if(pData.shape == PShapes.PRect)
		{
			list.add(new PRect(x,y,x2,y2,pData.color.getRGB(),pData.width));
		}
		if(pData.shape == PShapes.PRoundRect)
		{
			list.add(new PRoundRect(x, y, x2, y2, pData.color.getRGB(), pData.width));
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		x2 = e.getX();
		y2 = e.getY();
		if(pData.shape==PShapes.PCurve)
		{
			list.add((new PLine(x,y,x2,y2,pData.color.getRGB(),pData.width)));
			repaint();
			x = x2;
			y = y2;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		statusBar.setStatus("X: "+e.getX()+"  "+"Y: "+e.getY());
	}
}
