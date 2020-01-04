package icai.dtc.isw.domain;

public class FilteringSettings{
    
    public final String[] brands;
    public final int[] popularity; //Tiene que ser enteros entre 1 y 5
    public final float maxPrice;
    public final float minPrice;
    
    public FilteringSettings(String[] brands, int[] popularity, float maxPrice, float maxPrice){

        this.brands = brands;
        this.popularity=popularity;
        this.maxPrice=maxPrice;
        this.maxPrice=maxPrice;
    }

    public FilteringSettings(){ //Si no se quieren aplicar filtros

    //this.brands = ;
    //this.popularity=popularity;
    //this.maxPrice=maxPrice;
    //this.maxPrice=maxPrice;
    
    }
    
}