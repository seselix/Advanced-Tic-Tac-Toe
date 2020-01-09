package seselix.cat;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameGrid extends JPanel
{
	private static final long serialVersionUID = 1L;

	public static LargeGridSquare[] largeGridSquares = new LargeGridSquare[9];

	private static boolean turn = true;

	private static LastMove lastMove = new LastMove();
	
	private static int winningImage = 0;

	public GameGrid()
	{
		super();

		setPreferredSize(new Dimension(600, 600));
		setLayout(new GridLayout(3, 3));
		setOpaque(false);

		for (int i = 0; i < 9; i++)
		{
			largeGridSquares[i] = new LargeGridSquare();
			add(largeGridSquares[i]);
		}
	}

	public static boolean getTurn()
	{
		return turn;
	}

	public static void changeTurn()
	{
		if (turn)
		{
			System.out.println("O's turn");
			turn = false;
		} else if (!turn)
		{
			System.out.println("X's turn");
			turn = true;
		}
	}

	public static LastMove getLastMove()
	{
		return lastMove;
	}

	public static void setLastMove(LastMove lastMove)
	{
		GameGrid.lastMove = lastMove;
	}

	public static void checkSmallGridsFor3()
	{
		LargeGridSquare tempLGS;
		int image = 0;

		if (turn)
		{
			image = SmallGridSquare._X;
		} else if (!turn)
		{
			image = SmallGridSquare._O;
		}

		for (int i = 0; i < 9; i++)
		{
			tempLGS = largeGridSquares[i];
			if (tempLGS.getSmallGridSquareInArray(0).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(1).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(2).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(3).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(4).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(5).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(6).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(7).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(8).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(0).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(3).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(6).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(1).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(4).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(7).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(2).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(5).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(8).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(0).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(4).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(8).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			} else if (tempLGS.getSmallGridSquareInArray(2).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(4).getCurrentImage() == image
					&& tempLGS.getSmallGridSquareInArray(6).getCurrentImage() == image)
			{
				largeGridSquares[i].setImage(image);
				disableSmallSquares(i);
			}
		}
	}

	public static void checkLargeGridFor3()
	{
		int image = 0;

		if (turn)
		{
			image = SmallGridSquare._X;
		} else if (!turn)
		{
			image = SmallGridSquare._O;
		}

		if (largeGridSquares[0].getActiveImage() == image
				&& largeGridSquares[1].getActiveImage() == image
				&& largeGridSquares[2].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[3].getActiveImage() == image
				&& largeGridSquares[4].getActiveImage() == image
				&& largeGridSquares[5].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[6].getActiveImage() == image
				&& largeGridSquares[7].getActiveImage() == image
				&& largeGridSquares[8].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[0].getActiveImage() == image
				&& largeGridSquares[3].getActiveImage() == image
				&& largeGridSquares[6].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[1].getActiveImage() == image
				&& largeGridSquares[4].getActiveImage() == image
				&& largeGridSquares[7].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[2].getActiveImage() == image
				&& largeGridSquares[5].getActiveImage() == image
				&& largeGridSquares[8].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[0].getActiveImage() == image
				&& largeGridSquares[4].getActiveImage() == image
				&& largeGridSquares[8].getActiveImage() == image)
		{
			setWinner(image);
		} else if (largeGridSquares[2].getActiveImage() == image
				&& largeGridSquares[4].getActiveImage() == image
				&& largeGridSquares[6].getActiveImage() == image)
		{
			setWinner(image);
		} 

		if (getWinner() != 0)
		{
			System.out.println("Hello");
			
			for (int i = 0; i < 9; i++)
			{
				disableSmallSquares(i);
			}
			new WinnerFrame();
			setWinner(0);
		}
		
	}

	public static void disableSmallSquares(int indexOfLargeSqaureArray)
	{
		for (int i = 0; i < 9; i++)
		{
			largeGridSquares[indexOfLargeSqaureArray].getSmallGridSquareInArray(i).setLargeSquareHas3(true);
		}
	}

	public static void enableSmallSquares(int indexOfLargeSqaureArray)
	{
		for (int i = 0; i < 9; i++)
		{
			largeGridSquares[indexOfLargeSqaureArray].getSmallGridSquareInArray(i).setLargeSquareHas3(false);
		}
	}
	
	public static void setWinner(int winner)
	{
		winningImage = winner;
	}
	
	public static int getWinner()
	{
		return winningImage;
	}
}
