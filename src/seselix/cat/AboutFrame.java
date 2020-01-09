package seselix.cat;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JTextArea aboutArea;

	public AboutFrame()
	{
		super("About C.A.T.");
		
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		aboutArea = new JTextArea();
		aboutArea.setEditable(false);
		aboutArea.append("This is the about menu. \nMake this better.");
		
		add(aboutArea, BorderLayout.CENTER);
	}
}
