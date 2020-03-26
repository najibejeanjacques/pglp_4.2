package tp_gl;

import java.util.Iterator;
import java.util.Stack;

import Exception.DivisionParZeroException;
import Exception.FormatRPNException;
import Exception.NombreException;
import Exception.PileVideException;

public class MoteurRPN extends Interpreter {

	//Creation de la pile
	private final static int MIN_VALUE = -9999999;
	private final static int  MAX_VALUE = 9999999;
	public static int valeur = 0;
	
	private Specifique specifique = new Specifique();
	private Plus plus = new Plus(this, specifique);
	private Minus moins = new Minus(this, specifique);
	private Multi multi = new Multi(this, specifique);
	private Div div = new Div(this, specifique);
	
	private Interpreter interpreteur = new Interpreter();
	
	private Generique generique = new Generique();
	//private Undo undo = new Undo(history);
	Undo undo = new Undo(interpreteur.mapCommand);
	private Quit quit = new Quit();
	
	
	
	/***
	 * 
	 * Initialisation de l'interpreteur
	 * 
	 * 
	 */
	public void Init()
	{
		interpreteur.register("+", plus);
		interpreteur.register("-", moins);
		interpreteur.register("*", multi);
		interpreteur.register("/", div);
		interpreteur.register("undo", undo);
		interpreteur.register("quit", quit);
	}
	
	protected static Stack<Command> history;
	protected Stack<Double> operand;
	
	/***
	 * @param La caleur tappée au clavier
	 * @throws PileVideException Vérifie si la pile est vide si oui génère une exceptionde type pile vice
	 * @throws DivisionParZeroException Vérifie si on a affaire a une division par zéro, si oui génère une exception
	 * @throws FormatRPNException, Vérifie si on a une erreur de synthaxe RPN
	 */
	
	public void apply(String chaine) throws PileVideException, DivisionParZeroException, FormatRPNException
	{
		if(interpreteur.mapCommand.get(chaine) instanceof Quit)
		{
			Calculer();
			System.out.println("La valeur calculé avec RPN vaut :"+depiler());
			interpreteur.execute(chaine);
		}
		else if(interpreteur.mapCommand.get(chaine) instanceof Undo)
		{
			interpreteur.execute(chaine);
		}
		else
		{
				getHistory().push(getInterpreter().mapCommand.get(chaine));
		}
	}

	/**
	 * Constructeur de la classe Moteur RPN
	 * 
	 */
	public MoteurRPN(){
		history = new Stack<Command>();
		operand = new Stack<Double>();
	}
	
		/***
		 * 
		 * @param La valeur a ajouter dans la pile
		 * @throws Verifie si on a une excepton de type nombre
		 */
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
	
	/****
	 * Calcul des valeurs de la pile avec les commandes specifiques
	 * @throws Verifie si si la pile est vide si oui genere une exception
	 * @throws Vérifie si on a une division par zéro
	 * @throws Vérifier si on une incompatibilité dans le format RPN
	 * 
	 */
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
				//interpreteur.execute();
			}
		}

	}

	/***
	 * 
	 * @return retourne la valeur de la pile c'est a dire le resultat du calcul RPN
	 * @throws PileVideException Vérifie si la pile est vide
	 */
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
	
	/****
	 * 
	 * @return retourne la liste des commandes de l'historique
	 */
	public Stack<Command> getHistory()
	{
		return this.history;
	}
	
	/***
	 * 
	 * @return l'interpreter de la classe Moteur RPN
	 */
	public Interpreter getInterpreter()
	{
		return this.interpreteur;
	}
	
	
}
