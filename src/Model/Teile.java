package Model;
/**
 * In dieser Klasse werden die Daten der Ersatzteile abgespeichert
 * @author Reichhold und Schlögl
 *
 */
public class Teile {

	private int TeileID;
	private int VerkaufsID;
	private String kompatibleKFZ;
	private double preis;
	private boolean Verfügbarkeit;
	private String Bezeichnung;
	
	
	public Teile() {
		super();
	}

	/**
	 * @param teileID Ist eine eindeutige Zahl, die jedes Teil besitzt
	 * @param verkaufsID Ist die eindeutige Bezeichnung jedes Verkaufs
	 * @param kompatibleKFZ Eine List aller Autos, die mit dem Teil kompatibel sind
	 * @param preis Ist der Preis pro Stück
	 * @param verfügbarkeit Ist true wenn der Artikel versandbereit ist, false wenn nicht
	 * @param bezeichnung Ist der Komplette Name des Teils
	 */
	public Teile(int teileID, int verkaufsID, String kompatibleKFZ, double preis, boolean verfügbarkeit,
			String bezeichnung) {
		super();
		TeileID = teileID;
		VerkaufsID = verkaufsID;
		this.kompatibleKFZ = kompatibleKFZ;
		this.preis = preis;
		Verfügbarkeit = verfügbarkeit;
		Bezeichnung = bezeichnung;
	}
	
	/**
	 * @return Gibt die Teile ID zurueck
	 */
	public int getTeileID() {
		return TeileID;
	}
	/**
	 * Setzt die ID des Teils
	 * @param teileID
	 */
	public void setTeileID(int teileID) {
		TeileID = teileID;
	}
	/**
	 * @return Gibt die VerkaufsID zurück
	 */
	public int getVerkaufsID() {
		return VerkaufsID;
	}
	/**
	 * Setzt die Verkaufs ID
	 * @param verkaufsID
	 */
	public void setVerkaufsID(int verkaufsID) {
		VerkaufsID = verkaufsID;
	}
	/**
	 * @return gibt eine Liste von kompatiblen KFZ zurück
	 */
	public String getKompatibleKFZ() {
		return kompatibleKFZ;
	}
	/**
	 * Setzt die kompatiblen KFZ
	 * @param kompatibleKFZ
	 */
	public void setKompatibleKFZ(String kompatibleKFZ) {
		this.kompatibleKFZ = kompatibleKFZ;
	}
	/**
	 * @return gibt den Preis des Teils zurück
	 */
	public double getPreis() {
		return preis;
	}
	/**
	 * setzt den Preis des Teils
	 * @param preis ... der Preis des Teils
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	/**
	 * Ziegt an ob ein Teil gerade Verfügbar ist oder nicht
	 * @return ... bei Verfügbarkeit true, sonst false
	 */
	public boolean isVerfügbarkeit() {
		return Verfügbarkeit;
	}
	
	/**
	 * setzt die Verfügbarkeit eines Teils
	 * @param verfügbarkeit ... bei Verfügbarkeit true, sonst false
	 */
	public void setVerfügbarkeit(boolean verfügbarkeit) {
		Verfügbarkeit = verfügbarkeit;
	}
	
	/**
	 * gibt die Bezeichnung eines Teils zurück
	 * @return
	 */
	public String getBezeichnung() {
		return Bezeichnung;
	}
	
	/**
	 * setzt die Bezeichnung eines Teils
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}
	
	/**
	 * Verbindet alle Informationen eines Teils zu einem String
	 */
	@Override
	public String toString() {
		return "Teile [TeileID=" + TeileID + ", VerkaufsID=" + VerkaufsID + ", kompatibleKFZ=" + kompatibleKFZ
				+ ", preis=" + preis + ", Verfügbarkeit=" + Verfügbarkeit + ", Bezeichnung=" + Bezeichnung + "]";
	}
	

}
