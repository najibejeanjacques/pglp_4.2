package tp_gl;
import tp_gl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import Exception.*;

public class Undo implements GeneriqueCommand {
	private HashMap<String,Command> history;
	public String name;

	/**
	 * 
	 * @param mapCommand qui est une map de commande 
	 */
	public Undo(HashMap<String, Command> mapCommand) {
		// TODO Auto-generated constructor stub
		this.history = mapCommand;
	}

	/***
	 * Méthode execute de Undo qui est une commande Générique 
	 */
	public void execute() {
		List<String> list = new ArrayList<String>(history.keySet());
		history.remove(list.get(list.size()-1));
	}
	
	

}
