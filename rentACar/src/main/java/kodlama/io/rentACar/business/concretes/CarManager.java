package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.dtos.requests.CreateCarRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdCarsResponse;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();

		List<GetAllCarsResponse> brandResponses = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());

		return brandResponses;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		
		carBusinessRules.checkIfIdExists(createCarRequest.getModelId());
		carBusinessRules.checkIfPlateExists(createCarRequest.getPlate());
		
		Car car= modelMapperService.forRequest().map(createCarRequest, Car.class);
		carRepository.save(car);
		
	}

	@Override
	public GetByIdCarsResponse getById(int id) {
		
		carBusinessRules.checkIfIdExists(id);
		
		Car car = carRepository.findById(id).orElseThrow();
		GetByIdCarsResponse getByIdCarsResponse =modelMapperService.forResponse().map(car, GetByIdCarsResponse.class);
		return getByIdCarsResponse;
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		
		carBusinessRules.checkIfIdExists(updateCarRequest.getId());
		carBusinessRules.checkIfPlateExists(updateCarRequest.getPlate());
		
		Car car =modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carRepository.save(car);
		
	}

	@Override
	public void delete(int id) {
		
		carBusinessRules.checkIfIdExists(id);
		
		carRepository.deleteById(id);
		
	}

}
