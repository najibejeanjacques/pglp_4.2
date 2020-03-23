package Test_RPN;

import java.util.Stack;

import org.junit.Test;

import tp_gl.Command;
import tp_gl.Interpreter;
import tp_gl.Minus;
import tp_gl.MoteurRPN;
import tp_gl.Plus;
import tp_gl.Quit;
import tp_gl.Specifique;
import tp_gl.Undo;

public class UndoTest {
	
	@Test
	public void undo() {
		Stack<Command> mapCommand = new Stack<Command>();
		Stack<Double> operand = new Stack<Double>();
		Interpreter interprete = new Interpreter();
		Specifique spec = new Specifique();
		MoteurRPN moteur = new MoteurRPN();
		
		Plus addition = new Plus(moteur,spec);
		Minus moins = new Minus(moteur,spec);
		mapCommand.push(addition);
		mapCommand.push(moins);
		
		/*Undo undo = new Undo(mapCommand);
		interprete.register("undo", undo);
		interprete.execute("undo");*/
	}

}
