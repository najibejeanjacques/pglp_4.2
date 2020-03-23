//Impl�mentation de l��num�ration CalculatriceRPN 

package RPN_Class;

import RPN_Class.SaisieRPN;
import Exception.*;

public enum CalculatriceRPN {
	expression;
	
	public static void main(String[] args)
	{
		SaisieRPN saisi = new SaisieRPN();
		try
		{
		saisi.lectureClavier();
		}
		catch(Exception e)
		{
			
		}
	}

}

