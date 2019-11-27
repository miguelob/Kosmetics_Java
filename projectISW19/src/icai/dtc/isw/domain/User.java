package icai.dtc.isw.domain;

import java.util.Date;

import javax.swing.ImageIcon;

import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
    //public final int idUser;
    private String name;
    private String email;
    private char[] userPassword;
    private Date birthDate;
    private String skinColor;
    private String skinCondition;
    private ImageIcon userImage;

    public User(String name,String email,char[] userPasword,
                    Date birthDate,String skinColor,String skinCondition, byte[] imageBytes){

        //this.idUser=idUser;
        this.name=name;
        this.email=email;
        this.userPassword=userPasword;
        this.birthDate=birthDate;
        this.skinColor=skinColor;
        this.skinCondition=skinCondition;
        this.setImage(imageBytes);
    }
    public User(String name, String email, char[] userPassword){
        this.name=name;
        this.email=email;
        this.userPassword=userPassword;
    }
    private void setImage(byte[] imageBytes) {
    	if(imageBytes != null)
    		userImage = new ImageIcon(imageBytes);
    	else
    		userImage = new ImageIcon("media/images/NF.jpg");
    }
    public String getName() {
    	return name;
    }
    public String getEmail() {
    	return email;
    }
    public String getPassword() {
    	return userPassword;
    }
    public Date getBirthDate() {
    	return birthDate;
    }
    public String getSkinColor() {
    	return skinColor;
    }
    public String getSkinCondition() {
    	return skinCondition;
    }
    public ImageIcon getProfileImage() {
    	return userImage;
    }


}