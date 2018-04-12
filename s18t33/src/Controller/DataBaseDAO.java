package Controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseDAO {
	private static String url = "";
	private static String userName = "";
	private static String passWord = "";
	private static String hostName = "";
	private static final String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Statement statement;
	private static DatabaseMetaData databaseMetaData;
	private static ResultSet resultSet;
	private static Connection connection = null;
	public static void setUserDetails(DataBaseAccessBean dbAcess) {// sets the user details needed to setup the
		// connection

		// TODO Auto-generated method stub
		userName = dbAcess.getUserName();
		passWord = dbAcess.getPassWord();
		hostName = dbAcess.getDbHostName();

		url = "jdbc:mysql://"+ hostName.trim()+":3306/world";

	}

	public static Connection getConnection() {

		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(url, userName, passWord);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			databaseMetaData = connection.getMetaData();
			resultSet = databaseMetaData.getCatalogs();

			// set status to true - established connection
		} // end try
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // end catch

		catch (SQLException e) {
			System.out.println(e.getMessage());
		} // end catch
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // end catch

		return connection;

	}

	public String displayResults(String sqlQuery) {

		String finalResult = "";


		try {
			connection = DataBaseDAO.getConnection();
			if (connection != null) {
				resultSet = statement.executeQuery(sqlQuery);
			
	
			}
			System.out.println("resultSet"+resultSet.next()+"dd"+resultSet);
			

				finalResult = resultSet.getInt(1)+"";
				System.out.println("fr"+finalResult);
			}
		
			

		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return finalResult;

	}
	
	public void closeConnection() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}