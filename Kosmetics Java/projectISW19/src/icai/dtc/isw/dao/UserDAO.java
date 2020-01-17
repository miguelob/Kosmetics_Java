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
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Users\" WHERE (\"E-mail\" = '"+name+"' OR \"Name\" = '"+name+"') AND \"Password\" = '"+password+"'");
			ResultSet rs = pst.executeQuery()){

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
		try (PreparedStatement pst = con.prepareStatement("SELECT \"ID_User\" FROM  \"Users\" WHERE \"Name\" = '" + user.getName()+"'");
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				id = rs.getInt(1);
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        
        }
		return id;
	}
	public static boolean setFavorite(Product product, User user, boolean value) {
		boolean status = false;
		final Connection con=ConnectionDAO.getInstance().getConnection();
		try {
			final PreparedStatement pst = con.prepareStatement("UPDATE \"Favorites\" SET \"Value\" = '"+value+"' WHERE \"ID_User\" = '"+UserDAO.getUserID(user)+"' AND \"ID_Product\" = '"+ProductDAO.getProductID(product)+"'");
			pst.executeUpdate();
			status = true;
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return status;
	}
	public static boolean getFavoriteStatus(Product product, User user) {
		boolean status = false;
		final Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT \"Value\" FROM  \"Favorites\" WHERE \"ID_User\" = '"+UserDAO.getUserID(user)+"' AND \"ID_Product\" = '"+ProductDAO.getProductID(product)+"'");
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				status = rs.getBoolean(1);
			}
        } catch (SQLException ex) {
        	try{
    			PreparedStatement pst = con.prepareStatement("INSERT INTO \"Favorites\"(\"ID_Product\", \"ID_User\", \"Value\") VALUES(?,?,?)");
    			
    			pst.setInt(1,ProductDAO.getProductID(product));
    			pst.setInt(2,UserDAO.getUserID(user));
    			pst.setBoolean(3,false);

    			pst.executeUpdate();

           } catch (SQLException e) {
               System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
           }
            System.out.println(ex.getMessage());
        
        }
		return status;
	}
	public static void getFavorites(User user, ArrayList<Product> list) {
		final Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT \"ID_Product\" FROM  \"Favorites\" WHERE \"ID_User\" = '" +UserDAO.getUserID(user)+"' AND \"Value\" = '"+true+"'");
				ResultSet rs2 = pst.executeQuery()) {
			while (rs2.next()) {
				try (PreparedStatement pst2 = con.prepareStatement("SELECT * FROM \"Products\" WHERE \"ID_Product\" = '"+rs2.getInt(1)+"'");
		                ResultSet rs = pst2.executeQuery()) {

		            while (rs.next()) {
		            	//this will change
		            	list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6),rs.getBytes(8)));
		            }

		        } catch (SQLException ex) {

		            System.out.println(ex.getMessage());
		        }
			}
			for(int i = 0 ; i<list.size();i++) {
				try (PreparedStatement pst3 = con.prepareStatement("SELECT AVG(\"Score_Product\") FROM public.\"Reviews\" WHERE \"ID_Product\" = " + ProductDAO.getProductID(list.get(i)));
					 ResultSet rs3 = pst.executeQuery()) {
						if(rs3.next()) {
							list.get(i).setScore(rs3.getFloat(1));
						}
				} catch (SQLException ex) {
		
		            System.out.println(ex.getMessage());
		        }
				//FIRST QUERY OF CHARACTERISTICS
				try (PreparedStatement pst4 = con.prepareStatement("SELECT \"Characteristic\" FROM public.\"Products\" as A1 inner join \"IDs_Prod_Charac\" as B1 on A1.\"ID_Product\" = B1.\"ID_Product\" inner join \"Characteristics\" AS c1 on B1.\"ID_Characteristic\" = C1.\"ID_Characteristic\" WHERE A1.\"ID_Product\" =" + list.get(i).getId());
						ResultSet rs4 = pst4.executeQuery()) {
		
		            while (rs4.next()) {
		            	list.get(i).addFeature(rs4.getString(1));
		            }
		
		        } catch (SQLException ex) {
		
		            System.out.println(ex.getMessage());
		        }
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        
        }
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
