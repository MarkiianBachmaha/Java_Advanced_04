package task01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {

	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int genre_id = result.getInt("genre_id");
		String name = result.getString("name");
		String isbn = result.getString("isbn");
		return new Magazine(id, name, isbn, genre_id);
	}

}