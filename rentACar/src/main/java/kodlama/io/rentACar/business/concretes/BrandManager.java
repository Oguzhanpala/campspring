package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service // Bu sınıf bir business nesnesidir..
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	
	@Autowired
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
		this.brandRepository = brandRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllBrandResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandResponse> brandResponses = brands.stream().map(brand->this.modelMapperService.forResponse()
				.map(brand,GetAllBrandResponse.class))
				.collect(Collectors.toList());
		
		return brandResponses;
	}

	@Override
	public GetByIdBrandResponse getById(int id) throws Exception {

		if (!isIdExist(id)) {
			throw new Exception("Geçersiz id");
		}

		Brand brand = brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return getByIdBrandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) throws Exception {
		
		if (isNameEmpty(createBrandRequest.getName())) {
			throw new Exception("Girilen isim boş olamaz tekrar deneyiniz!!");
		}
		if (isNameExist(createBrandRequest.getName())) {
			throw new Exception("Girilen isim zaten kayıtlıdır.");
		}
		
		//model mapper yöntemi ile mapleme işlemi yapıldı.
		Brand brand =this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandRepository.save(brand);

	}

	@Override
	public void delete(int id) throws Exception {

		if (!isIdExist(id)) {
			throw new Exception("Geçersiz id");
		}

		brandRepository.deleteById(id);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) throws Exception {

		if (!isIdExist(updateBrandRequest.getId())) {
			throw new Exception("Geçersiz id");
		}
		if (isNameEmpty(updateBrandRequest.getName())) {
			throw new Exception("Girilen isim boş olamaz tekrar deneyin!!!");
		}
		if (isNameExist(updateBrandRequest.getName())) {
			throw new Exception("Girilen isim zaten kayıtlıdır.");
		}
		
		Brand brand =this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);
	}

	
	
	
	private boolean isNameExist(String name) {
		for (Brand brand : brandRepository.findAll()) {
			if (brand.getName().equals(name)) {
				return true;
			}

		}
		return false;
	}

	private boolean isNameEmpty(String name) {
		if (name.isBlank()) {
			return true;
		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (Brand brand : brandRepository.findAll()) {
			if (brand.getId() == id) {
				return true;

			}

		}
		return false;
	}

}