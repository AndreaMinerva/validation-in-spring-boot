package it.aminerva.validation.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = DateAfterValidator.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface DateAfter {

	String message() default "Field 'date' must be termporal after field 'dateAfter'";

	 String date();

	 String dateAfter();

	 boolean checkEquals() default true;

	 Class<?>[] groups() default {};

	 Class<? extends Payload>[] payload() default {};

	 @Retention(RUNTIME)
	 @Target(TYPE)
	 @interface List{
		 DateAfter[] value();
	 }

}
