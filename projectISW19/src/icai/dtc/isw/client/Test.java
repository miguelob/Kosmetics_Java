package icai.dtc.isw.client;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Client cli = new Client();
		ArrayList productos = cli.clientInteraction("/getProduct");
		for(int i=0;i<productos.size();i++) {
			System.out.println(productos.get(i));
		}
	}
}
