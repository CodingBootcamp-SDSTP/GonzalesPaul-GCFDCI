import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class GCFWebsite
{
	public Connection conn;
	private Statement stmt;


	public UserDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:localhost/assetdb?users=assetdb&" + "password=testdb&serverTimezone=UTC&useSSL=false");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS friendzone ( id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, friendID INTEGER NOT NULL, comments VARCHAR(255) NOT NULL);");
			stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addFriends(int id, String comment) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO friendzone ( friendID, comments ) VALUES ( '" + id + "', '" + comment + "' );");
			System.out.println("Successfully added!");
			stmt.close();
		}
		catch(Exception e) {
			System.out.print("\n");
			System.out.println("friendID already exist: " + id);
			System.out.print("\n");
			e.printStackTrace();
		}
		return(true);
	}

	public boolean deleteFriends(int id) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet user = stmt.executeQuery("SELECT COUNT(*) FROM friendzone WHERE friendID='" + id + "';");
			if(user.getInt(1) >= 1) {
				stmt.executeUpdate("DELETE FROM friendzone WHERE friendID='"+ id +"';");
				System.out.println("friendID Deleted: " + id);
			}
			else if(user.getInt(1) == 0) {
				System.out.println("Account: " + id + " not existed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(true);
	}

	public boolean checkCredentials(int id, String comment) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet user = stmt.executeQuery("SELECT COUNT(*) FROM users WHERE friendID='" + id + "' AND comment='" + comments + "';");
			int count = user.getInt(1);
			System.out.println(count);
			if(count >= 1) {
				System.out.println("Account friendID: <" + id + "> and comment: <" + comments + "> existed");
			}
			else if(count == 0) {
				System.out.println("Account friendID: <" + id + "> and comment: <" + comments + "> not existed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(true);
	}

	public void listOfFriends() {
		StringBuilder sb = new StringBuilder();
		BufferedWriter bwriter = null;
		ResultSet rs = null;
		try {
			bwriter = new BufferedWriter(new FileWriter("AccountsList.xml"));
			rs = stmt.executeQuery("SELECT * FROM friendID;");
			sb.append("<friendzone>\n");
			while(rs.next()) {
				sb.append("\n\t<friendID>\n\t\t<id>" + rs.getString("id") + "</friendID>\n\t\t<comment>" + rs.getString("comment") + "</comment>\n\t<friendID>");
			}
			sb.append("\n</friendzone>");
			System.out.println(sb.toString());
			bwriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch(Exception e) {};
			try { if (stmt != null) stmt.close(); } catch(Exception e) {};
		}
	}
}

}
