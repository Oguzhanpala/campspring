package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandsResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // Bu sınıf bir business nesnesidir..
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandResponses = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandResponses;
	}

	@Override
	public GetByIdBrandsResponse getById(int id) {

		brandBusinessRules.checkIfIdExists(id);

		Brand brand = brandRepository.findById(id).orElseThrow();

		GetByIdBrandsResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand,GetByIdBrandsResponse.class);
		return getByIdBrandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest){

		
		brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName()); //yeni kullanılan iş kuralı

		// model mapper yöntemi ile mapleme işlemi yapıldı.
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandRepository.save(brand);

	}

	@Override
	public void delete(int id) {

		brandBusinessRules.checkIfIdExists(id);

		brandRepository.deleteById(id);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest){

		brandBusinessRules.checkIfIdExists(updateBrandRequest.getId());
		
		brandBusinessRules.checkIfBrandNameExists(updateBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);
	}


}