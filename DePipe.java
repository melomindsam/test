import java.util.Random;

public class DePipe extends De {
	@Override
	public void lancer() {
		if (new Random().nextInt(2) == 0) {
			super.setValeur(6);
		} else {
			super.lancer();
		}
	}

}
