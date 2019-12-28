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
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Reviews\" WHERE \"ID_Product\" = " + product.getId());
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	product.addReview(new Review(UserDAO.getUser(rs.getInt(3)), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(5), rs.getString(4)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}

		
	public static Collection userReviews(String email) {
		User user = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Review\" WHERE \"Users.E-mail\" = "+ email +" INNER JOIN \"Users\" ON \"Users.ID_User\" = \"Review.ID_User\"");
			ResultSet rs = pst.executeQuery()) {

			while(rs.next()) {
				//no se en que orden van a ir los campos
				//user = new User(rs.getString(4), rs.getString(2), rs.getString(3), rs.getDate(5), rs.getString(6), rs.getString(7),null);
			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		
		return user;
	}

	public static void main(String[] args) {
		
		Product product = null;
		ReviewDAO.loadProductReview(product);
	}
}
