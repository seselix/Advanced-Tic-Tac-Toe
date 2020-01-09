package seselix.cat;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameLayeredPane extends JLayeredPane
{
	private static final long serialVersionUID = 1L;

	private BufferedImage whiteGrid;
	private JLabel whiteGridLabel;

	private GameGrid gameGrid;

	public GameLayeredPane()
	{
		super();

		setPreferredSize(new Dimension(600, 600));

		try
		{
			whiteGrid = ImageIO.read(new File("resources/white_grid.png"));
			whiteGridLabel = new JLabel(new ImageIcon(whiteGrid));
			whiteGridLabel.setSize(whiteGridLabel.getPreferredSize());
			add(whiteGridLabel);
			setPosition(whiteGridLabel, 1);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		gameGrid = new GameGrid();
		add(gameGrid);
		gameGrid.setSize(gameGrid.getPreferredSize());
		setPosition(gameGrid, 0);
	}
}
