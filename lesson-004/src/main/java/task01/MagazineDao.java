package task01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`name`, `isbn`, `genre_id`) values (?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set name=?, isbn=?, genre_id=? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";

	private Connection connection;

	public MagazineDao(Connection connection) {
		this.connection = connection;
	}

	public MagazineDao() {

	}

	public List<Magazine> readAll() {
		List<Magazine> listOfMagazines = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL)) {
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfMagazines.add(MagazineMapper.map(result));
			}
			return listOfMagazines;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Magazine magazine) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getIsbn());
			preparedStatement.setInt(3, magazine.getGenre_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Magazine read(int id) throws SQLException {
		ResultSet result = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID)) {
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.next();
			return MagazineMapper.map(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Magazine magazine, int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getIsbn());
			preparedStatement.setInt(3, magazine.getGenre_id());
			preparedStatement.setInt(4, id);
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