package tp_gl;

import java.awt.DisplayMode;
import java.nio.channels.IllegalSelectorException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class Interpreter {
	protected final HashMap<String, Command> mapCommand = new HashMap<String, Command>();
	
	public void register(String nom,Command command)
	{
		mapCommand.put(nom, command);
	}
	
	public void execute(String commandName)
	{
		Command command = mapCommand.get(commandName);
		if(command == null)
		{
			throw new IllegalStateException("Pas de commande enregistré pour "+commandName);
		}
		else
		{
			command.execute();
		}
	}
	
}
