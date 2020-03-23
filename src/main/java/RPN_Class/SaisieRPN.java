//Impl�mentation de la classe SaisieRPN qui g�re les interactions avec l�utilisateur et invoque le moteur RPN

package RPN_Class;
import java.util.Scanner;
import java.util.Stack;

import RPN_Class.MoteurRPN;
import RPN_Class.Operation;
import Exception.DivisionParZeroException;
import Exception.FormatRPNException;
import Exception.NombreException;
import Exception.PilePleineException;
import Exception.PileVideException;
import Exception.SaisieException;


public class SaisieRPN  {
	
//D�claration d'un objet de type MoteurRPN
	
	private static MoteurRPN moteurrpn;
	
//D�claration de deux contantes qui sp�cifient l'intervalle de nombre support�
	
	final static double MIN_VALUE=Double.MIN_VALUE;
	final static double MAX_VALUE=Double.MAX_VALUE;
	
/*Cr�ation d'une pile qui vas contenir les m�mes �lements que le moteurRPN
	et qui sera utilis� pour retrouver tous les �lements saisies dans la pile*/
	
	public Stack pile = new Stack<>();

//Constructeur de la classe SaisieRPN
	
	public SaisieRPN()
	{
		this.moteurrpn = new MoteurRPN();
	}
	
//Retourner l'objet moteur
	public MoteurRPN GetMoteur()
	{
		return this.moteurrpn;
	}
		
	
//Cr�ation d'une m�thode qui vas gerer les saisies au clavier
	
	public void lectureClavier() throws FormatRPNException,PilePleineException,PileVideException,DivisionParZeroException,SaisieException,NombreException
	{
		
	Scanner s = new Scanner(System.in);
	String valeur;
	System.out.println("Veuiller les operands et operateurs sous le format RPN:");
	valeur = s.nextLine();
	
/*D�claration d'une variable qui vas permettre de connaitre le nombre d'�l�ment de la pile */
 
	int boucle=0;
	
/*D�claration d'une variable qui vas contenir la concatenation de tous les �l�ments de la pile
  ainsi que les op�rateurs saisies */
	
	String cour = "";
	
	while (!exitCode(valeur))
	{
			if(VerifierOperand(valeur))
			{
				if(VerifierNombre(Double.parseDouble(valeur)))
				{
					//on empile la valeur saisie dans moteurrpn apr�s l'avoir convertie en double
					
					moteurrpn.empiler(Double.parseDouble(valeur));
					
					//on empile la valeur saisie dans pile apr�s l'avoir convertie en double
					
					pile.push(Double.parseDouble(valeur));
					boucle++;
					int taille =pile.size();
					while(taille>0)
					{
						cour = cour + " "+ pile.pop()+" ";
						taille--;
					}
				
					System.out.println("L'expression courante est de la forme: "+cour);
				}
				else
				{
					//throw new NombreException();
					System.out.println("L'expression  ne satisfait pas les conditions pour effectuer le calcul suivant le format RPN :");
					System.out.println("Veuiller entrer de nouvelle donn�es: ");
					
				}
			}
			else
			{
				if(VerifierOperateur(valeur))
				{
					
					
					if(boucle==0) {
						//throw new PileVideException();
						System.out.println("La pile est vide");
						System.out.println("Veuiller entrer des op�randes: ");
						
					}
					else if(boucle<2)
					{
						//throw new FormatRPNException();
						System.out.println("On ne peux pas faire l'op�ration avec une seule op�rande");
						System.out.println("Veuiller entrer une autre op�rande: ");
					}
					else
					{
						
						moteurrpn.Calcul(getOperateur(valeur));
						cour = cour + valeur+" ";
						boucle--;
						System.out.println("L'expression courante est de la forme: "+cour);
						
					}
				}
				else
				{
					//throw new SaisieException(); 
					System.out.println("Ce caractre n'est pas autoris�, veuiller resaisir : ");
				}
				
			}
		
		valeur = s.nextLine();
	}
	
//On affiche le r�sultat de l'op�ration lorsque l'utilisateur saisie exit
	
	if(exitCode(valeur))
	{
		System.out.println("Le resultat du calcul RPN vaut: "+moteurrpn.depiler());
	}
}
	

// M�thode qui permet de v�rifier si la valeur saisie par l'utilisateur est une op�rande
	
	public static Boolean VerifierOperand(String saisie)
	{
		try 
		{
			Double convertion = Double.parseDouble(saisie);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	

// M�thode qui permet de v�rifier si la valeur saisie par l'utilisateur est un op�rateur
	
	public static boolean VerifierOperateur(String saisie)
	{
		if(saisie.equals("+") || saisie.equals("-") || saisie.equals("*") || saisie.equals("/"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
//M�thode qui permet de d�piler le contenu la pile
	
	/*public double getValeurMoteur()
	{
		try
		{
			return moteurrpn.depiler();
		}
		catch(PileVideException e)
		{
			return 0;
		}
	}*/
	
//M�thode qui verifie la saisie et retourne l'operateur correspondant  
	
	public Operation getOperateur(String saisie)
	{
		switch (saisie) {
		case "+":
			return Operation.PLUS;
		case "-":
			return Operation.MOINS;
		case "*":
			return Operation.MULT;
		case "/":
			return Operation.DIV;
		default:
			return null;
		}
				
	}
	
	
	//M�thode qui permet de verifier que la valeur saisie par l'utilisateur est �gal � exit
	
	public static boolean exitCode(String saisie)
	{
		if(saisie.equals("exit") || saisie.equals("EXIT") || saisie.equals("E"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
//M�thode qui permet de verifier si le nombre saisie par l'utilisateur est compris entre MIN_Value et Max_Value
	
	public static boolean VerifierNombre(Double valeur)
	{
		if(MIN_VALUE <= valeur || valeur <= MAX_VALUE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
	
	

