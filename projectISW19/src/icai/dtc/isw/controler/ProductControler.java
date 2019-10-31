package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.ProductDAO;
import icai.dtc.isw.domain.Product;

public class ProductControler{

	public void getProductBasicInfo(ArrayList<Product> lista) {
			ProductDAO.getProductBasicInfo(lista);
	}
	public void getProductFullInfo(Product product) {
			ProductDAO.getProductFullInfo(product);
	}	
}
