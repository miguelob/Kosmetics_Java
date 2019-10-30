package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Review implements Serializable{
	
	private static final long serialVersionUID = 1L;
    //public final int idReview;
    //public final int idProduct;
    private User user;//Usuario info basica
    private int scoreProduct; //entre 0 y 10
    private int scoreProductParticipants; //entre 0 y 10
    private int scoreReview; //normalizada (puntuacion maxima)
    private int scoreReviewParticipants; //numero de gente que ha votado    
    private String comentario;
    private String comentarioTitle;
    private String productName;

    public Review(User user,int scoreProduct,int scoreProductParticipants,
					int scoreReview,int scoreReviewParticipants,String comentario,
					String comentarioTitle){

        //this.idReview=idReview;
		//this.idProduct=idProduct;
		this.user=user;
		this.scoreProduct=scoreProduct;
		this.scoreProductParticipants=scoreProductParticipants;
		this.scoreReview=scoreReview;
		this.scoreReviewParticipants=scoreReviewParticipants;
		this.comentario=comentario;
		this.comentarioTitle=comentarioTitle;
    }
    public void setProductName(String productName) {
    	this.productName = productName;
    }
    public String getProductName() {
    	return productName;
    }


}