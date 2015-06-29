package com.jmodifier.ui;

import javax.swing.JTextArea;

import com.jmodifier.JModifier;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The console.
 * 
 * @author Desmond Jackson
 */
public class ConsoleTextArea extends JTextArea {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -1157226512996528768L;
	
	/**
	 * The command handler.
	 */
	private CommandHandler handler = new CommandHandler(this);
	
	/**
	 * Creates the console text area.
	 */
	public ConsoleTextArea() {
		super();
		setEditable(false);
		append("Welcome to JModifier v" + JModifier.VERSION_MAJOR + "." + JModifier.VERSION_MINOR + "!");
	}
	
	/**
	 * Gets the command handler.
	 * 
	 * @return The command handler
	 */
	public CommandHandler getHandler() {
		return handler;
	}
	
	@Override
	public void append(String string) {
		super.append(string + "\n");
	}
	

}
