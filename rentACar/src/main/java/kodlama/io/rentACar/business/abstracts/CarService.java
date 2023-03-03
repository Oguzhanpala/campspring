package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.dtos.requests.CreateCarRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdCarsResponse;

public interface CarService {
	
	List<GetAllCarsResponse> getAll();
	GetByIdCarsResponse getById(int id);

	void update(UpdateCarRequest updateCarRequest);
	void add(CreateCarRequest createCarRequest);
	void delete(int id);
	
}
