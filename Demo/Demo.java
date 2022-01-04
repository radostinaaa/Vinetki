package Demo;

import DriverAndGasStation.Driver;
import DriverAndGasStation.GasStation;
import Vehicle.Vehicle;
import Vehicle.Bus;
import Vehicle.Car;
import Vehicle.Truck;
import Vinetki.Vinetki;
import Vinetki.Vinetki.ValidPeriod;

import java.util.ArrayList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation("omv");
        gasStation.printInfo();

        String[] names = {"Peturch", "Dragomir", "Kristian", "Tsetsi", "Pedro", "Marchela", "Maq", "Carlo"};
        double[] money = {7500, 5100, 5000, 5900, 7300, 5600, 7900};

        ArrayList<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            drivers.add(new Driver(names[new Random().nextInt(names.length)], money[new Random().nextInt(money.length)], gasStation));
        }


        ArrayList<Vehicle> avtomobili = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            switch (new Random().nextInt(3)) {
                case 0:
                    avtomobili.add(new Car("Mazda",2003));
                    break;
                case 1:
                    avtomobili.add(new Bus("Scoda", 2006));
                    break;
                case 2:
                    avtomobili.add(new Truck("Scania", 2011));
                    break;
            }
        }
        for (int i = 0; i < drivers.size(); i++) {
            int broiAvt = 10;
            while (broiAvt > 0) {
                int idx = new Random().nextInt(avtomobili.size());
                drivers.get(i).addVehicle(avtomobili.get(idx));
                avtomobili.remove(idx);
                broiAvt--;
            }
        }

        for (int i = 0; i < drivers.size(); i++) {
            if (i % 3 == 0) {
                int buyVinetki = 5;
                while (buyVinetki > 0) {
                    int idx = new Random().nextInt(drivers.get(i).getVehicle().size());
                    if (drivers.get(i).getVehicle().get(idx).getVinetka() == null) {
                        drivers.get(i).buyVinetka(idx, ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]);
                        buyVinetki--;
                    }
                }
            } else {
                drivers.get(i).kupiVinetki(ValidPeriod.values()[new Random().nextInt(ValidPeriod.values().length)]);
            }
        }

    }
}
