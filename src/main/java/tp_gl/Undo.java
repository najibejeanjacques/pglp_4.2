package tp_gl;
import RPN_Class.MoteurRPN;
import RPN_Class.SaisieRPN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import Exception.PileVideException;

public class Undo implements GeneriqueCommand {
	private HashMap<String, Command> history;
	public String name;
	List<String> list = new ArrayList<String>(history.keySet());
	
	
	public Undo(HashMap<String, Command> mapCommand) {
		// TODO Auto-generated constructor stub
		this.history = mapCommand;
	}

	@Override
	public void execute() {
		history.remove(list.get(list.size()-1));
	}
	
	

}
