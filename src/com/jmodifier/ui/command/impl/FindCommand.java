package com.jmodifier.ui.command.impl;

import com.jmodifier.archive.ArchiveManager;
import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "find::" command.
 * 
 * @author Desmond Jackson
 */
public class FindCommand extends Command {

	/**
	 * Creates the "find::" command.
	 * 
	 * @param handler The command handler
	 */
	public FindCommand(CommandHandler handler) {
		super(handler, "find");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (!arguments[0].isEmpty()) {
			if (ArchiveManager.isManaging()) {
				try {
					int i = Integer.parseInt(arguments[0]);
					handler.getConsole().append(ArchiveManager.findVariable(i));
					return true;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				handler.getConsole().append(ArchiveManager.findVariable(arguments[0]));
				return true;
			} else {
				handler.getConsole().append("No archive is being managed!");
				return true;
			}
		}
		return false;
	}

	@Override
	public String getUsage() {
		return "find::[value]";
	}

	@Override
	public String getHelp() {
		return "Finds a variable with the same value .";
	}

}
