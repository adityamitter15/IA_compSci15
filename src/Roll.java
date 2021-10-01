public class Roll {
    //a single roll of bulk paper
    private int gsm;
    private int width;
    private int brightness;
    private double weight;
    private String name;

    public Roll(String name, int gsm, int width, int brightness, double weight ){

        this.name=name;
        this.gsm=gsm;
        this.width=width;
        this.brightness=brightness;
        this.weight=weight;
    }
    public String getName(){
        return name;
    }
    public int getGsm(){
        return gsm;
    }
    public int getWidth(){
        return width;
    }
    public int getBrightness(){
        return brightness;
    }
    public double getWeight(){
        return weight;
    }
    //core
    //diameter
    //burst factor
    //brightness
    //tensibility
    //wet strength
    public String toString(){
        return name + ", " + gsm + ", " + width + ", " + brightness + ", "+ weight;
    }

    public void display(){
        System.out.println(toString());
    }

}
