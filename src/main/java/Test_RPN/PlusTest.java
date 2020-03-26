package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.NombreException;
import Exception.PileVideException;
import tp_gl.MoteurRPN;
import tp_gl.Plus;
import tp_gl.SaisieRPN;
import tp_gl.Specifique;
import tp_gl.SpecifiqueCommande;

public class PlusTest {

	@Test
	public void PlusTest() throws NombreException, PileVideException
	{
		MoteurRPN moteur =  new MoteurRPN();
		Specifique specifique = new Specifique();
		
		moteur.AddOperand(2);
		moteur.AddOperand(2);
		Plus plus = new Plus(moteur,specifique);
		plus.execute();
		
		assertTrue("La valeur de l'addition vaut 4", moteur.depiler() == 4);
	}
}
