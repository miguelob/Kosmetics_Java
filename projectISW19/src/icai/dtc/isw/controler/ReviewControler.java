package icai.dtc.isw.controler;

import icai.dtc.isw.dao.ReviewDAO;
import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;


public class ReviewControler {
	public boolean uploadReview(Review review, Product product) {
		return ReviewDAO.uploadReview(review,product);
	}
}
