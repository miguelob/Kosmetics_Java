package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Review implements Serializable{
	
	private static final long serialVersionUID = 1L;
    public final int idReview;
    public final int idProduct;
    public final int idUser;
    private int scoreProduct; //entre 0 y 10
    private int scoreReview; //normalizada (puntuacion maxima)
    private int scoreReviewParticipants; //numero de gente que ha votado
    private String comentario;

    public Review(int idReview, int idProduct,int idUser,int scoreProduct,
					int scoreReview,int scoreReviewParticipants,String comentario ){

        this.idReview=idReview;
		this.idProduct=idProduct;
		this.idUser=idUser;
		this.scoreProduct=scoreProduct;
		this.scoreReview=scoreReview;
		this.scoreReviewParticipants=scoreReviewParticipants;
		this.comentario=comentario;
    }


}