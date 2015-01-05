package pl.nadoba.cars.web;

import pl.nadoba.cars.model.Car;
import pl.nadoba.cars.service.StorageService;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named("carBean")
public class CarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    StorageService storageService;
    private Car car = new Car();
    private ListDataModel<Car> cars = new ListDataModel<Car>();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ListDataModel<Car> getAllCars() {
        cars.setWrappedData(storageService.getAllCars());
        return cars;
    }

    public void setAllCars(ListDataModel<Car> cars) {
        this.cars = cars;
    }

    // Actions
    public String addCar() {
        storageService.addCar(car);
        return "showCars";
    }

    public String deleteCar() {
        storageService.removeCar(cars.getRowData());
        return null;
    }

}
