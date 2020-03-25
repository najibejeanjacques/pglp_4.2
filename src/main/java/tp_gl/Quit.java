package tp_gl;

public class Quit implements GeneriqueCommand {

	/**
	 * Méthode execute de Quit qui est une commande Générique 
	 */
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command quit");
		System.exit(0);
		
	}

}
