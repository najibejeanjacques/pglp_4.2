package Test_RPN;

import org.junit.Test;
import tp_gl.*;

public class QuitTest {
	
	@Test
	public void quit() {
		Interpreter interprete = new Interpreter();
		Quit quit = new Quit();
		interprete.register("quit", quit);
		interprete.execute("quit");
	}

}
