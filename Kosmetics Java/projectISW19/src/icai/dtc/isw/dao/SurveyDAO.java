package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Question;
import icai.dtc.isw.domain.Survey;

public class SurveyDAO {
	public static Survey getSurvey(int id) {
		Survey survey = new Survey();
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"IDs_Surv_Quest\" WHERE \"ID_Survey\" = " + id);
			ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				//System.out.println("\nValor1: "+rs.getInt(2)+"\nValor2: "+rs.getInt(3)+"\nValor3: "+rs.getInt(4));
				survey.put(SurveyDAO.getQuestion(rs.getInt(2)), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return survey;
	}
	private static Question getQuestion(int id) {
		Question question = null;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//WE NEED QUERY FOR GET THE INFO WITH EACH ID
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM \"Questions\" WHERE \"ID_Question\" = " + id);
			ResultSet rs = pst.executeQuery()) {
			if(rs.next()) {
				question = new Question(rs.getInt(1), rs.getString(2));
			}
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		return question;
	}
	public static boolean uploadSurvey(Product product, HashMap<Integer,int[]> ans) {
		boolean status = false;
		final Connection con=ConnectionDAO.getInstance().getConnection();
		int idSurvey = ProductDAO.getSurveyID(product);
		Collection<Question> questions = product.getSurvey().getQuestions();
		int contador = 1;
		Iterator<Question> it = questions.iterator();
		while(it.hasNext()) {
			Question question = (Question) it.next();
			int[] yes = {1,0,0};
			int[] no = {0,0,1};
			int[] yesNo = {0,1,0};
			if(Arrays.equals(ans.get(contador), yes)) {
				try {
					final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_Yes\" = \"Number_Yes\" + 1 WHERE \"ID_Survey\" = '"+idSurvey+"' AND \"ID_Question\" = '"+question.getIdQuestion()+"'");
					pst.executeUpdate();
					status = true;
				}catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}else if(Arrays.equals(ans.get(contador), no)) {
				try {
					final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_No\" = \"Number_No\" + 1 WHERE \"ID_Survey\" = '"+idSurvey+"' AND \"ID_Question\" = '"+question.getIdQuestion()+"'");
					pst.executeUpdate();
					status = true;
				}catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}else if(Arrays.equals(ans.get(contador), yesNo)) {
				try {
					final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_No_answer\" = \"Number_No_answer\" + 1 WHERE \"ID_Survey\" = '"+idSurvey+"' AND \"ID_Question\" = '"+question.getIdQuestion()+"'");
					pst.executeUpdate();
					status = true;
				}catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			contador++;
		}
		return status;
	}
}
