package ci.arti.oriondb.data.repository.evaluation;

import ci.arti.oriondb.data.models.evaluation.ModelEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEvaluation extends JpaRepository<ModelEvaluation, Long> {
}
