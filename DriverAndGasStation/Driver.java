package DriverAndGasStation;

import Vehicle.Vehicle;
import Vinetki.Vinetki;
import Vinetki.Vinetki.ValidPeriod;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

    private String name;
    private ArrayList<Vehicle> vehicleArrayList;
    private double money;
    private GasStation gasStation;

    public Driver(String name, double money, GasStation gasStation) {
        if (name != null && !name.isEmpty()){
            this.name = name;
        }
        if (money > 0){
            this.money = money;
        }
        if (gasStation != null ){
        this.gasStation = gasStation;
        }
        vehicleArrayList = new ArrayList<>();
    }

    public void kupiVinetki(ValidPeriod period){
        for (int i = 0; i < vehicleArrayList.size(); i++) {
            buyVinetka(i,period);
        }

    }

    public void buyVinetka(int number,ValidPeriod period) {
        Vinetki newVinetka = gasStation.sellVinetka(vehicleArrayList.get(number).getType(),period);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleArrayList.add(vehicle);
    }

    public List<Vehicle> getVehicle() {
        return Collections.unmodifiableList(vehicleArrayList);
    }


}
