package kodlama.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {

	private CarRepository carRepository;

	public void checkIfPlateExists(String name) {
		if (carRepository.existsByPlate(name)) {
			throw new BusinessException("Plate already exists");
		}
	}
	
	public void checkIfIdExists(int id) {
		if (!carRepository.existsById(id)) {
			throw new BusinessException("Id not found");
		}
	}
}
