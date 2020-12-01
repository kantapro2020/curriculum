package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.EmployeeBean;

public class EmployeeService {
	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
	private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
	private static final String SQL_UPDATE = "update employee_table set login_time = ? where id = ?";
	private static final String SQL_SELECT = "select * from employee_table where id = ? and password = ?";
	EmployeeBean employeeDate = null;
	public EmployeeBean search(String id, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName(POSTGRES_DRIVER);
			connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
			statement = connection.createStatement();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);
			String login_time = sdFormat.format(cal.getTime());
			preparedStatement = connection.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, login_time);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.executeLargeUpdate();
			preparedStatement = connection.prepareStatement(SQL_SELECT);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tmpName = resultSet.getString("name");
				String tmpComment = resultSet.getString("comment");
				String tmpLoginTime = resultSet.getString("login_time");
				employeeDate = new EmployeeBean();
				employeeDate.setName(tmpName);
				employeeDate.setComment(tmpComment);
				employeeDate.setLogin_Time(tmpLoginTime);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeDate;
	}
}
