package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.dtos.requests.CreateModelRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdModelsResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	GetByIdModelsResponse getById(int id);
	
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
	

}
