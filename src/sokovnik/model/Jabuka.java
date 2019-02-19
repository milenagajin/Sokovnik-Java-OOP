package sokovnik.model;

public class Jabuka extends Vocka {



	private String sorta;

	public Jabuka() {
		super();
	}

	public Jabuka(String naziv, double tezina, boolean trula, String sorta) {
		super(naziv, tezina, trula);
		this.sorta = sorta;
	}

	public String getSorta() {
		return sorta;
	}

	public void setSorta(String sorta) {
		this.sorta = sorta;
	}
	
	


}
