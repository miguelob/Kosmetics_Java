package icai.dtc.isw.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
    public final int idProduct;
    private String name;
    private double price;
    private String brand;
    private String description;
    private HashMap<Integer,Integer> survey = new HashMap<Integer,Integer>();
    private ArrayList<String> features = new ArrayList<String>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private String productCategory;

    public Product(int idProduct, String name, String productCategory, double price, 
        String brand, String description,HashMap<Integer,Integer> survey, ArrayList<String> features,
         ArrayList<Review> reviews ){

        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.productCategory = productCategory;
        this.survey = survey;
        this.features=features;
        this.reviews=reviews;
    }
        
    public Product(int idProduct, String productCategory, String name,  String brand, double price, String description){

            this.idProduct = idProduct;
            this.name = name;
            this.price = price;
            this.brand = brand;
            this.description = description;
            this.productCategory = productCategory;
    }


    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getBrand(){
        return brand;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return productCategory;
    }
    public void setFeatures(String feature){
        features.add(feature);
    }
    public Collection getFeatures(){
        return features;
    }
    public int getId() {
    	return idProduct;
    }
    @Override
    public String toString() {
    	return "He leido el id: "+this.getId()+" con nombre: "+this.getName()+" con precio: "+this.getPrice()+" con marca: "+this.getBrand()+" con Descripcion: "+this.getDescription();
    }

}