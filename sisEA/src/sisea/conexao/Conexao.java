package sisea.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String link = "jdbc:mysql://localhost/db_sisea";
	private static String usuario = "root";
	private static String senha = "root";


	public Connection getConexao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(link, usuario, senha);

		} catch (SQLException e) {
			System.out.println(e);

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}

	public static void fecharConexoes(Connection connection,
			PreparedStatement preparedStatement) {
		fecharConexoes(null, connection, preparedStatement);
	}

	public static void fecharConexoes(ResultSet resultSet,
			Connection connection, PreparedStatement preparedStatement) {
		try {

			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();

			resultSet = null;
			preparedStatement = null;
			connection = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}