package com.jmodifier.ui.command.impl;

import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "clear::" command.
 * 
 * @author Desmond Jackson
 */
public class ClearCommand extends Command {

	/**
	 * Creates the "clear::" command.
	 * 
	 * @param handler The command handler
	 */
	public ClearCommand(CommandHandler handler) {
		super(handler, "clear");
	}

	@Override
	public boolean execute(String[] arguments) {
		handler.getConsole().setText(null);
		return true;
	}

	@Override
	public String getUsage() {
		return "clear::";
	}

	@Override
	public String getHelp() {
		return "Clears the console text.";
	}

}
