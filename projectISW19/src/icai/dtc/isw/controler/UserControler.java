package icai.dtc.isw.controler;

import icai.dtc.isw.dao.UserDAO;

public class UserControler {
	public void getUser(String idUser) {
		UserDAO.getUser(idUser);
	}
}
