package seselix.cat;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HelpFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JTextArea helpArea;
	
	public HelpFrame()
	{
		super("How To Play");

		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		
		helpArea = new JTextArea();
		helpArea.setEditable(false);
		helpArea.append("This is the Help Area. \nWIP finish this.");
		
		add(helpArea, BorderLayout.CENTER);
	}

}
