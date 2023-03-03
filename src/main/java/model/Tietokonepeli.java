package model;

public class Tietokonepeli {

	// nimi, hinta, julkaisupäivä, lajityyppi, kehittaja

	private int id;
	private String nimi;
	private double hinta;
	private String julkaisupaiva;
	private String lajityyppi;
	private String kehittaja;

	public Tietokonepeli(int id, String nimi, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
	}
	
	
	
	public Tietokonepeli(int id, String nimi, double hinta, String julkaisupaiva, String lajityyppi, String kehittaja) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.julkaisupaiva = julkaisupaiva;
		this.lajityyppi = lajityyppi;
		this.kehittaja = kehittaja;
	}

	public Tietokonepeli(String nimi, double hinta, String julkaisupaiva, String lajityyppi, String kehittaja) {
		super();
	
		this.nimi = nimi;
		this.hinta = hinta;
		this.julkaisupaiva = julkaisupaiva;
		this.lajityyppi = lajityyppi;
		this.kehittaja = kehittaja;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getJulkaisupaiva() {
		return julkaisupaiva;
	}

	public void setJulkaisupaiva(String julkaisupaiva) {
		this.julkaisupaiva = julkaisupaiva;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getLajityyppi() {
		return lajityyppi;
	}

	public void setLajityyppi(String lajityyppi) {
		this.lajityyppi = lajityyppi;
	}

	public String getKehittaja() {
		return kehittaja;
	}

	public void setKehittaja(String kehittaja) {
		this.kehittaja = kehittaja;
	}



	@Override
	public String toString() {
		return "Tietokonepeli [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + ", julkaisupaiva=" + julkaisupaiva
				+ ", lajityyppi=" + lajityyppi + ", kehittaja=" + kehittaja + "]";
	}




	

}
