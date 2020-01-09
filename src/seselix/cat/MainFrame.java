/*
 * Things to add:
 * Game functionality -
 * 		Board
 * 			X and O - turns and moves
 * 			Use the layered pane, with 9 panes in the grid format, each with 9 more panes as well. 
 * 		Develop Save file format
 * 			save turn and what is where in terms of moves
 * 			save names and date of game
 * 		Develop logic to read and start games from files
 * 		Computer AI logic - start with random moves
 */
package seselix.cat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;

	private JMenu file;
	private JMenuItem newGame;
	private JMenuItem openGame;
	private JMenuItem saveGame;
	private JMenuItem saveGameAs;
	private JMenuItem exit;

	private JMenu edit;
	private JMenuItem undo;
	private JMenuItem redo;
	private JMenuItem preferences;

	private JMenu computer;
	private JMenuItem difficulty;

	private JMenu help;
	private JMenuItem howToPlay;
	private JMenuItem about;

	public InfoPanel infoPanel;
	public static NewGameFrame newGameFrame;

	private GameLayeredPane gamePane;

	
	// TODO AI
	// TODO 
	public MainFrame()
	{
		super("C.A.T.");

		setLayout(new BorderLayout());

		setVisible(true);
		setSize(616, 710);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		///////////////////////// IAMGE ////////////////////////////////////

		// TODO change to layered pane to make buttons on top or something like that to
		// create game functionality

		gamePane = new GameLayeredPane();
		gamePane.setPreferredSize(new Dimension(600, 600));
		gamePane.setSize(getPreferredSize());

		///////////////////////// INFORMATION PANEL ////////////////////////

		infoPanel = new InfoPanel();
		infoPanel.setPlayer1Name("");
		infoPanel.setPlayer2Name("");
		infoPanel.updateNames();

		///////////////////////// NEW GAME FRAME PANEL /////////////////////

		newGameFrame = new NewGameFrame();
		newGameFrame.setNameListener(new NameListener() {
			@Override
			public void nameEntered(String name, String name2)
			{
				infoPanel.removeNames();
				infoPanel.setPlayer1Name(name);
				infoPanel.setPlayer2Name(name2);
				infoPanel.updateNames();
			}
		});

		///////////////////////// MENU BAR /////////////////////////////////

		menuBar = new JMenuBar();

		// -----------------------------------------------------------------

		file = new JMenu("File");
		menuBar.add(file);
		initFileMenuItems();

		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newGameFrame.setVisible(true);
			}
		});

		// File::Exit actions
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		// -----------------------------------------------------------------

		edit = new JMenu("Edit");
		menuBar.add(edit);
		initEditMenuItems();

		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameGrid.changeTurn();
				SmallGridSquare last = GameGrid.getLastMove().getLast();
				last.setActive(SmallGridSquare._NOTHING);
				last.updateImage();
				revalidate();
				repaint();
			}
		});

		// -----------------------------------------------------------------

		computer = new JMenu("Computer");
		menuBar.add(computer);
		initAIMenu();

		// -----------------------------------------------------------------

		help = new JMenu("Help");
		menuBar.add(help);
		initHelpMenu();

		// Help::How To Play menu actions
		howToPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new HelpFrame();
			}
		});

		// Help::About Menu actions
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new AboutFrame();
			}
		});

		///////////////////////// MENU BAR /////////////////////////////////

		add(menuBar, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.CENTER);
		add(gamePane, BorderLayout.PAGE_END);
	}

	private void initFileMenuItems()
	{
		newGame = new JMenuItem("New Game");
		openGame = new JMenuItem("Open Game");
		saveGame = new JMenuItem("Save Game");
		saveGameAs = new JMenuItem("Save Game As...");
		exit = new JMenuItem("Exit");

		file.add(newGame);
		file.add(openGame);
		file.addSeparator();
		file.add(saveGame);
		file.add(saveGameAs);
		file.addSeparator();
		file.add(exit);
	}

	private void initEditMenuItems()
	{
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		preferences = new JMenuItem("Preferences");

		edit.add(undo);
		edit.add(redo);
		edit.addSeparator();
		edit.add(preferences);
	}

	private void initAIMenu()
	{
		difficulty = new JMenuItem("Difficulty");

		computer.add(difficulty);
	}

	private void initHelpMenu()
	{
		howToPlay = new JMenuItem("How To Play");
		about = new JMenuItem("About");

		help.add(howToPlay);
		help.add(about);
	}
}
