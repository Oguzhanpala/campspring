package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.dtos.requests.CreateModelRequest;
import kodlama.io.rentACar.business.dtos.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.dtos.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.dtos.responses.GetByIdModelsResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelResponses = models.stream().map(model->this.modelMapperService.forResponse()
				.map(model,GetAllModelsResponse.class))
				.collect(Collectors.toList());
		
		return modelResponses;
	}

	@Override
	public GetByIdModelsResponse getById(int id) {
		
		modelBusinessRules.checkIfIdExists(id); //id kontrol
		
		Model model = modelRepository.findById(id).orElseThrow();
		
		GetByIdModelsResponse getByIdModelResponse = modelMapperService.forResponse().map(model, GetByIdModelsResponse.class);
		return getByIdModelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());//isim kontrol
		
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
		modelRepository.save(model);

	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		
		modelBusinessRules.checkIfIdExists(updateModelRequest.getId());//id kontrol
		modelBusinessRules.checkIfModelNameExists(updateModelRequest.getName());//isim kontrol
		
		Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
		modelRepository.save(model);

	}

	@Override
	public void delete(int id) {
		modelBusinessRules.checkIfIdExists(id);//id kontrol
		modelRepository.deleteById(id);

	}

}
