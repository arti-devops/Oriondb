package ci.arti.oriondb.controllers.training;

import ci.arti.oriondb.data.models.training.ModelTraining;
import ci.arti.oriondb.data.repository.training.RepositoryTraining;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/training")
public class ControllerTraining {

    @Autowired
    private RepositoryTraining repositoryTraining;

    @GetMapping("/all")
    private List<ModelTraining> getAllTrainings(){
        return repositoryTraining.findAll();
    }

    @GetMapping("/{id}")
    private ModelTraining getTrainingById(@PathVariable long id){
        return repositoryTraining.findById(id).orElseThrow(() -> new ResourceNotFoundException("Training","ID",id));
    }
}
