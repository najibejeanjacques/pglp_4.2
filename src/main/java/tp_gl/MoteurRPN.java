package tp_gl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Exception.DivisionParZeroException;
import Exception.FormatRPNException;
import Exception.NombreException;
import Exception.PileVideException;
import RPN_Class.Operation;

public class MoteurRPN extends Interpreter {

	//Creation de la pile
	private final static int MIN_VALUE = -9999999;
	private final static int  MAX_VALUE = 9999999;
	
	private Specifique specifique = new Specifique();
	private Plus plus = new Plus(this, specifique);
	private Minus moins = new Minus(this, specifique);
	private Multi multi = new Multi(this, specifique);
	private Div div = new Div(this, specifique);
	
	private Generique generique = new Generique();
	//private Undo undo = new Undo(history);
	private Quit quit = new Quit();
	
	
	
	private Interpreter interpreteur = new Interpreter();
	
	/***
	 * 
	 * Initialisation de l'interpreteur
	 */
	public void Init()
	{
		interpreteur.register("+", plus);
		interpreteur.register("-", moins);
		interpreteur.register("*", multi);
		interpreteur.register("/", div);
		//interpreteur.register("undo", undo);
		interpreteur.register("quit", quit);
	}
	
	protected static Stack<Command> history;
	protected Stack<Double> operand;
	
	public void apply(String chaine) throws PileVideException, DivisionParZeroException, FormatRPNException
	{
		if(interpreteur.mapCommand.get(chaine) instanceof Quit)
		{
			Calculer();
			System.out.println("LA valeur calculé avec RPN vaut :"+depiler());
			interpreteur.execute(chaine);
		}
		else if(interpreteur.mapCommand.get(chaine) instanceof Undo)
		{
			Undo undo = new Undo(interpreteur.mapCommand);
			interpreteur.register("undo", undo);
			interpreteur.execute(chaine);
		}
		else
		{
			getHistory().push(getInterpreter().mapCommand.get(chaine));
		}
	}

	//Constructeur de la classe MoteurRPN
	public MoteurRPN(){
		history = new Stack<Command>();
		operand = new Stack<Double>();
	}
	
	//Ajout d'une opérande dans la pile
		public void AddOperand(double valeur) throws NombreException 
		{
			if(MIN_VALUE <  valeur && valeur < MAX_VALUE)
			{
				operand.push(valeur);
			}
			else
			{
				throw new NombreException();
			}
		}
	
	//Appliquer une Opération (qui est une commande) sur les Opérandes
	public void Calculer()throws PileVideException, DivisionParZeroException, FormatRPNException
	{
		String commandName;
		Command commands;
		Iterator<Command> iterator = history.iterator();
		while (iterator.hasNext())
		{
			//commandName =iterator.next()
			commands = iterator.next();
			//System.out.println("nomCommand ="+commandName);
			if(commands instanceof SpecifiqueCommande)
			{
				//System.out.println("CommandName = "+commandName);
				commands.execute();
				
			}
			else
			{
				//interpreteur.execute(commandName);
			}
		}

	}

	//depiler la pile d'operandes
	public double depiler() throws PileVideException
	{
		try 
		{
			double val = this.operand.pop();
			return val;
		} catch (Exception e) {
			throw new PileVideException();
		}
	}
	
	//Retourner la pile de commande c'est a dire l'historique des commandes
	public Stack<Command> getHistory()
	{
		return this.history;
	}
	
	//Retourner l'interpreter
	public Interpreter getInterpreter()
	{
		return this.interpreteur;
	}
	
	
}
