package it.aminerva.validation.annotation;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.aminerva.validation.dto.ProductDTO;
import it.aminerva.validation.dto.RegistrationDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@SpringBootTest
class DateAfterValidationTest {

	@Autowired
	private Validator validator;

	@Test
	void dateAfter_success_EndingDateAfterStartingDate(){

		LocalDate startingDate = LocalDate.now();
		LocalDate endingDate = startingDate.plusDays(1);

		ProductDTO productDTO = ProductDTO.builder().startingDate(startingDate).endingDate(endingDate).build();

		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);

		assertThat(violations).isEmpty();

	}

	@Test
	void dateAfter_success_StartingDateEqualsEndingDate() {

		LocalDate startingDate = LocalDate.now();
		LocalDate endingDate = LocalDate.now();

		ProductDTO productDTO = ProductDTO.builder().startingDate(startingDate).endingDate(endingDate).build();

		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);

		assertThat(violations).isEmpty();

	}


	@Test
	void dateAfter_fail_StartingDateAfterEndingDate() {

		LocalDate startingDate = LocalDate.now();
		LocalDate endingDate = startingDate.minusDays(1);

		ProductDTO productDTO = ProductDTO.builder().startingDate(startingDate).endingDate(endingDate).build();

		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);

		assertThat(violations).isNotEmpty();

	}

	@Test
	void dateAfter_fail_StartingDateIsNull() {

		LocalDate endingDate =  LocalDate.now();

		ProductDTO productDTO = ProductDTO.builder().startingDate(null).endingDate(endingDate).build();

		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);

		assertThat(violations).isNotEmpty();

	}

	@Test
	void dateAfter_fail_EndingDateIsNull() {

		LocalDate startingDate =  LocalDate.now();

		ProductDTO productDTO = ProductDTO.builder().startingDate(startingDate).build();

		Set<ConstraintViolation<ProductDTO>> violations = validator.validate(productDTO);

		assertThat(violations).isNotEmpty();

	}

	@Test
	void dateAfter_fail_RegistrationDateEqualsNextPassowordResetDate() {

		LocalDate registrationDate =  LocalDate.now();
		LocalDate nextPassowordResetDate =  LocalDate.now();

		RegistrationDTO registrationDTO = RegistrationDTO.builder().registrationDate(registrationDate).nextPassowordResetDate(nextPassowordResetDate).build();

		Set<ConstraintViolation<RegistrationDTO>> violations = validator.validate(registrationDTO);

		assertThat(violations).isNotEmpty();
	}



}
