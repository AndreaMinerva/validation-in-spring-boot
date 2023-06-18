package it.aminerva.validation.annotation;

import java.time.LocalDate;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateAfterValidator implements ConstraintValidator<DateAfter, Object> {

	private String date;
	private String dateAfter;
	private boolean checkEquals;

	@Override
	public void initialize(DateAfter constraintAnnotation) {
		this.date = constraintAnnotation.date();
		this.dateAfter = constraintAnnotation.dateAfter();
		this.checkEquals = constraintAnnotation.checkEquals();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Object datePropertyValue = new BeanWrapperImpl(value).getPropertyValue(date);
		Object dateAfterPropertyValue = new BeanWrapperImpl(value).getPropertyValue(dateAfter);

		if (datePropertyValue != null && datePropertyValue instanceof LocalDate dateV && dateAfterPropertyValue != null
				&& dateAfterPropertyValue instanceof LocalDate dateAfterV) {
			return checkEquals ? dateAfterV.isAfter(dateV) || dateAfterV.isEqual(dateV) : dateAfterV.isAfter(dateV);
		}

		return false;
	}

}
