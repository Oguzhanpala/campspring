package kodlama.io.rentACar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelsResponse {
	
	private int id;
	private String name;
	private String brandName;

}
