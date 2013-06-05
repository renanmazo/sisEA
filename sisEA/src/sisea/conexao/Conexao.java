package sisea.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	private Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	
	private static String link = "jdbc:mysql://cpmy0031.servidorwebfacil.com/arte2_siseas";
	private static String usuario = "arte2_sisea";
	private static String senha = "tcc123";

	private static String altlink = "jdbc:mysql://localhost/db_sisea";
	private static String altusuario = "root";
	private static String altsenha = "root";
	
	public Connection getConexao() throws SQLException {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(link, usuario, senha);
		} catch (SQLException e) {
			if(e.getSQLState().equals("42000")){
				conn = DriverManager.getConnection(altlink, altusuario, altsenha);
			}

		} catch (ClassNotFoundException e) {
			
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