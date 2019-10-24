package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.domain.Review;


public class ReviewController {
	public void getReview(ArrayList<Review> lista) {
		ReviewDAO.getReview(lista);
	}
}
