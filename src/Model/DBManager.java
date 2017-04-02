package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 * In dieser Klasse befinden sich die Methoden, welche Daten aus der Datenbank abfragt, ändert.
 * @author Reichhold & Schlögl
 *
 */
public class DBManager {
	
	private static DBManager instance = null;
	private Connection conn;
	
	public DBManager() throws ClassNotFoundException, SQLException{	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Ersatzteillager", "root", "");

	}

	public static DBManager Instance() throws ClassNotFoundException, SQLException{
		if(instance == null){
			instance = new DBManager();
		}
		return instance;
	}
	
	/**
	 * Hier werden die Daten der Kunden gespeichert
	 * @param kunde ... Hier wird das Kundenobjekt übergeben
	 * Falls das übergebene Teil noch nit vorhanden ist, wird ein neues hinzugefügt
	 * anderenfalls wird das aktuelle Kunde überschrieben
	 */
	public void Save(Kunden kunde){
		String sql;
		PreparedStatement stmt = null;
		try{
			if(kunde.getKundenID() < 0){
				// INSERT
				sql = "Insert INTO Kunde values (null,?,?,?,?,?);";
				stmt = conn.prepareStatement(sql);
								
					stmt.setString(1,kunde.getVorname());
					stmt.setString(2,kunde.getNachname());
					stmt.setInt(3,kunde.getPlz());
					stmt.setString(4,kunde.getOrt());
					stmt.setString(5,kunde.getStrasse());
					stmt.setInt(6,kunde.getHausnummer());
					
					stmt.executeUpdate();
				
					stmt.close();
					
			}else{
				
				String sql2 = "UPDATE Kunde SET vorname=?, nachname=?, plz=?, ort=?,  strassenname=?, hausnummer=?, land=? WHERE id=?";
				stmt = conn.prepareStatement(sql2);
				
				stmt.setString(1,kunde.getVorname());
				stmt.setString(2,kunde.getNachname());
				stmt.setInt(3,kunde.getPlz());
				stmt.setString(4,kunde.getOrt());
				stmt.setString(5,kunde.getStrasse());
				stmt.setInt(6,kunde.getHausnummer());
				
				stmt.executeUpdate();
			
				stmt.close();
				
			
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
				/*
	int verleihID;
	int hausnummer;
	String strassenname;
	int plz;
	String ort;
	String land;*/

	}
	
	/**
	 * Speichern eines Teiles
	 * @param teile
	 * @throws SQLException
	 * Falls das übergebene Teil noch nit vorhanden ist, wird ein neues hinzugefügt
	 * anderenfalls wird das aktuelle Teil überschrieben
	 */
	public void Save(Teile teile){
		PreparedStatement stmt = null;
		String sql;
		
		try {
			if(teile.getTeileID() < 0){
				// INSERT
				sql = "Insert INTO Teile values (null,?,?,?,?,?);";
				stmt = conn.prepareStatement(sql);
			
				stmt.setInt(1,teile.getVerkaufsID());
				stmt.setString(2,teile.getKompatibleKFZ());
				stmt.setDouble(3,teile.getPreis());
				stmt.setBoolean(4,teile.isVerfügbarkeit());
				stmt.setString(5,teile.getBezeichnung());
				
				stmt.executeUpdate();
			
				stmt.close();
				
			
			
			}else{
				// UPDATE
				String sql2 = "UPDATE Teile SET verkaufsID = ?, kompatibleKFZ = ?, preis=?, verfügbarkeit=?, bezeichnung=? WHERE id=?";
				stmt = conn.prepareStatement(sql2);
				
				stmt.setInt(1,teile.getVerkaufsID());
				stmt.setString(2,teile.getKompatibleKFZ());
				stmt.setDouble(3,teile.getPreis());
				stmt.setBoolean(4,teile.isVerfügbarkeit());
				stmt.setString(5,teile.getBezeichnung());
				
				stmt.executeUpdate();
			
				stmt.close();
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Hier werden die Daten eines Verkaufs gespeichert
	 * @param verkauf ... Hier wird das Verkaufsobjekt übergeben
	 * Falls der übergebene Verkauf noch nit vorhanden ist, wird ein neuer hinzugefügt
	 * anderenfalls wird der aktuelle Verkauf überschrieben
	 */
	public void Save(Verkauf verkauf){
		PreparedStatement stmt = null;
		String sql;
		
		try {
			if(verkauf.getVerkaufID() < 0){
				// INSERT
				sql = "Insert INTO Verkauf values (null,?,?);";
				stmt = conn.prepareStatement(sql);
			
				stmt.setInt(1,verkauf.getKundenID());
				stmt.setString(2, verkauf.getDatum());
				
				stmt.executeUpdate();
			
				stmt.close();
				
			
			
			}else{
				// UPDATE
				String sql2 = "UPDATE Verkauf SET verkaufsID = ?, KundenID = ?, datum = ? WHERE id=?";
				stmt = conn.prepareStatement(sql2);
				
				stmt.setInt(1,verkauf.getVerkaufID());
				stmt.setInt(2,verkauf.getKundenID());
				stmt.setString(3, verkauf.getDatum());
				
				stmt.executeUpdate();
			
				stmt.close();
							
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * durchsucht die alle Teile nach einem eingebenen Stichwort
	 * @param word ... das gesuchte Stichwort, welches in der Beschreibung vorkommen soll
	 * @return ... gibt eine ArrayList an gefundenen Teile zurück
	 */
	public ArrayList<Teile> searchTeile(String word){
		
		ArrayList<Teile> teileAL = new ArrayList<Teile>();
		PreparedStatement stmt = null;
		String sql;
		ResultSet rs;
		
		try {
			sql = "Select * from Teile where bezeichnung like ?";
			stmt = conn.prepareStatement(sql);
		
			stmt.setString(1,"%"+word+"%");
			
			rs = stmt.executeQuery();
		
			
			while(rs.next()){
				Teile t = new Teile();
				
				t.setTeileID(rs.getInt("teileID"));
				t.setVerkaufsID(rs.getInt("verkaufsID"));
				t.setKompatibleKFZ(rs.getString("kompatibleKFZ"));
				t.setPreis(rs.getDouble("preis"));
				t.setVerfügbarkeit(rs.getBoolean("verfuegbarkeit"));
				t.setBezeichnung(rs.getString("bezeichnung"));
				
				teileAL.add(t);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( teileAL);
		
		return teileAL;
	}

	/**
	 * durchsucht die alle Teile nach der eingegeben Teile ID
	 * @param TeileID ... die gesuchte TeileID nach der gesucht werden soll
	 * @return ... gibt eine ArrayList an gefundenen Teile zurück
	 */
public ArrayList<Teile> searchTeile(int TeileID) throws SQLException{
		
		ArrayList<Teile> teileAL = new ArrayList<Teile>();
		PreparedStatement stmt;
		String sql;
		ResultSet rs;
		
		try {
			sql = "Select * from Teile where teileID = ?";
			stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1, TeileID);
			
			rs = stmt.executeQuery();
		
			
			Teile t = new Teile();

			while(rs.next()){
				
				t.setTeileID(rs.getInt("teileID"));
				t.setVerkaufsID(rs.getInt("verkaufsID"));
				t.setKompatibleKFZ(rs.getString("kompatibleKFZ"));
				t.setPreis(rs.getDouble("preis"));
				t.setVerfügbarkeit(rs.getBoolean("verfuegbarkeit"));
				t.setBezeichnung(rs.getString("bezeichnung"));
				
				teileAL.add(t);
				
				
			}
			rs.close();
			stmt.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println(teileAL);
		
		
		return teileAL;
	}

	/**
	 * durchsucht die alle Kunden nach einem eingebenen Stichwort
	 * @param word ... das gesuchte Stichwort, welches im Vornamen oder im Nachname vorkommt
	 * @return ... gibt eine ArrayList an gefundenen Kunden zurück
	 */
	public ArrayList<Kunden> searchKunden(String word){
		
		ArrayList<Kunden> kundenAL = new ArrayList<Kunden>();
		PreparedStatement stmt = null;
		String sql;
		ResultSet rs;
		
		try {
			sql = "Select * from Kunden where vorname like ? or nachname like ?";
			stmt = conn.prepareStatement(sql);
		
			stmt.setString(1,"%"+word+"%");
			stmt.setString(2,"%"+word+"%");
			
			rs = stmt.executeQuery();
		
			stmt.close();
			
			while(rs.next()){
				Kunden k = new Kunden();	
				k.setKundenID(rs.getInt("KundenID"));
				k.setVorname(rs.getString("vorname"));
				k.setNachname(rs.getString("nachname"));
				k.setPlz(rs.getInt("PLZ"));
				k.setOrt(rs.getString("ort"));
				k.setStrasse(rs.getString("strasse"));
				k.setHausnummer(rs.getInt("hausnummer"));
				

				kundenAL.add(k);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kundenAL;
	}
	
	/**
	 * durchsucht die alle Kunden nach der eingegeben Kunden ID
	 * @param KundenID ... die gesuchte Kunden nach der gesucht werden soll
	 * @return ... gibt eine ArrayList an gefundenen Kunden zurück
	 */
	public ArrayList<Kunden> searchKunden(int kundenID){
		
		ArrayList<Kunden> kundenAL = new ArrayList<Kunden>();
		PreparedStatement stmt = null;
		String sql;
		ResultSet rs;
		
		try {
			sql = "Select * from Kunden where KundeID = ?";
			stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1, kundenID);
			
			rs = stmt.executeQuery();
		
			stmt.close();
			
			while(rs.next()){
				Kunden k = new Kunden();	
				k.setKundenID(rs.getInt("KundenID"));
				k.setVorname(rs.getString("vorname"));
				k.setNachname(rs.getString("nachname"));
				k.setPlz(rs.getInt("PLZ"));
				k.setOrt(rs.getString("ort"));
				k.setStrasse(rs.getString("strasse"));
				k.setHausnummer(rs.getInt("hausnummer"));
				

				kundenAL.add(k);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kundenAL;
	}
	
	/**
	 * durchsucht die alle Verkäufe nach der eingegeben TeileID oder VerkaufsID
	 * @param id ... die gesuchte TeileID oder VerkaufsID nach der gesucht werden soll
	 * @return ... gibt eine ArrayList an gefundenen Teile zurück
	 */
	public ArrayList<Verkauf> searchVerkäufe(int id){
		
		ArrayList<Verkauf> verkaufsAL = new ArrayList<Verkauf>();
		PreparedStatement stmt = null;
		String sql;
		ResultSet rs;
		
		try {
			sql = "Select * from Verkauf where verkaufsID = ? OR teileID = ?";
			stmt = conn.prepareStatement(sql);
		
			stmt.setInt(1, id);
			stmt.setInt(2, id);
			
			rs = stmt.executeQuery();
		
			stmt.close();
			
			while(rs.next()){
				Verkauf v = new Verkauf();	
				v.setVerkaufID(rs.getInt("verkaufsID"));
				v.setKundenID(rs.getInt("KundenID"));
				v.setDatum(rs.getString("Datum"));

				verkaufsAL.add(v);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verkaufsAL;
	}
	
	public void close() throws SQLException{
		conn.close();
	}
	

}
