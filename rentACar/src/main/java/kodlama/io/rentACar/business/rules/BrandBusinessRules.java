package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if (brandRepository.existsByname(name)) {
			throw new BusinessException("Brand name already exists");
		}
		
	}
	
	public void checkIfIdExists(int id) {
		if (!brandRepository.existsById(id)) {
			throw new BusinessException("Id not found");
			
		}
	}
}
