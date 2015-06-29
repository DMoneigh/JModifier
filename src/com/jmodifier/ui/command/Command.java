package com.jmodifier.ui.command;

/**
 * Represents a command.
 * 
 * @author Desmond Jackson
 */
public abstract class Command extends Object {
	
	/**
	 * The command handler.
	 */
	protected CommandHandler handler;
	
	/**
	 * The command name.
	 */
	private String name;
	
	/**
	 * Creates the command.
	 * 
	 * @param handler The command handler
	 * 
	 * @param name The command name
	 */
	public Command(CommandHandler handler, String name) {
		super();
		this.handler = handler;
		this.name = name;
	}
	
	/**
	 * Executes a command.
	 *  
	 * @param arguments The command arguments
	 * 
	 * @return true if command completed successfully
	 */
	public abstract boolean execute(String[] arguments);
	
	/**
	 * Gets the command usage.
	 * 
	 * @return The command usage
	 */
	public abstract String getUsage();
	
	/**
	 * Gets the command help.
	 * 
	 * @return The command help
	 */
	public abstract String getHelp();
	
	/**
	 * Gets the command name.
	 * 
	 * @return The command name
	 */
	public String getName() {
		return name;
	}

}
