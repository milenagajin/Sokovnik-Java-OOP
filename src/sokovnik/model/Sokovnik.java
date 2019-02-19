package sokovnik.model;

import java.util.List;

import sokovnik.utils.MyLogger;

public class Sokovnik implements Cediljka {

	private int akcija = 0;
	private PosudaZaVoce posuda;
	private double kolicinaSoka = 0;

	public Sokovnik() {
		super();
	}

	public Sokovnik(PosudaZaVoce posuda) {
		super();
		this.posuda = posuda;
	}

	public int getAkcija() {
		return akcija;
	}

	public void setAkcija(int akcija) {
		this.akcija = akcija;
	}

	public PosudaZaVoce getPosuda() {
		return posuda;
	}

	public void setPosuda(PosudaZaVoce posuda) {
		this.posuda = posuda;
	}

	public double getKolicinaSoka() {
		return kolicinaSoka;
	}

	public void setKolicinaSoka(double kolicinaSoka) {
		this.kolicinaSoka = kolicinaSoka;
	}
	
	
	@Override
	public void iscediVoce(List<Vocka> vockeUPosudi) {

		// mnozim sa 0.3 jer je 30% verovatnoca cedjenja,a sa 0.4 jer je kolicina soka
		// koja se
		// dobija cedjenjem 40% ukupne tezine jabuke
		for (Vocka itVocka : vockeUPosudi) {
			this.kolicinaSoka += itVocka.getTezina() * 0.4 * 0.3;
		}
		this.akcija++;
		MyLogger.log("Cedjenje je pocelo. Ukupno za sad soka " + this.kolicinaSoka);

	}

}
