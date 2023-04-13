package ci.arti.oriondb.data.repository.evaluation;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.evaluation.ModelEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryEvaluation extends JpaRepository<ModelEvaluation, Long> {
    List<ModelEvaluation> findAllByPosition(ModelPosition p);
}
