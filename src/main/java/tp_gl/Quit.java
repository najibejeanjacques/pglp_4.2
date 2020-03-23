package tp_gl;

public class Quit implements GeneriqueCommand {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Command quit");
		System.exit(0);
	}

}
