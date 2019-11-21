package icai.dtc.isw.controler;

import icai.dtc.isw.dao.UserDAO;
import icai.dtc.isw.domain.User;

public class UserControler {
	public void getUser(int idUser) {
		UserDAO.getUser(idUser);
	}
	public void uploadUser(User user) {
		UserDAO.uploadUser(user);
	}
}
