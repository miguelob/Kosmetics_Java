package icai.dtc.isw.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import icai.dtc.isw.domain.Test;

public class TestDAO {
	
	
	
	public static void getTests() {
		 byte [] data = null;
	    try {
	    	BufferedImage bImage = ImageIO.read(new File("test.jpg"));
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", bos );
			data = bos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(data);
		Connection con=ConnectionDAO.getInstance().getConnection();
		try{
			PreparedStatement pst = con.prepareStatement("UPDATE \"Products\" SET \"Image\" = ? WHERE \"ID_Product\" = ?");
			pst.setBytes(1,data);
			pst.setInt(2, 3);

            int row = pst.executeUpdate();
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		
		TestDAO.getTests();
		
	
	}

}
