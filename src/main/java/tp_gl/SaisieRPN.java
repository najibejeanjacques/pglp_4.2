package tp_gl;

import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Soundbank;

import Exception.DivisionParZeroException;
import Exception.FormatRPNException;
import Exception.NombreException;
import Exception.PilePleineException;
import Exception.PileVideException;
import Exception.SaisieException;
import tp_gl.MoteurRPN;

public class SaisieRPN {
	
	//D�claration d'un objet de type MoteurRPN
	
		private static MoteurRPN moteurrpn;
		private final static int MIN_VALUE = -9999999;
		private final static int  MAX_VALUE = 9999999;
		private Stack<Double> pile;
		
		/**
		 * Constructeur de la classe Saisie RPN
		 */
		public SaisieRPN()
		{
			this.moteurrpn = new MoteurRPN();
			this.moteurrpn.Init();
			pile = new Stack<Double>();
		}
		
		/***
		 * 
		 * @return le moteur RPN
		 */
		public MoteurRPN getMoteur()
		{
			return this.moteurrpn;
		}
		
		/***
		 * 
		 * @throws PileVideException pile vide exception
		 * @throws PilePleineException pile pleine exception
		 * @throws SaisieException exception dans la saisie
		 * @throws NumberFormatException exception dans le format des nombres
		 * @throws NombreException exception
		 * @throws DivisionParZeroException exception d'une division par zero
		 * @throws FormatRPNException format RPN eception
		 */
		public void lire() throws PileVideException,PilePleineException,SaisieException, NumberFormatException, NombreException, DivisionParZeroException, FormatRPNException
	    {
	        Scanner sc=new Scanner(System.in);
	        int boucle=0;
	        
	        System.out.print("Entrer un nombre ou une Opération: ");
	        String chaine= sc.nextLine();
	        
	        while (true)
	    	{
	        if(VerifierOperand(chaine))
	        {
	        	boucle++;
	        	this.moteurrpn.AddOperand(Double.parseDouble(chaine));
	        	pile.push(Double.parseDouble(chaine));
	        }
	    	else
			{
			
					if(boucle==0) 
					{
						System.out.println("La pile est vide");
						System.out.println("Veuiller entrer des opérandes: ");
					}
					else if(boucle<2)
					{
						System.out.println("On ne peux pas faire l'opération avec une seule opérande");
						
					}
					/*else if(boucle==2)
					{
						System.out.println("Veuillez saisir l'opérateur");
						boucle++;
					}*/
					else
					{
						this.moteurrpn.apply(chaine);
						//boucle++;
					}	
			}
	       
	        System.out.print("Entrer un nombre ou une Opération: ");
	        chaine= sc.nextLine();
	    	}
	    }
	    
		/**
		 * 
		 * @param saisie la valeur en entré saisie par l'utilisateur
		 * @return un boolean afin de voir si la valeur entrée est une opérande
		 * 
		 */
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
		
		/**
		 * 
		 * @param valeur la valeur en entré saisie par l'utilisateur
		 * @return un boolean afin de voir si la valeur entrée est une opérande et respecte les conditions 
		 */
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
