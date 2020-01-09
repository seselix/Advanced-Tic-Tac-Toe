package seselix.cat;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InfoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JPanel player1;
	private JPanel player2;

	private static String player1Name;
	private static String player2Name;

	private JLabel player1Label;
	private JLabel player2Label;

	public InfoPanel()
	{
		player1 = new JPanel();
		player2 = new JPanel();

		Border player1Border = BorderFactory.createTitledBorder("Player \"X\"");
		player1.setBorder(player1Border);

		Border player2Border = BorderFactory.createTitledBorder("Player \"O\"");
		player2.setBorder(player2Border);

		setLayout(new GridLayout(1, 2));

		add(player1);
		add(player2);

		player1Label = new JLabel();
		player2Label = new JLabel();

		player1.add(player1Label);
		player2.add(player2Label);
	}

	public void setPlayer1Name(String name)
	{
		InfoPanel.player1Name = name;
	}

	public void setPlayer2Name(String name)
	{
		InfoPanel.player2Name = name;
	}

	public void removeNames()
	{
		player1Label.setText(null);
		player2Label.setText(null);

		revalidate();
		repaint();
	}

	public void updateNames()
	{
		player1Label.setText(player1Name);
		player2Label.setText(player2Name);
		revalidate();
		repaint();
	}

	public static String getPlayer1Name()
	{
		return player1Name;
	}
	
	public static String getPlayer2Name()
	{
		return player2Name;
	}
}
