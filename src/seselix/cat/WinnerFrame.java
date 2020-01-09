package seselix.cat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinnerFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JLabel winnerDialogue;
	
	private JButton close;
	private JButton saveGame;
	private JButton newGame;
	private JButton exit;

	public WinnerFrame()
	{
		super("Game Over!");

		setSize(400, 200);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		winnerDialogue = new JLabel(getWinner() + "has won the game!");
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 2;
		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 3;
		add(winnerDialogue, gc);
		
		gc.weighty = .1;
		gc.weightx = .2;
		gc.gridwidth = 1;
		
		close = new JButton("Cancel");
		gc.gridx = 0;
		gc.gridy = 1;
		add(close, gc);
		
		saveGame = new JButton("Save Game");
		gc.gridx = 1;
		gc.gridy = 1;
		add(saveGame, gc);
		
		newGame = new JButton("New Game");
		gc.gridx = 2;
		gc.gridy = 1;
		add(newGame, gc);
		
		exit = new JButton("Exit");
		gc.gridx = 3;
		gc.gridy = 1;
		add(exit, gc);
	
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		
		saveGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Make save game shit");
			}
		});
		
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				MainFrame.newGameFrame.setVisible(true);
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}

	private String getWinner()
	{
		switch (GameGrid.getWinner())
		{
		case 1:
			return (InfoPanel.getPlayer2Name() + " ");
		case 2:
			return (InfoPanel.getPlayer1Name() + " ");
		default:
			return null;
		}
	}
}
