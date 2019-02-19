package sokovnik.model;

import java.util.ArrayList;
import java.util.List;

import sokovnik.exception.PremasenBrojMogucihAkcijaException;
import sokovnik.exception.PremasenKapacitetSokovnikaException;
import sokovnik.utils.MyLogger;

public class PosudaZaVoce {

	private Sokovnik sokovnik = new Sokovnik();
	private double kapacitet;
	private List<Vocka> vockeUPosudi = new ArrayList<>();

	public PosudaZaVoce() {
		super();
	}

	public PosudaZaVoce(Sokovnik sokovnik, double kapacitet) {
		super();
		this.sokovnik = sokovnik;
		this.kapacitet = kapacitet;
	}
	
	public List<Vocka> getVockeUPosudi() {
		return vockeUPosudi;
	}

	public double kolikoImaVockica() {

		double trenutnaTezinaVockica = 0;
		for (Vocka vocka : vockeUPosudi) {
			trenutnaTezinaVockica += vocka.getTezina();
		}
		return trenutnaTezinaVockica;
	}

	public double kolikoImaProstora() {
		double slobodniProstor = this.kapacitet - kolikoImaVockica();
		return slobodniProstor;
	}

	public void ubaciVockice(Vocka vocka)
			throws PremasenBrojMogucihAkcijaException, PremasenKapacitetSokovnikaException {

		if (this.sokovnik.getAkcija() == 100) {
			throw new PremasenBrojMogucihAkcijaException(
					"Premasen je moguci broj akcija u ovom sokovniku. Vise nece biti moguce cediti preko ovog sokovnika. :(");
		}

		// proveravam da li vocka nije jabuka ili da li je trula, jer hocemo da iscedimo
		// samo jabuke, s toga zelimo da dodamo samo njih i to one koje nisu crvljive

		if (!(vocka instanceof Jabuka) || vocka.isTrula()) {
			MyLogger.log("Vocka je trula i nije je moguce dodati!");
			return;
		}

		if (vocka.getTezina() <= kolikoImaProstora()) {
			vockeUPosudi.add(vocka);
			MyLogger.log("Dodata je u posudu za voce " + vocka.toString());

		} else {
			// ukoliko se ipak desi da premasimo maksimalni kapacitet posude, sve do tada
			// dodate jabuke ce biti iscedjenje, tek nakon sto smo ispraznili posudu
			// za voce dodajemo jabuku zbog koje je premasen kapacitet
		
			this.sokovnik.iscediVoce(vockeUPosudi);
			this.vockeUPosudi.clear();
			this.vockeUPosudi.add(vocka);
			MyLogger.log("Dodata je " + vocka.toString());
			throw new PremasenKapacitetSokovnikaException(
					"Trenutno nema vise mesta u posudi za voce. Cedjenje ubacenih jabuka je pocelo!");
		}

	}

}
