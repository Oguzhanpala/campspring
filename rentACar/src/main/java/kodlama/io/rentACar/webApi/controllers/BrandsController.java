package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdBrandResponse;

@RestController // Annatation -- Anatasyon
@RequestMapping("api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping()
	public List<GetAllBrandResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	GetByIdBrandResponse getById(@PathVariable int id) throws Exception {	
		return brandService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateBrandRequest createBrandRequest) throws Exception {
		brandService.add(createBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		brandService.delete(id);
		
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) throws Exception {
		brandService.update(updateBrandRequest);
	}

}
