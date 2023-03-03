package kodlama.io.rentACar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	
	private int id;
	private String name;
	private int brandId;
	private String brandName;

}
