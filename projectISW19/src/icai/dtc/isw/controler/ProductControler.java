package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.ProductDAO;
import icai.dtc.isw.domain.Product;

public class ProductControler{

	public void getProduct(ArrayList<Product> lista) {
		ProductDAO.getProduct(lista);
	}	
}
