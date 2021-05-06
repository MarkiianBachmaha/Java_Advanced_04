package task01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper {

	public static Genre map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		return new Genre(id, name);
	}

}