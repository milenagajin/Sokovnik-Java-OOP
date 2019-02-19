package sokovnik.model;

public abstract class Vocka {


	protected String naziv;
	protected double tezina;
	protected boolean trula;

	public Vocka() {
		super();
	}

	public Vocka(String naziv, double tezina, boolean trula) {
		this.naziv = naziv;
		this.tezina = tezina;
		this.trula = trula;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getTezina() {
		return tezina;
	}

	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	public boolean isTrula() {
		return trula;
	}

	public void setTrula(boolean trula) {
		this.trula = trula;
	}

	@Override
	public String toString() {
		return "Vocka [naziv=" + naziv + ", tezina=" + tezina + ", trula=" + trula + "]";
	}
	
}
