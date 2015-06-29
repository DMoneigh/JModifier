package com.jmodifier.ui.command.impl;

import com.jmodifier.archive.ArchiveManager;
import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "set::" command.
 * 
 * @author Desmond Jackson
 */
public class SetCommand extends Command {

	/**
	 * Creates the "set::" command.
	 * 
	 * @param handler The command handler
	 */
	public SetCommand(CommandHandler handler) {
		super(handler, "set");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (arguments.length >= 3) {
			if (ArchiveManager.isManaging()) {
				try {
					int i = Integer.parseInt(arguments[2]);
					ArchiveManager.setVariableValue(arguments[0], arguments[1], i);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				ArchiveManager.setVariableValue(arguments[0], arguments[1], arguments[2]);
			} else {
				handler.getConsole().append("No archive is being managed!");
			}
		} else
			return false;
		return true;
	}

	@Override
	public String getUsage() {
		return "set::[parent class name] [variable name] [value]";
	}

	@Override
	public String getHelp() {
		return "Sets a variable value";
	}

}
