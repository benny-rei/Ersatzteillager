package Model;

/**
 * In dieser Klasse werden die Verkaufsdaten abgespeichert
 * @author Reichhold & Schlögl
 *
 */
public class Verkauf {
	
	private int VerkaufsID;
	private int KundenID;
	private String Datum;
	
	
	
	public Verkauf() {
		super();
	}

	public Verkauf(int verkaufID, int kundenID, String datum) {
		super();
		VerkaufsID = verkaufID;
		KundenID = kundenID;
		Datum = datum;
	}

	/**
	 * Gibt die ID des Verkaufs zurück
	 * @return ... VerkaufsID
	 */
	public int getVerkaufID() {
		return VerkaufsID;
	}

	/**
	 * Setzt die VerkaufsID eines Verkaufs
	 * @param verkaufID
	 */
	public void setVerkaufID(int verkaufID) {
		VerkaufsID = verkaufID;
	}
	
	/**
	 * Gibt die ID des Kunden zurück der am Verkauf beteiligt war
	 * @return ... KundenID
	 */
	public int getKundenID() {
		return KundenID;
	}
	/**
	 * Setzt die KundenID eines Verkaufs
	 * @param verkaufID
	 */
	public void setKundenID(int kundenID) {
		KundenID = kundenID;
	}

	/**
	 * Gibt das Verkaufsdatum Durück
	 * @return ... Verkaufsdatum
	 */
	public String getDatum() {
		return Datum;
	}
	/**
	 * Setzt das Datum eines Verkaufs
	 * @param verkaufID
	 */
	public void setDatum(String datum) {
		Datum = datum;
	}
	
	/**
	 * Verbindet alle Informationen eines Verkaufs zu einem String
	 */
	@Override
	public String toString() {
		return "Verkauf [VerkaufsID=" + VerkaufsID + ", KundenID=" + KundenID + ", Datum=" + Datum + "]";
	}
	
	

}
