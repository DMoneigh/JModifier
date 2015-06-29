package com.jmodifier.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.jmodifier.JModifier;

/**
 * The "JModifier" frame.
 * 
 * @author Desmond Jackson
 */
public class ModifierFrame extends JFrame {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -2849006693444616790L;
	
	/**
	 * The console.
	 */
	private ConsoleTextArea console = new ConsoleTextArea();
	
	/**
	 * Creates the "JModifier" frame.
	 */
	public ModifierFrame() {
		super("JModifier v" + JModifier.VERSION_MAJOR + "." + JModifier.VERSION_MINOR);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 400);
		add(new JScrollPane(console), BorderLayout.CENTER);
		add(new InputTextField(), BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the console.
	 * 
	 * @return The console
	 */
	public ConsoleTextArea getConsole() {
		return console;
	}

}
