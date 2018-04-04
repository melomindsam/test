
public class Controller {
	public static void lancerJeu() {
		Partie partie = new Partie("Toto", "Nono");
		while (partie.getJ1().getScorePartie() < 3) {
			partie.getJ1().jouer();
			partie.getJ1().nbTentativePlus1();
			if (partie.getJ1().getGobelet().getScoreDe() == 7) {
				partie.getJ1().ajouterPoint();
			} else if (partie.getJ1().getGobelet().getScoreDe() != 7) {
				partie.getJ1().setScorePartie(0);
			}
		}

		while (partie.getJ2().getScorePartie() < 3) {
			partie.getJ2().jouer();
			partie.getJ2().nbTentativePlus1();
			if (partie.getJ2().getGobelet().getScoreDe() == 7) {
				partie.getJ2().ajouterPoint();
			} else if (partie.getJ2().getGobelet().getScoreDe() != 7) {
				partie.getJ2().setScorePartie(0);
			}
		}

		partie.ajouterTour();

		if (partie.getJ1().getNbDeTentatives() < partie.getJ2().getNbDeTentatives()) {
			System.out.println(partie.getJ1().getPrenom() + " a gagné! ");
		} else if ((partie.getJ2().getNbDeTentatives()) < partie.getJ1().getNbDeTentatives()) {
			System.out.println(partie.getJ2().getPrenom() + " a gagné!");
		}
	}
}
