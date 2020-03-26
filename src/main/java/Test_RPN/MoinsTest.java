package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.NombreException;
import Exception.PileVideException;
import tp_gl.Minus;
import tp_gl.MoteurRPN;
import tp_gl.Plus;
import tp_gl.Specifique;

public class MoinsTest {

	@Test
	public void MoinsTest() throws NombreException, PileVideException
	{
		MoteurRPN moteur =  new MoteurRPN();
		Specifique specifique = new Specifique();
		
		moteur.AddOperand(2);
		moteur.AddOperand(2);
		Minus moins = new Minus(moteur,specifique);
		moins.execute();
		
		assertTrue("La valeur de la soustraction vaut 0", moteur.depiler() == 0);
	}
}
