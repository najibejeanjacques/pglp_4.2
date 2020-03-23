package tp_gl;

import Exception.DivisionParZeroException;
import Exception.FormatRPNException;
import Exception.NombreException;
import Exception.PilePleineException;
import Exception.PileVideException;
import Exception.SaisieException;
import tp_gl.SaisieRPN;

public class CalculatriceRPN {

	public static void main(String[] args) throws NumberFormatException, PileVideException, PilePleineException, SaisieException, NombreException, DivisionParZeroException, FormatRPNException {
		// TODO Auto-generated method stub

		SaisieRPN saisi = new SaisieRPN();
		saisi.lire();
	}

}
