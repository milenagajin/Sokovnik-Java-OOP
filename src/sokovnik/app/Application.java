package sokovnik.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import sokovnik.exception.PremasenBrojMogucihAkcijaException;
import sokovnik.exception.PremasenKapacitetSokovnikaException;
import sokovnik.model.Jabuka;
import sokovnik.model.PosudaZaVoce;
import sokovnik.model.Sokovnik;
import sokovnik.model.Vocka;
import sokovnik.utils.MyLogger;

public class Application {

	public static double kgNapravljenihJabuka = 0;
	public static Random random = new Random();
	public static DecimalFormat df = new DecimalFormat("#.##");

	public static void main(String[] args) {

		List<Vocka> sveVocke = new ArrayList<Vocka>();

		Sokovnik sokovnik = new Sokovnik();
		PosudaZaVoce posuda = new PosudaZaVoce(sokovnik, 30.0);
		sokovnik.setPosuda(posuda);

		// uzimam da treba da iscedimo priblizno 100kg jabuka

		while (kgNapravljenihJabuka < 100) {
			Jabuka jabuka = Application.napraviJabuku();
			sveVocke.add(jabuka);
		}

		// Posto je verovatnoca da vocka bude trula 20%, setujem da je svaka peta vocka
		// trula
		for (int i = 0; i < sveVocke.size(); i++) {
			if ((i + 1) % 5 == 0) {
				Vocka vocka = sveVocke.get(i);
				vocka.setTrula(true);
			}
		}

		// uzimam randomly 70 posto ukupno napravljenih jabuka, jer je tolika
		// verovatnoca da budu ubacene u posudu za voce

		Collections.shuffle(sveVocke);
		int randomSeriesLength = (int) (sveVocke.size() * 0.70);
		List<Vocka> randomSeries = new ArrayList<>(sveVocke.subList(0, randomSeriesLength));

		for (Vocka vocka : randomSeries) {
			try {
				if (posuda.kolikoImaProstora() >= vocka.getTezina()) {
					posuda.ubaciVockice(vocka);
				}else {
					sokovnik.iscediVoce(posuda.getVockeUPosudi());
					posuda.getVockeUPosudi().clear();
				}
			} catch (PremasenKapacitetSokovnikaException e) {
				e.printStackTrace();
			} catch (PremasenBrojMogucihAkcijaException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		
		System.out.println("Napravili smo " + Double.valueOf(df.format(kgNapravljenihJabuka)) + " kg jabuka. ");
		System.out.println("Sve detalje cedjenja, pogledati u mylogs.txt fajlu.");
		System.out.println("Ukupno smo dobili: " + Double.valueOf(df.format(sokovnik.getKolicinaSoka())) + " kg soka.");

	}

	public static Jabuka napraviJabuku() {

		// mnozim sa 1, jer hocu da mi jedna vocka ima maximalno 1kg (mora biti i poneka
		// gmo
		// vocka :) ), a najmanje 0.3kg
		double randomValue = 0.3 + (1 - 0.3) * random.nextDouble();
		double tezina = Double.valueOf(df.format(randomValue));

		Jabuka jabuka = new Jabuka();

		jabuka.setNaziv("jabuka");
		jabuka.setTezina(tezina);
		jabuka.setTrula(false);
		jabuka.setSorta("Ajdared");

		kgNapravljenihJabuka += jabuka.getTezina();

		MyLogger.log("Napravljena je jabuka sorte" + jabuka.getSorta() + " i tezine " + jabuka.getTezina());
		return jabuka;

	}

}
