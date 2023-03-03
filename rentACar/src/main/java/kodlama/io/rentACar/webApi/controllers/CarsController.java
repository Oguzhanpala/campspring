package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

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

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.dtos.requests.CreateCarRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdCarsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
	
	private CarService carService;
	
	@GetMapping
	public List<GetAllCarsResponse> getAll(){
		 return carService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdCarsResponse getById(@PathVariable int id) {
		return carService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		carService.add(createCarRequest);
	}
	
	@PutMapping
	public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		carService.delete(id);
	}

}
