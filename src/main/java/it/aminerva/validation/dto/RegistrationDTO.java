package it.aminerva.validation.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import it.aminerva.validation.annotation.DateAfter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DateAfter(date = "registrationDate", dateAfter = "nextPassowordResetDate", checkEquals = false )
public class RegistrationDTO {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate registrationDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate nextPassowordResetDate;
}
