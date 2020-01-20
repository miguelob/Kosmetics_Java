import java.sql.*;
public class Clase{
	public static void main(String[] args){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://kosmeticsserver.ddns.net:5432/Kosmetics?user=cliente&password=cliente");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Users");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("E-mail: "+rs.getString(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
