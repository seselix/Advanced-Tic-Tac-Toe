package seselix.cat;

import javax.swing.SwingUtilities;

public class AdvancedTTT
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new MainFrame();
			}
		});
	}
}
