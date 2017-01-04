package app.validator;

import app.annotation.ValidateColour;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ColourValidator implements ConstraintValidator<ValidateColour, String> {

    private String definedColour;

    @Override
    public void initialize(ValidateColour validateColour) {
        this.definedColour = validateColour.value();
    }

    @Override
    public boolean isValid(String inputColour, ConstraintValidatorContext constraintValidatorContext) {
        if ( inputColour == null ) {
            return true;
        }

        if(this.definedColour.equals(inputColour)){
            return true;
        }

        return false;
    }
}
