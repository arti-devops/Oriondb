package ci.arti.oriondb.controllers.evaluation;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.evaluation.ModelEvaluation;
import ci.arti.oriondb.data.repository.evaluation.RepositoryEvaluation;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import ci.arti.oriondb.services.ServicePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluation")
public class ControllerEvaluation {

    @Autowired
    private RepositoryEvaluation repositoryEvaluation;

    @Autowired
    private ServicePosition servicePosition;

    @GetMapping("/all")
    private List<ModelEvaluation> getAllEvaluations(){return repositoryEvaluation.findAll();}

    @GetMapping("/{id}")
    private ModelEvaluation getEvaluationById(@PathVariable Long id){
        return repositoryEvaluation.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation","ID",id));
    }

    @GetMapping("/position/{p}")
    private List<ModelEvaluation> getEvaluationByPosition(@PathVariable Long p){
        ModelPosition position = servicePosition.getASinglePosition(p);
        List<ModelEvaluation> evaluations = repositoryEvaluation.findAllByPosition(position);
        for (ModelEvaluation e: evaluations) {
            e.setPosition(null);
        }
        return evaluations;
    }
}