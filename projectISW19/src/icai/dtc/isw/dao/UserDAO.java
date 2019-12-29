package icai.dtc.isw.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.User;

public class UserDAO {
	public static User getUser(int i) {
		User user = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Users\" WHERE \"ID_User\" = " + i);
			ResultSet rs = pst.executeQuery()) {
			if(rs.next()) {
				user = new User(rs.getString(4), rs.getString(2), rs.getString(3), rs.getDate(5), rs.getString(6), rs.getString(7),null);
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return user;
	}
	//LOGIN-> el metodo funciona tanto si el campo name es el nombre de usuario o es el correo
		//COMPROBAR QUE FUNCIONA

		/*public static boolean chicPermision(String name, String password) {
			boolean permision = false;
			Connection con=ConnectionDAO.getInstance().getConnection();
			//WE NEED QUERY FOR GET THE INFO WITH EACH ID
			try (PreparedStatement pst = con.prepareStatement("SELECT EXISTS(	SELECT * FROM \"Users\" WHERE ( \"Name\" = " + name + "or \"E-mail\" = " + name + " ) and \"Password\" = " + password + ")");
				ResultSet rs = pst.executeQuery()) {
				permision=Boolean.parseBoolean(rs.getString(1));//si no es ni true ni false por defecto es false
				
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return permision;
		}*/
	public static User login(String name, String password) {
		User user = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Users\" WHERE (\"Name\" = " + name + " OR \"E-mail\" = " + name + ") AND \"Password\" = " + password);
			ResultSet rs = pst.executeQuery()) {

			if(rs.next()) {
				user = new User(rs.getString(4), rs.getString(2), rs.getString(3), rs.getDate(5), rs.getString(6), rs.getString(7),null);
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		
		return user;
	}
	public static boolean uploadUser(User user) {
		boolean status = false;
		Connection con=ConnectionDAO.getInstance().getConnection();
		try{
			PreparedStatement pst = con.prepareStatement("INSERT INTO \"Users\"(\"E-mail\", \"Password\", \"Name\", \"Birth_Date\", \"Skin_Color\", \"Skin_Condition\", \"Image\") VALUES(?,?,?,?,?,?,?)");
			
			pst.setString(1,user.getEmail());
			pst.setString(2,user.getPassword());
			pst.setString(3,user.getName());
			pst.setDate(4, new java.sql.Date(user.getBirthDate().getTime()));
			pst.setString(5,user.getSkinColor());
			pst.setString(6,user.getSkinCondition());
			pst.setBytes(7,null);//UserDAO.getImageBytes(user.getProfileImage()));

			pst.executeUpdate();
			status = true;

       } catch (SQLException e) {
           System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
       } catch (Exception e) {
           e.printStackTrace();
       }
		return status;
	}
	public static int getUserID(User user) {
		int id = -1;
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT \"ID_User\" FROM  \"Products\" WHERE \"Name\" = " + user.getName());
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				id = rs.getInt(1);
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        
        }
		return id;
	}
	private static byte[] getImageBytes(ImageIcon image) {
		byte[] imgBytes = null;
		try {
	    	BufferedImage bImage = (BufferedImage) image.getImage();
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", bos );
			imgBytes = bos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return imgBytes;
	}
}
