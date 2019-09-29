package kosmetics.dominio;


public class Review{

    public final int idReview;
    public final int idProduct;
    public final int idUser;
    private int scoreProduct; //entre 0 y 10
    private int scoreReview; //normalizada (puntuación máxima 5)
    private int scoreReviewParticipants; //número de gente que ha votado
    private String comentario;

    public Producto(int idReview, int idProduct,int idUser,int scoreProduct,
					int scoreReview,int scoreReviewParticipants,String comentari ){

        this.idReview=idReview;
		this.idProduct=idProduct;
		this.idUser=idUser;
		this.scoreProduct=scoreProduct;
		this.scoreReview=scoreReview;
		this.scoreReviewParticipants=scoreReviewParticipants;
		this.comentario=comentario;
    }


}