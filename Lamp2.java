import java.awt.Color;

public class Lamp2 {
    private String material; 
    private Color color; 
    private int voltage;
    private double price;
    private final double originalPrice;
    private String state;

    public Lamp2(){
        this.material = "Metal";
        this.color = Color.WHITE;
        this.voltage = 60;
        this.price = 100;
        this.state = "Off";
        this.originalPrice = this.price;
    }

    public Lamp2(String material, Color color, int voltage, double price){
        this.material = material;
        this.color = color;
        this.voltage = voltage;
        this.price = price;
        this.originalPrice = price;
        this.state = "Off";
    }


    public Lamp2(String material, Color color, double price){
        this(material, color, 110, price);
    }

    public void setMaterial(String material){
        this.material = material;
    }
    // On -> On , Off -> Off
    public void setState (String state){
        if (!state.equals("Off") || !state.equals("On")){
            throw new IllegalArgumentException("State should be either On or Off");
        }
        this.state = state;
    }

    public void setState (){
        this.state = this.state.equals("On") ? "Off" : "On";
    }


    public void setPrice (double price){
        if (price <= 0 ){
            throw new IllegalArgumentException("Price should be strictly positive");
        }
        this.price = price;
    }

    public void revertToOriginalPrice (){
        this.price = this.originalPrice;
    }




}
