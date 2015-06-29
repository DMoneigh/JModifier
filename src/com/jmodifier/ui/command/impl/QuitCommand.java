package com.jmodifier.ui.command.impl;

import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "quit::" command.
 * 
 * @author Desmond Jackson
 */
public class QuitCommand extends Command {

	/**
	 * Creates the "quit::" command.
	 * 
	 * @param handler The command handler
	 */
	public QuitCommand(CommandHandler handler) {
		super(handler, "quit");
	}

	@Override
	public boolean execute(String[] arguments) {
		System.exit(0);
		return true;
	}

	@Override
	public String getUsage() {
		return "quit::";
	}

	@Override
	public String getHelp() {
		return "Quits the application.";
	}

}
