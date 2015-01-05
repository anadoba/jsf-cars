package pl.nadoba.cars.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

public class Car {

    private UUID uuid = UUID.randomUUID();
    private String model = "";
    private int horsepower = 0;
    private Date productionDate = new Date();
    private String licensePlates = "";
    private int ownersAmount = 0;

    public UUID getUuid() {
        return uuid;
    }

    @Size(min = 6, max = 40)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Min(1)
    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Past
    public Date getProductionDate() {
        return productionDate;
    }
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Pattern(regexp = "[A-Z]{2,3} [A-Z0-9]{4,5}")
    public String getLicensePlates() {
        return licensePlates;
    }
    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }


    public int getOwnersAmount() {
        return ownersAmount;
    }
    public void setOwnersAmount(int ownersAmount) {
        this.ownersAmount = ownersAmount;
    }
}
