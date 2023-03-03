package kodlama.io.rentACar.business.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	@NotNull
	@NotBlank
	private String plate;
	
	@NotNull
	@NotBlank
	private double dailyPrice;
	
	@NotNull
	@NotBlank
	private int modelYear;
	
	@NotNull
	@NotBlank
	private int state; // 1-Available 2-Rented 3-Maintenance

	@NotNull
	private int modelId;

}
