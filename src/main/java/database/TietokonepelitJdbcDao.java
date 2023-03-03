package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tietokonepeli;

public class TietokonepelitJdbcDao implements TietokonepelitDAO {


	public List<Tietokonepeli> findAll() {
		Connection connection = null; //  database yhteys
		PreparedStatement statement = null; // sql lause
		ResultSet resultset = null; // kyselyn tulostaulu
		List<Tietokonepeli> tietokonepelit = new ArrayList<Tietokonepeli>();
		Tietokonepeli tietokonepeli = null;
		try {

			connection = Database.getDBConnection();  // tietokantayhteyden muodostaminen
			String sqlSelect = "SELECT * FROM game;";
			statement = connection.prepareStatement(sqlSelect); // SQL-lauseolion valmistelu
			resultset = statement.executeQuery(); // SELECT-lauseen suorittaminen

			while (resultset.next()) { // menee läpi yksi rivi kerrallaan
				tietokonepeli = createTietokonepeliObjectFromRow(resultset);
				tietokonepelit.add(tietokonepeli);

			}
		} catch (SQLException e) { // mitä tapahtuu virhetilanteessa
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, statement, connection); // database-yhteyden sulku
		}
		return tietokonepelit;
	}

	public Tietokonepeli findById(int id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Tietokonepeli tietokonepeli = null;
		
		connection = Database.getDBConnection();
    	

        try{  
                String sql = "SELECT * FROM game WHERE id=?";
                statement = connection.prepareStatement(sql);
                
                	statement.setInt(1, id);
                	resultset = statement.executeQuery();
                    if(resultset.next()){
 
                        int peliid = resultset.getInt(1);
                        String nimi = resultset.getString(2);
                        double hinta = resultset.getDouble(3);
                        String julkaisupaiva = resultset.getString(4);
                        String lajityyppi = resultset.getString(5);
                        String kehittaja = resultset.getString(6);
                        tietokonepeli = new Tietokonepeli(peliid, nimi, hinta, julkaisupaiva, lajityyppi, kehittaja);
                    }
                
            
        }catch(Exception ex)
	{
		System.out.println(ex);
	}
        return tietokonepeli;
}

	private static Tietokonepeli createTietokonepeliObjectFromRow(ResultSet resultset) {
		
		// Haetaan yhden asiakkaan tiedot kyselyn tulostaulun (resultset-
		//olion) aktiiviselta tietoriviltä, ja luodaan ja palautetaan Asiakasluokan olio
		
		try {

			int id = resultset.getInt("id");
			String nimi = resultset.getString("name");
			double hinta = resultset.getDouble("price");
			String julkaisupaiva = resultset.getString("releaseDate");
			String lajityyppi = resultset.getString("genre");
			String kehittaja = resultset.getString("developer");

			return new Tietokonepeli(id, nimi, hinta, julkaisupaiva, lajityyppi, kehittaja);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addGame(Tietokonepeli tietokonepeli) {

		Connection connection = null;
		PreparedStatement sqlInsert = null;
		boolean executionSuccessed = false;

		connection = Database.getDBConnection();

		try {
			sqlInsert = connection.prepareStatement("INSERT INTO game "
					+ " (name, price, releaseDate, genre, developer) " + " VALUES " + " (?, ?, ?, ?, ?);");
			sqlInsert.setString(1, tietokonepeli.getNimi());
			sqlInsert.setDouble(2, tietokonepeli.getHinta());
			sqlInsert.setString(3, tietokonepeli.getJulkaisupaiva());
			sqlInsert.setString(4, tietokonepeli.getLajityyppi());
			sqlInsert.setString(5, tietokonepeli.getKehittaja());

			if (sqlInsert.executeUpdate() == 1) // SQL INSERT-lauseen suor.
				executionSuccessed = true;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqlInsert, connection);
		}

		return executionSuccessed;
	}

	@Override
	public boolean removeGame(int tietokonepeliId) {

		Connection connection = null;
		PreparedStatement sqlstatment = null;
		boolean executionSuccessed = false;

		connection = Database.getDBConnection();

		try {
			String sqlDeleteStr = "DELETE FROM game WHERE id = ?;";

			sqlstatment = connection.prepareStatement(sqlDeleteStr);
			sqlstatment.setInt(1, tietokonepeliId);
			if (sqlstatment.executeUpdate() == 1) // DELETE lauseen suor.
				executionSuccessed = true;
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqlstatment, connection);
		}

		return executionSuccessed;

	}

	public boolean updateGame(Tietokonepeli tietokonepeli) {

		Connection connection = null;
		PreparedStatement sqlstatment = null;
		boolean executionSuccessed = false;
		connection = Database.getDBConnection();

		try {
			String sqlUpdate = "UPDATE game " + " SET name=?, price=?, releaseDate=?, genre=?, developer=? "
					+ " WHERE id = ? ";

			sqlstatment = connection.prepareStatement(sqlUpdate);
		

			sqlstatment.setString(1, tietokonepeli.getNimi()); // laittaa ominaisuuden jokaisen "?" merkin tilalle
			sqlstatment.setDouble(2, tietokonepeli.getHinta());
			sqlstatment.setString(3, tietokonepeli.getJulkaisupaiva());
			sqlstatment.setString(4, tietokonepeli.getLajityyppi());
			sqlstatment.setString(5, tietokonepeli.getKehittaja());
			sqlstatment.setInt(6, tietokonepeli.getId());

			if (sqlstatment.executeUpdate() == 1) // SQL UPDATE -lauseen suor.
				executionSuccessed = true;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(sqlstatment, connection);
		}

		return executionSuccessed;

	}

}
