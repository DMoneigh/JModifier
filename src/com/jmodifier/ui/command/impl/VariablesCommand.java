package com.jmodifier.ui.command.impl;

import com.jmodifier.archive.ArchiveManager;
import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "variables::" command.
 * 
 * @author Desmond Jackson
 */
public class VariablesCommand extends Command {

	/**
	 * Creates the "variables::" command.
	 * 
	 * @param handler The command handler
	 */
	public VariablesCommand(CommandHandler handler) {
		super(handler, "variables");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (ArchiveManager.isManaging()) {
			for (String sig : ArchiveManager.getVariableSignatures())
				handler.getConsole().append(sig);
		} else {
			handler.getConsole().append("No archive is being managed!");
		}
		return true;
	}

	@Override
	public String getUsage() {
		return "variables::";
	}

	@Override
	public String getHelp() {
		return "Lists all usable variables.";
	}

}
