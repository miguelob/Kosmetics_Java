package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.UserDAO;
import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.User;

public class UserControler {
	public void getUser(int idUser) {
		UserDAO.getUser(idUser);
	}
	public boolean uploadUser(User user) {
		return UserDAO.uploadUser(user);
	}
	public User login(String email, String password) {
		return UserDAO.login(email,password);
	}
	public boolean setFavorite(Product product, User user, boolean fav) {
		return UserDAO.setFavorite(product,user,fav);
	}
	public boolean getFavoriteStatus(Product product, User user) {
		return UserDAO.getFavoriteStatus(product, user);
	}
	public void getFavorites(User user, ArrayList<Product> list) {
		UserDAO.getFavorites(user, list);
	}
}
