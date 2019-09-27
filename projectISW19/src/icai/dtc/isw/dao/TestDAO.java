package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Test;

public class TestDAO {
	
	
	
	public static void getTests(ArrayList<Test> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM test");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Test(rs.getString(1),rs.getString(2)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Test> lista=new ArrayList<Test>();
		TestDAO.getTests(lista);
		
		
		 for (Test test : lista) {			
			System.out.println("He leído el id: "+test.getId()+" con nombre: "+test.getName());
		}
		
	
	}

}
