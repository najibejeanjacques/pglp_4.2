package tp_gl;

import Exception.*;

public class CalculatriceRPN {
/**
 * 
 * @param args
 * @throws NumberFormatException
 * @throws PileVideException
 * @throws PilePleineException
 * @throws SaisieException
 * @throws NombreException
 * @throws DivisionParZeroException
 * @throws FormatRPNException
 */
	public static void main(String[] args) throws NumberFormatException, PileVideException, PilePleineException, SaisieException, NombreException, DivisionParZeroException, FormatRPNException {
		// TODO Auto-generated method stub

		SaisieRPN saisi = new SaisieRPN();
		saisi.lire();
	}

}
