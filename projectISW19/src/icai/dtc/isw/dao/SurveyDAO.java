package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import icai.dtc.isw.domain.Question;
import icai.dtc.isw.domain.Survey;

public class SurveyDAO {
	public static Survey getSurvey(int id) {
		Survey survey = new Survey();
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Producto\"");
			ResultSet rs = pst.executeQuery()) {
				survey.put(SurveyDAO.getQuestion(rs.getInt(1)), rs.getInt(2), rs.getInt(3), rs.getInt(4));
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return survey;
	}
	private static Question getQuestion(int id) {
		Question question = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Producto\"");
			ResultSet rs = pst.executeQuery()) {
			question = new Question(rs.getInt(1), rs.getString(2));
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return question;
	}
}
