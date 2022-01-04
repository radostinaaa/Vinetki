package Vehicle;

import Vinetki.Vinetki;
import Vinetki.Vinetki.VehicleType;
import Vinetki.Vinetki.ValidPeriod;


public abstract class Vehicle {

    private String model;
    private Vinetki vinetka;
    private int year;
    protected VehicleType type;

    public Vehicle(String model, int year, VehicleType type) {
        if(model != null && model.isEmpty()){
        this.model = model;
        }
        if (year > 1989) {
            this.year = year;
        }
        this.type = type;
    }

    public void insertVinetka (Vinetki newVinetka){
        newVinetka.stickOnGlass(newVinetka);
        this.vinetka = newVinetka;
    }

    public VehicleType getType() {
        return type;
    }

    public Vinetki getVinetka() {
        return vinetka;
    }
}
