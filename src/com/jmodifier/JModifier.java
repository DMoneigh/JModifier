package com.jmodifier;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jmodifier.ui.ModifierFrame;

/**
 * A Java variable editor.
 * 
 * @author Desmond Jackson
 */
public class JModifier extends Object {
	
	/**
	 * The major version.
	 */
	public static final int VERSION_MAJOR = 0;

	/**
	 * The minor version.
	 */
	public static final int VERSION_MINOR = 1;

	/**
	 * The main method.
	 * 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException
						| InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				new ModifierFrame().setVisible(true);
			}

		});
	}

}
