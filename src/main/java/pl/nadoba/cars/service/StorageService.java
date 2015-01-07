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

    public void addCar(Car car) {
        Car carToAdd = new Car();

        carToAdd.setModel(car.getModel());
        carToAdd.setHorsepower(car.getHorsepower());
        carToAdd.setLicensePlates(car.getLicensePlates());
        carToAdd.setProductionDate(car.getProductionDate());
        carToAdd.setOwnersAmount(car.getOwnersAmount());
        carToAdd.setPin(car.getPin());

        cars.add(carToAdd);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
