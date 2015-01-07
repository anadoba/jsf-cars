package pl.nadoba.cars.web;

import com.example.jsfdemo.domain.Person;
import pl.nadoba.cars.model.Car;
import pl.nadoba.cars.service.StorageService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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


    public String addCar() {
        storageService.addCar(car);
        return "showCars";
    }

    public String deleteCar() {
        storageService.removeCar(cars.getRowData());
        return null;
    }


    public void uniqueLicensePlates(FacesContext context, UIComponent component,
                          Object value) {

        String licensePlates = (String) value;

        for (Car car : storageService.getAllCars()) {
            if (car.getLicensePlates().equalsIgnoreCase(licensePlates)) {
                FacesMessage message = new FacesMessage(
                        "Car with these license plates already exists in database");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }

    public void validatePin(ComponentSystemEvent event) {
        UIForm form = (UIForm) event.getComponent();
        UIInput productionDate = (UIInput) form.findComponent("calendar");
        UIInput pin = (UIInput) form.findComponent("pin");

        if (productionDate.getValue() != null && pin.getValue() != null)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(((Date) productionDate.getValue()));

            String lastDigitsOfYear = ((Integer) calendar.get(Calendar.YEAR))
                    .toString().substring(2,4);
            String firstDigitsOfPin = pin.getValue().toString().substring(0,2);

            if(!lastDigitsOfYear.equals(firstDigitsOfPin)){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(form.getClientId(), new FacesMessage(
                        "PIN doesn't match production date"));
                context.renderResponse();
            }
        }
    }
}
