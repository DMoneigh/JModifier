package com.jmodifier.ui.command.impl;

import com.jmodifier.archive.ArchiveManager;
import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "get::" command.
 * 
 * @author Desmond Jackson
 */
public class GetCommand extends Command {

	/**
	 * Creates the "get::" command.
	 * 
	 * @param handler The command handler
	 */
	public GetCommand(CommandHandler handler) {
		super(handler, "get");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (arguments.length >= 2) {
			if (ArchiveManager.isManaging()) {
				handler.getConsole().append("" + ArchiveManager.getVariableValue(arguments[0], arguments[1]));
			} else {
				handler.getConsole().append("No archive is being managed!");
			}
		} else
			return false;
		return true;
	}

	@Override
	public String getUsage() {
		return "get:[parent class name] [variable name]";
	}

	@Override
	public String getHelp() {
		return "Gets the value of a variable.";
	}

}
