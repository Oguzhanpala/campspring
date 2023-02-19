package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandResponse> getAll();
	GetByIdBrandResponse getById(int id) throws Exception;

	
	void add(CreateBrandRequest createBrandRequest) throws Exception;
	void delete(int id) throws Exception;
	void update(UpdateBrandRequest updateBrandRequest) throws Exception;

}
