package Vehicle;

import Vinetki.Vinetki;
import Vinetki.Vinetki.VehicleType;

public class Bus extends Vehicle{
    public Bus(String model, int year) {
        super(model, year, VehicleType.BUS);
    }
}
