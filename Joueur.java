
public class Joueur {
	private String prenom = "";
	private int scorePartie = 0;
	private Gobelet gobelet;
	private boolean tricheur;
	private int nbDeTentatives;

	public void setNbDeTentatives(int nbDeTentatives) {
		this.nbDeTentatives = nbDeTentatives;
	}
	
	public void nbTentativePlus1() {
		nbDeTentatives++;
	}

	public int getNbDeTentatives() {
		return nbDeTentatives;
	}

	public void setTricheur(boolean tricheur) {
		this.tricheur = tricheur;
		gobelet = new Gobelet(true);
	}

	public Joueur(String prenom) {
		gobelet = new Gobelet();
		this.setPrenom(prenom);
	}

	public void jouer() {
		gobelet.lancer();
	}

	public boolean isTricheur() {
		return tricheur;
	}

	public void ajouterPoint() {
		scorePartie++;

	}

	// -----------------------
	// GETTERS AND SETTERS
	// -----------------------

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getScorePartie() {
		return scorePartie;
	}

	public void setScorePartie(int scorePartie) {
		this.scorePartie = scorePartie;
	}

	public Gobelet getGobelet() {
		return gobelet;
	}

	public void setGobelet(Gobelet gobelet) {
		this.gobelet = gobelet;
	}

}
