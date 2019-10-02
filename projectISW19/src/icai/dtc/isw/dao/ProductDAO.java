package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;

public class ProductDAO {
	
	
	
	public static void getProduct(ArrayList<Product> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Producto\"");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(7)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Product> lista=new ArrayList<Product>();
		ProductDAO.getProduct(lista);
		
		
		 for (Product producto : lista) {			
			System.out.println("He leido el id: "+producto.getId()+" con nombre: "+producto.getName()+" con precio: "+producto.getPrice()+" con marca: "+producto.getBrand()+" con Descripcion: "+producto.getDescription());
		}
		
	
	}

}
