
public class Gobelet {
	private De de1;
	private De de2;
	boolean truque;

	public Gobelet() {
		de1 = new De();
		de2 = new De();
	}

	public Gobelet(boolean truque) {
		if (truque == true) {
			de1 = new DePipe();
			de1 = new DePipe();
		} else {
			de1 = new De();
			de2 = new De();
		}

	}

	public void lancer() {
		de1.lancer();
		de2.lancer();
	}

	public int getScoreDe() {
		int sommeDes = de1.getValeur() + de2.getValeur();
		return sommeDes;
	}

	public De getDe1() {
		return de1;
	}

	public void setDe1(De de1) {
		this.de1 = de1;
	}

	public De getDe2() {
		return de2;
	}

	public void setDe2(De de2) {
		this.de2 = de2;
	}

}
