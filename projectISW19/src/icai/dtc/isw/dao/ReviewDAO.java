package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public static boolean uploadReview(Review review, int idProduct) {
		boolean status = false;
		Connection con=ConnectionDAO.getInstance().getConnection();
		try{
			PreparedStatement pst = con.prepareStatement("INSERT INTO \"Reviews\"(\"ID_Product\", \"ID_User\", \"Title_Comment\", \"Comment\", \"Score_Product\", \"Score_Review\", \"Score_Review_Participants\",) VALUES(?,?,?,?,?,?,?)");
			
			pst.setInt(1, idProduct);
			pst.setInt(2,UserDAO.getUserID(review.getUser()));
			pst.setString(3,review.getCommentTitle());
			pst.setString(4, review.getComment());
			pst.setInt(5, review.getProductScore());
			pst.setInt(6, 0);
			pst.setInt(7, 0);

			pst.executeUpdate();
			status = true;

       } catch (SQLException e) {
           System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
       } catch (Exception e) {
           e.printStackTrace();
       }
		return status;
	}	
	public static void main(String[] args) {
		
		Product product = null;
		ReviewDAO.loadProductReview(product);
	}
}
	