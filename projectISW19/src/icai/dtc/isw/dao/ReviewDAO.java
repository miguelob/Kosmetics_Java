package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;

public class ReviewDAO {
	public static void loadProductReview(Product product) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		//QUERY for loading reviews. we also need the query user
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Review\"");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	product.addReview(new Review(UserDAO.getUser(rs.getInt(2)), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		Product product = null;
		ReviewDAO.loadProductReview(product);
	}
}
	