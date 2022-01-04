package DriverAndGasStation;

import Vehicle.Vehicle;
import Vinetki.Vinetki;
import Vinetki.Vinetki.VehicleType;
import Vinetki.Vinetki.ValidPeriod;

import java.util.*;

public class GasStation {

    public static final int QUANTITY = 10000;
    private String GasStationName;
    private HashMap <VehicleType, HashMap<ValidPeriod, ArrayList<Vinetki>>> sortListVinetki; //tip,period,vinetka

    public GasStation(String GasStationName) {
        if (GasStationName!=null && ! GasStationName.isEmpty()) {
            this.GasStationName = GasStationName;
        }
        sortListVinetki = new HashMap<>();
    }

    public void createVinetki(){
        ArrayList <Vinetki> vinetkiArrayList = new ArrayList<>(QUANTITY);
        //TODO
        for (int i = 0; i < QUANTITY; i++) {
            vinetkiArrayList.add(new Vinetki(VehicleType.values()[new Random().nextInt(VehicleType.values().length)],
                    ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]));
        }
        for (Vinetki v : vinetkiArrayList){
            VehicleType type = v.getType();
            ValidPeriod p = v.getPeriod();
            if (!sortListVinetki.containsKey(type)){
                sortListVinetki.put(type,new HashMap<>());
            }
            if (!sortListVinetki.get(type).containsKey(p)){
                sortListVinetki.get(type).put(p,new ArrayList<>());
            }
            sortListVinetki.get(type).get(p).add(v);
        }
    }

    public Vinetki sellVinetka(VehicleType type, ValidPeriod period) {
        if(sortListVinetki.get(type).get(period).size()>0){
            Vinetki copy = sortListVinetki.get(type).get(period).get(0);
            sortListVinetki.get(type).get(period).remove(0);
            return copy;
        }
        return null;
    }

    public void printInfo(){
        for (Map.Entry<VehicleType,HashMap<ValidPeriod,ArrayList<Vinetki>>> entryType :sortListVinetki.entrySet()){
            System.out.println("+++++++++++++++++++++++++++++"+entryType.getKey()+"++++++++++++++++++++++++++++++++++++++++++++++++");
            for (Map.Entry<ValidPeriod,ArrayList<Vinetki>> entryPeriod : entryType.getValue().entrySet()){
                System.out.println("----"+entryPeriod.getKey()+"----");
                for (Vinetki vin:entryPeriod.getValue()) {
                    System.out.println(vin);
                }
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public Map<VehicleType, HashMap<ValidPeriod, ArrayList<Vinetki>>> getSortListVinetki() {
        return Collections.unmodifiableMap(sortListVinetki);
    }

}
