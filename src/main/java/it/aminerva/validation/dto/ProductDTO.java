package it.aminerva.validation.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import it.aminerva.validation.annotation.DateAfter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DateAfter(date = "startingDate", dateAfter = "endingDate")
public class ProductDTO {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startingDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endingDate;

}
