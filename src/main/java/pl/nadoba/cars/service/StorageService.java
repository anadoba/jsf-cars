package pl.nadoba.cars.service;

import pl.nadoba.cars.model.Car;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class StorageService {

    /*
    private Map<UUID, Car> cars = new HashMap<UUID, Car>();

    public void addCar(Car car) {
        cars.put(car.getUuid(), car);
    }

    public void removeCar(UUID uuid) {
        cars.remove(uuid);
    }

    public Car getCar(UUID uuid) {
        return cars.get(uuid);
    }

    public Map<UUID, Car> getAllCars() {
        return cars;
    }
    */

    private List<Car> cars = new ArrayList<Car>();

    public void addCar(Car _car) {
        Car car = new Car();

        car.setModel(_car.getModel());
        car.setHorsepower(_car.getHorsepower());
        car.setLicensePlates(_car.getLicensePlates());
        car.setProductionDate(_car.getProductionDate());

        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
