package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

	private ModelRepository modelRepository;
	
	public void checkIfModelNameExists(String name) {
		if (modelRepository.existsByname(name)) {
			throw new BusinessException("Model name already exists");
		}
		
	}
	
	public void checkIfIdExists(int id) {
		if (!modelRepository.existsById(id)) {
			throw new BusinessException("Id not found");
			
		}
	}
	

}
