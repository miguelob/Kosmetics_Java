import java.util.HashMap;

public abstract class Producto{
    public final int idProduct;
    private String name;
    private double price;
    private String brand;
    private String description;
    private HashMap<String,Integer> survey;

    public Producto(int idProduct, String name, double price, String brand, String description){
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.initializeSurvey();
    }
    private void initializeSurvey(){
        this.survey.put("longwear",0);
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

    public abstract setHashMap();

}