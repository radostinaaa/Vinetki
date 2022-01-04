package Vehicle;

import Vinetki.Vinetki.VehicleType;

public class Car extends Vehicle{

    public Car(String model, int year) {
        super(model, year, VehicleType.CAR);
    }
}
