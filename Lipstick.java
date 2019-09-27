import java.util.*;

public calss Lipstick extends Producto{
    public final int idProduct;
    private String name;
    private double price;
    private String brand;
    private String description;
    private HashMap<Integer,Integer> survey;
    private ArrayList<String> features = new ArrayList<String>();
    private String productCategory;

    public Producto(int idProduct, String name, String productCategory, double price, String brand, String description){
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.productCategory = productCategory;

    }
    abstract void initializeSurvey();

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
    public abstract setHashMap();

}