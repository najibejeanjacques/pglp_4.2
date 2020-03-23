package RPN_Class;

import Exception.DivisionParZeroException;
import Exception.PilePleineException;
import Exception.PileVideException;

//3) Implementation de l'�numeration OperationRPN

//Creation de l'�numeraton Op�ration
public enum Operation {
//FD�finition des constantes avec la r�definition de la m�thode eval pour chaque constante
	PLUS("+"){
		@Override
		public double eval(double x, double y)
		{
			return (x+y);
		}
	}
	, MOINS("-")
	{
		@Override
		public double eval(double x, double y)
		{
			return (x-y);
		}
	}
	,MULT("*"){
		@Override
		public double eval(double x, double y)
		{
			return (x*y);
		}
	}
	, 
	DIV("/"){
		@Override
		public double eval(double x, double y) throws DivisionParZeroException
		{
			if(y !=0.0)
			{
				return (x/y);
				
			}
			else
			{
				throw new DivisionParZeroException();
			}
		}
	};

	//d�finition de l'attribut symbole 
	public String symbole;
	
	//D�claration du constructeur qui prends en param�tre le symbole
	Operation(String symbole)
	{
		this.symbole = symbole;
	}
	
	//Methode abstraite eval
	public abstract double eval(double a, double b) throws DivisionParZeroException;
			
	
}
