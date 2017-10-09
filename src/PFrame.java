import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.*;

public class PFrame extends JFrame 
{
	PComand cmd = null;
	PPanel painerPanel = null;
	PMenu pMenu = null;
	JTabbedPane jTabbedPane;
	public PFrame()
	{
		setTitle("Paint Universal");
		setBounds(50, 50, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		PData pData = new PData();
		jTabbedPane = new JTabbedPane();
		cmd = new PComand(pData,this,jTabbedPane);
		
		painerPanel = new PPanel(cmd);
		add(BorderLayout.CENTER,painerPanel);
		
		PButtonPanel pButtonPanel = new PButtonPanel(cmd);
		add(BorderLayout.WEST,pButtonPanel);


		PToolBar pToolBar = new PToolBar(cmd,painerPanel);
		add(BorderLayout.PAGE_START,pToolBar);
		
		PStatusBar statusBar = new PStatusBar("Mouse Move");
		add(BorderLayout.PAGE_END,statusBar);
		//painerPanel.setStatusBar(statusBar);

		setJMenuBar(new PMenu(cmd,painerPanel));
		add(jTabbedPane);
		setVisible(true);
	}
}
