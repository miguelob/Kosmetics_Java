package icai.dtc.isw.controler;

import java.util.ArrayList;
import icai.dtc.isw.domain.User;
import icai.dtc.isw.dao.UserDAO;

public class UserController {
	public void getUser(ArrayList<User> lista) {
		UserDAO.getUser(lista);
	}
}
