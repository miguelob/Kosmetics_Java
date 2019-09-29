package kosmetics.dominio;


public class Review{

    public final int idUser;
    private String name;
    private String email;
    private String userPasword;
    private String birthDate; //formato: dia-mes-año
    private String skinColor;
    private String skinCondition;

    public Producto(int idUser,String name,String email,String userPasword,
                    String birthDate,String skinColor,String skinCondition){

        this.idUser=idUser
        this.name=name
        this.email=email
        this.userPasword=userPasword
        this.birthDate=birthDate
        this.skinColor=skinColor
        this.skinCondition=skinCondition
    }


}