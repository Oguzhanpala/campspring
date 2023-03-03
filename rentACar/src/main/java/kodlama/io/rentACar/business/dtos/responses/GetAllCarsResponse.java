package kodlama.io.rentACar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

	private int id;
	
	private String plate;

	private double dailyPrice;

	private int modelYear;

	private int state; // 1-Available 2-Rented 3-Maintenance

	private int modelId;
	
	private String brandName;
	
	private String modelName;

}
