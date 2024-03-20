package jewellers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
	public String INSERT_QUERY = "INSERT INTO JEWELLER VALUES (?,?,?,?,?,?,?)";
	public String INSERT_QUERY1 = "INSERT INTO  DITAILS VALUES(?,?,?,?,?,?,?,?,?,?)";
	public String FIND_DETAILS = "SELECT * FROM JEWELLER WHERE ID=? AND FIRST=?";
	public String FORGET_PIN="SELECT * FROM JEWELLER WHERE FIRST=? AND LAST=?";

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "krishna");
		} catch (SQLException e) {
			System.out.println("sorry...");
		}

		return con;
	}

}
