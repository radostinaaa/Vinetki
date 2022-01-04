package Vehicle;

import Vinetki.Vinetki;
import Vinetki.Vinetki.VehicleType;

public class Truck extends Vehicle{
    public Truck(String model, int year) {
        super(model, year, VehicleType.TRUCK);
    }
}
