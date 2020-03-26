package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.NombreException;
import Exception.PileVideException;
import tp_gl.Div;
import tp_gl.Minus;
import tp_gl.MoteurRPN;
import tp_gl.Specifique;

public class DivTest {

	@Test
	public void DivTest() throws NombreException, PileVideException
	{
		MoteurRPN moteur =  new MoteurRPN();
		Specifique specifique = new Specifique();
		
		moteur.AddOperand(2);
		moteur.AddOperand(2);
		Div div = new Div(moteur,specifique);
		div.execute();
		
		assertTrue("La valeur de la division vaut 1", moteur.depiler() == 1);
	}
}
