package com.jmodifier.ui.command.impl;

import java.io.IOException;
import java.util.jar.JarFile;

import com.jmodifier.archive.Archive;
import com.jmodifier.archive.ArchiveManager;
import com.jmodifier.ui.command.Command;
import com.jmodifier.ui.command.CommandHandler;

/**
 * The "start::" command.
 * 
 * @author Desmond Jackson
 */
public class StartCommand extends Command {

	/**
	 * Creates the "start::" command.
	 * 
	 * @param handler The command handler
	 */
	public StartCommand(CommandHandler handler) {
		super(handler, "start");
	}

	@Override
	public boolean execute(String[] arguments) {
		if (!arguments[0].isEmpty()) {
			try {
				Archive archive = new Archive(new JarFile(arguments[0]));
				if (archive.getMainClassName() != null) {
					ArchiveManager.manage(archive);
					return true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public String getUsage() {
		return "start::[path to executable jar file]";
	}

	@Override
	public String getHelp() {
		return "Starts an exectuable jar file";
	}

}
