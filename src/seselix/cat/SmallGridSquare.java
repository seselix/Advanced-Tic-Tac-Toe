package seselix.cat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SmallGridSquare extends JLabel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private int active = 0;
	public final static int _NOTHING = 0;
	public final static int _O = 1;
	public final static int _X = 2;

	private static BufferedImage X;
	// private static BufferedImage O;

	private JLabel imageLabel;

	private JButton button;

	private boolean largeSquareHas3 = false;

	public SmallGridSquare()
	{
		super();
		setLayout(new BorderLayout());
		setSize(200 / 3, 200 / 3);
		setOpaque(false);

		button = new JButton();
		button.addActionListener(this);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		add(button, BorderLayout.CENTER);

		updateImage();
	}

	public int getActive()
	{
		return active;
	}

	/**
	 * Sets the active image for which to be applied in the updateImage() function
	 * 
	 * @param active Must be one of the final members of the Small grid class, 0, 1,
	 *               2
	 */
	public void setActive(int active)
	{
		this.active = active;
	}

	private void getImageX()
	{
		try
		{
			X = ImageIO.read(new File("resources/X.png"));
			imageLabel = new JLabel(new ImageIcon(X));
			add(imageLabel, BorderLayout.CENTER);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	private void getImageO()
	{
		try
		{
			X = ImageIO.read(new File("resources/O.png"));
			imageLabel = new JLabel(new ImageIcon(X));
			add(imageLabel, BorderLayout.CENTER);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public void updateImage()
	{
		if (!largeSquareHas3 || active == 0)
		{
			switch (active)
			{
			case 0:
				removeAll();
				add(button);
				return;
			case 1:
				remove(button);
				getImageO();
				return;
			case 2:
				remove(button);
				getImageX();
				return;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!largeSquareHas3)
		{
			System.out.println("Clicked");
			if (GameGrid.getTurn())
			{
				setActive(_X);
				updateImage();
			} else if (!GameGrid.getTurn())
			{
				setActive(_O);
				updateImage();
			}
			GameGrid.checkSmallGridsFor3();
			revalidate();
			repaint();
			GameGrid.changeTurn();
			GameGrid.getLastMove().setLast(this);
		}
	}

	/**
	 * 
	 * @return Returns 0, 1, or 2. No Image, "O" or "X" respectively
	 */
	public int getCurrentImage()
	{
		return active;
	}

	public boolean isLargeSquareHas3()
	{
		return largeSquareHas3;
	}

	public void setLargeSquareHas3(boolean largeSquareHas3)
	{
		this.largeSquareHas3 = largeSquareHas3;
	}
}
