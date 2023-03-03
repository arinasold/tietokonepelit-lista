package database;

import java.util.List;
import model.Tietokonepeli;

public interface TietokonepelitDAO {

	public List<Tietokonepeli> findAll();
	public Tietokonepeli findById(int id);
	public boolean addGame(Tietokonepeli tietokonepeli);
	public boolean removeGame(int tietokonepeliId);
	public boolean updateGame(Tietokonepeli tietokonepeli);
}
