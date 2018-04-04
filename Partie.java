
public class Partie {
	private Joueur j1;
	private Joueur j2;
	private int tourEncours;
	private Joueur joueurActif;

	public static final int SCORE_A_ATTEINDRE = 7;

	public Partie(String nomJ1, String nomJ2) {
		j1 = new Joueur(nomJ1);
		j2 = new Joueur(nomJ2);
		joueurActif = j1;
		tourEncours = 1;
	}

	public void ajouterTour() {
		tourEncours++;
	}

	// -----------------------
	// GETTERS AND SETTERS
	// -----------------------

	public void changerJoueurActif() {
		if (joueurActif == j1) {
			joueurActif = j2;
		} else if (joueurActif == j2) {
			joueurActif = j1;
		}
	}

	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public int getTourEncours() {
		return tourEncours;
	}

	public void setTourEncours(int tourEncours) {
		this.tourEncours = tourEncours;
	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}
}
