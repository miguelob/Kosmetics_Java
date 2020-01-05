package icai.dtc.isw.controler;

import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.dao.ReviewDAO;
import icai.dtc.isw.dao.SurveyDAO;
import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;
import icai.dtc.isw.domain.User;


public class ReviewControler {
	public boolean uploadReview(Review review, Product product) {
		return ReviewDAO.uploadReview(review,product);
	}

	public void getReviews(User tempUser, ArrayList<Review> reviewList) {
		// TODO Auto-generated method stub
		ReviewDAO.getReviews(tempUser, reviewList);
		
	}
	public boolean uploadSurvey(Product product, HashMap<Integer,int[]> ans) {
		return SurveyDAO.uploadSurvey(product,ans);
	}
}
