package Vinetki;

public class Vinetki {

    public enum VehicleType{
        CAR(5,"BLUE"),TRUCK(7,"YELLOW"),BUS(9,"RED");

        private double price;
        private String color;

        VehicleType(double price, String color) {
            this.price = price;
            this.color = color;
        }
    }

    public enum ValidPeriod{
        DAY(1),MONTH(10),YEAR(10);

        private double coeff;

        ValidPeriod(double coeff) {
            this.coeff = coeff;
        }
    }

    private String dae;
    private VehicleType type;
    private ValidPeriod period;
    private double priceV;
    private boolean Sticky;
    private String color;

    public Vinetki(VehicleType type, ValidPeriod period) {
        this.type = type;
        this.period = period;
        this.priceV = calcPriceVinetka();
        Sticky = false;
        this.color = setColour();
    }


    public String setColour(){
        return type.color;
    }

    public int stickOnGlass(Vinetki v){
        if(!Sticky){
            Sticky = true;
            if(v.getClass().getSimpleName().equals("Car")){
                return 5;
            }
            if(v.getClass().getSimpleName().equals("Truck")){
                return 10;
            }
            if (v.getClass().getSimpleName().equals("Bus")){
                return 20;
            }
        }
      return 0;
    }

    public double calcPriceVinetka(){
        return type.price* period.coeff;
    }
    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

    public ValidPeriod getPeriod() {
        return period;
    }

    public double getPriceV() {
        return priceV;
    }
    @Override
    public String toString() {
        return "Vinetki{" +
                ", type=" + type +
                ", period=" + period +
                ", priceV=" + priceV +
                ", Sticky=" + Sticky +
                ", color='" + color + '\'' +
                '}';
    }
}
