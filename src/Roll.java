public class Roll {
    //a single roll of bulk paper
    private int gsm;
    private int size;
    private double weight;
    private String name;

    public Roll(String name, int gsm,int size,double weight ){

        this.name=name;
        this.gsm=gsm;
        this.size=size;
        this.weight=weight;
    }
    public String getName(){
        return name;
    }
    public int getGsm(){
        return gsm;
    }
    public int getSize(){
        return size;
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
    public void display(){
        System.out.println(name + ", " + gsm + ", " + size + ", "+ weight);
    }

}
