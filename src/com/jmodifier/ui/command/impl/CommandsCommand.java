package com.jmodifier.ui.command.impl;

import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "commands::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandsCommand extends Command {

	/**
	 * Creates the "commands::" command.
	 * 
	 * @param handler The command handler
	 */
	public CommandsCommand(CommandHandler handler) {
		super(handler, "commands");
	}

	@Override
	public boolean execute(String[] arguments) {
		for (Command command : handler.getCommands())
			handler.getConsole().append(command.getName() + ":: - " + command.getHelp());
		return true;
	}

	@Override
	public String getUsage() {
		return "commands::";
	}

	@Override
	public String getHelp() {
		return "Lists all usable commands.";
	}

}
