package Test_RPN;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp_gl.Generique;
import tp_gl.GeneriqueCommand;
import tp_gl.MoteurRPN;
import tp_gl.Plus;
import tp_gl.Quit;
import tp_gl.Specifique;
import tp_gl.SpecifiqueCommande;

public class CommandeGeneriqueTest {

	
	@Test
	public void CommandeGeneriqueTest()
	{
		MoteurRPN moteur = new MoteurRPN();
		Generique generique = new Generique();
		Quit quit = new Quit();
		
		assertTrue("Instance de CommandeSpecifique", quit instanceof GeneriqueCommand);
	}
}
