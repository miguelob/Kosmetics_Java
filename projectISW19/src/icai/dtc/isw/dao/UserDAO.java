package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import icai.dtc.isw.domain.User;

public class UserDAO {
	public static void getUser(ArrayList<User> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Producto\"");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
}
