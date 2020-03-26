package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.NombreException;
import Exception.PileVideException;
import tp_gl.Minus;
import tp_gl.MoteurRPN;
import tp_gl.Multi;
import tp_gl.Specifique;

public class MultiTest {

	@Test
	public void MultiTest() throws NombreException, PileVideException
	{
		MoteurRPN moteur =  new MoteurRPN();
		Specifique specifique = new Specifique();
		
		moteur.AddOperand(2);
		moteur.AddOperand(2);
		Multi multi = new Multi(moteur,specifique);
		multi.execute();
		
		assertTrue("La valeur de la multiplication vaut 4", moteur.depiler() == 4);
	}
}
