package kodlama.io.rentACar.business.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 20)
	private String name;
	
	@NotNull
	private int brandId;

}
