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

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.dtos.requests.CreateModelRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdModelsResponse;

@RestController
@RequestMapping("api/models")
public class ModelsController {

	private ModelService modelService;

	public ModelsController(ModelService modelService) {

		this.modelService = modelService;
	}

	@GetMapping
	public List<GetAllModelsResponse> getAll() {

		return modelService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdModelsResponse getById(@PathVariable int id) {

		return modelService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
 	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {

		modelService.add(createModelRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {

		modelService.update(updateModelRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		modelService.delete(id);
	}

}
