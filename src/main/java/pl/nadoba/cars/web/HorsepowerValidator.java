package pl.nadoba.cars.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("horsepowerValidator")
public class HorsepowerValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        Integer horsepower = (Integer) o;

        if (horsepower < 1 ) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Moc musi byc wieksza od 0");
            message.setSummary("Moc musi byc wieksza od 0");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
