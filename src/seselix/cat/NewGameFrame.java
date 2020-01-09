/*
 * -Need to have a cancel and OK button
 * -Get names of both players
 */
package seselix.cat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// TODO Create functionality to add names to save game
public class NewGameFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JButton testNG = new JButton("Test");

	private NameListener nameListener;

	public NewGameFrame()
	{
		super("New Game");

		setVisible(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		add(testNG, BorderLayout.CENTER);

		testNG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Changing name");
				nameListener.nameEntered("Robby", "Felicity");

				for (int i = 0; i < 9; i++)
				{
					for (int j = 0; j < 9; j++)
					{
						GameGrid.largeGridSquares[i].setImageOfSmall(j, 0);
						GameGrid.largeGridSquares[i].setImage(0);
						GameGrid.enableSmallSquares(i);
					}
				}

				setVisible(false);

				/*
				 * TODO Should also reset board, and possibly add option to save previous game
				 */
			}
		});
	}

	public void setNameListener(NameListener nameListener)
	{
		this.nameListener = nameListener;
	}
}
