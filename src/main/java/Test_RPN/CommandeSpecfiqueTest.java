package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp_gl.MoteurRPN;
import tp_gl.Plus;
import tp_gl.Specifique;
import tp_gl.SpecifiqueCommande;

public class CommandeSpecfiqueTest {

	@Test
	public void CommandeSpecfiqueTest()
	{
		MoteurRPN moteur = new MoteurRPN();
		Specifique specifique = new Specifique();
		Plus plus = new Plus(moteur, specifique);
		
		assertTrue("Instance de CommandeSpecifique", plus instanceof SpecifiqueCommande);
	}
}
