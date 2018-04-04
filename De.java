import java.util.Random;

public class De {
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	private int valeur = 0;

	public void lancer() {
		valeur = new Random().nextInt(6) + 1;
	}

	public int getValeur() {
		return valeur;
	}

}
