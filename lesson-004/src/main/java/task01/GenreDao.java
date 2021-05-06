package task01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {

	private static String READ_ALL = "select * from genre";
	private static String CREATE = "insert into genre(`name`) values (?)";
	private static String READ_BY_ID = "select * from genre where id =?";
	private static String UPDATE_BY_ID = "update genre set name=? where id = ?";
	private static String DELETE_BY_ID = "delete from genre where id=?";

	private Connection connection;

	public GenreDao(Connection connection) {
		this.connection = connection;
	}

	public List<Genre> readAll() {
		List<Genre> listOfGenres = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL)) {
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfGenres.add(GenreMapper.map(result));
			}
			return listOfGenres;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Genre genre) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
			preparedStatement.setString(1, genre.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Genre read(int id) throws SQLException {
		ResultSet result = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID)) {
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.next();
			return GenreMapper.map(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Genre genre, int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
			preparedStatement.setString(1, genre.getName());
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}