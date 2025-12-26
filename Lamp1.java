public class Lamp1 {
    private int isOn;
    private int brightness;
    private int height;
    private int width; 

    public Lamp1 (int brightness, int height, int width){
        this.brightness = brightness;
        this.height = height;
        this.width = width;
        this.isOn = 0;
    }

    public Lamp1 (int height, int width){
        this(255, height, width);
    }

    public int getIsOn (){
        return this.isOn;
    }
    
    public void setIsOn (int number){
        if (number != 0 || number != 1){
            throw new IllegalArgumentException("Number should be 0 or 1");
        }
        this.isOn = number;
    }

}
