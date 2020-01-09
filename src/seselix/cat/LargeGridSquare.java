package seselix.cat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LargeGridSquare extends JLayeredPane
{
	private static final long serialVersionUID = 1L;

	private SmallGridSquare[] smallGridSquares = new SmallGridSquare[9];
	private JPanel smallPanel;

	private JLabel imageLabel;
	private static BufferedImage image;

	private boolean hasImage = false;
	
	private int activeImage = 0;

	public LargeGridSquare()
	{
		super();

		setPreferredSize(new Dimension(200, 200));
		setSize(getPreferredSize());
		setLayout(new BorderLayout());
		setOpaque(false);

		smallPanel = new JPanel();
		smallPanel.setLayout(new GridLayout(3, 3));
		smallPanel.setPreferredSize(new Dimension(200, 200));
		smallPanel.setSize(smallPanel.getPreferredSize());
		smallPanel.setOpaque(false);
		for (int i = 0; i < 9; i++)
		{
			smallGridSquares[i] = new SmallGridSquare();
			smallPanel.add(smallGridSquares[i]);
			setPosition(smallPanel, 1);
		}
		add(smallPanel);
	}

	/**
	 * Will change the image of the small square. Updates and repaints the UI
	 * 
	 * @param index
	 * @param imageNO
	 */
	public void setImageOfSmall(int index, int imageNO)
	{
		smallGridSquares[index].setActive(imageNO);
		smallGridSquares[index].updateImage();
		smallPanel.revalidate();
		smallPanel.repaint();
		revalidate();
		repaint();
	}

	public SmallGridSquare getSmallGridSquareInArray(int index)
	{
		return smallGridSquares[index];
	}

	private void getImageX()
	{
		try
		{
			image = ImageIO.read(new File("resources/BigX.png"));
			imageLabel = new JLabel(new ImageIcon(image));
			add(imageLabel);
			setPosition(imageLabel, 0);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	private void getImageO()
	{
		try
		{
			image = ImageIO.read(new File("resources/BigO.png"));
			imageLabel = new JLabel(new ImageIcon(image));
			add(imageLabel);
			setPosition(imageLabel, 0);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public void setImage(int active)
	{
		if (!hasImage || active == 0)
		{
			switch (active)
			{
			case 0:
				if(hasImage)
				{
					remove(imageLabel);
				}
				hasImage = false;
				setActiveImage(active);
				revalidate();
				repaint();
				return;
			case 1:
				getImageO();
				hasImage = true;
				setActiveImage(active);
				revalidate();
				repaint();
				GameGrid.checkLargeGridFor3();
				return;
			case 2:
				getImageX();
				hasImage = true;
				setActiveImage(active);
				revalidate();
				repaint();
				GameGrid.checkLargeGridFor3();
				return;
			}
		}
	}
	
	public void setActiveImage(int active)
	{
		this.activeImage = active;
	}
	
	public int getActiveImage()
	{
		return activeImage;
	}

}
