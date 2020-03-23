package RPN_Class;

import Exception.DivisionParZeroException;
import Exception.PilePleineException;
import Exception.PileVideException;

import java.util.*;
import RPN_Class.Operation;

//4) Implementation de la classe MoteurRPN

public class MoteurRPN {
	
	//Creation de la pile
	 public Stack<Double> pile;
	
	//Ajout d'un element dans la pile
	public void empiler(Double valeur)
	{
		this.pile.push(valeur);
	}
	
	//Calcul avec des �l�ments de la pile, c'est a dire appliquer une op�ration a des op�randes
	public void Calcul(Operation operation) throws DivisionParZeroException,PileVideException
	{		
		//double resultat = 0;
		//if(pile.isEmpty()) throw new PileVideException();
		double x = depiler();
		double y = depiler();
		
		empiler(operation.eval(x, y));	
		
	}
	
	//Fonction pour d�piler les elements de la pile
	
	public double depiler() throws PileVideException
	{
		if(pile.empty()) throw new PileVideException();
		return pile.pop();
	}
	
	//Constructeur de la classe MoteurRPN
	public MoteurRPN()
	{
		pile = new Stack<>();
	}
	

}
