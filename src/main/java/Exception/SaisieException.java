package Exception;

public class SaisieException extends Exception {

	public SaisieException()
	{
		System.out.println("Erreur, on ne peux pas faire d'operation avec une seule opérande !");
	}
}
