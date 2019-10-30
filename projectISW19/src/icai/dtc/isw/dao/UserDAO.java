package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import icai.dtc.isw.domain.User;

public class UserDAO {
	public static User getUser(int i) {
		User user = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Producto\"");
			ResultSet rs = pst.executeQuery()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getBytes(7));
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return user;
	}
}
