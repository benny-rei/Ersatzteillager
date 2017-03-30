package Model;

public class Kunden {

	
	private int KundenID;
	private String vorname;
	private String nachname;
	private int plz;
	private String ort;
	private String strasse;
	private int hausnummer;
	
	
	public Kunden() {
		super();
	}
	public Kunden(int kundenID, String vorname, String nachname, int plz, String ort, String strasse,
			int hausnummer) {
		super();
		KundenID = kundenID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
	}
	public int getKundenID() {
		return KundenID;
	}
	public void setKundenID(int kundenID) {
		KundenID = kundenID;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	/**
	 * Verbindet alle Informationen eines Kunden zu einem String
	 */
	@Override
	public String toString() {
		return "Kunden [KundenID=" + KundenID + ", vorname=" + vorname + ", nachname=" + nachname + ", plz=" + plz
				+ ", ort=" + ort + ", strasse=" + strasse + ", hausnummer=" + hausnummer + "]";
	}

	
}
