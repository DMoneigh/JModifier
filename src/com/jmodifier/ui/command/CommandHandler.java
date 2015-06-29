package com.jmodifier.ui.command;

import com.jmodifier.ui.ConsoleTextArea;
import com.jmodifier.ui.command.impl.ClearCommand;
import com.jmodifier.ui.command.impl.CommandsCommand;
import com.jmodifier.ui.command.impl.FindCommand;
import com.jmodifier.ui.command.impl.GetCommand;
import com.jmodifier.ui.command.impl.QuitCommand;
import com.jmodifier.ui.command.impl.SetCommand;
import com.jmodifier.ui.command.impl.StartCommand;
import com.jmodifier.ui.command.impl.VariablesCommand;

/**
 * The command handler.
 * 
 * @author Desmond Jackson
 */
public class CommandHandler extends Object {
	
	/**
	 * The console.
	 */
	private ConsoleTextArea console;
	
	/**
	 * An array of usable commands.
	 */
	private Command[] commands = new Command[] {
			new ClearCommand(this), new CommandsCommand(this), new FindCommand(this), new GetCommand(this),
			new QuitCommand(this), new SetCommand(this), new StartCommand(this), new VariablesCommand(this)
	};
	
	/**
	 * Creates the command handler.
	 * 
	 * @param console The console
	 */
	public CommandHandler(ConsoleTextArea console) {
		super();
		this.console = console;
	}
	
	/**
	 * Handles a received command.
	 * 
	 * @param name The command name
	 * 
	 * @param arguments The command arguments
	 */
	public void handle(String name, String[] arguments) {
		for (Command command : commands)
			if (command.getName().equalsIgnoreCase(name)) {
				if (!command.execute(arguments))
					console.append("Usage - " + command.getUsage());
				return;
			}
		console.append("Unknown Command.. Type \"commands::\" for a list of commands.");
	}
	
	/**
	 * Gets the array of usable commands.
	 * 
	 * @return The array of usable commands
	 */
	public Command[] getCommands() {
		return commands;
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
