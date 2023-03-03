package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandsResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandsResponse getById(int id);

	
	void add(CreateBrandRequest createBrandRequest);
	void delete(int id);
	void update(UpdateBrandRequest updateBrandRequest);

}
