package ci.arti.oriondb.data.repository.training;

import ci.arti.oriondb.data.models.training.ModelTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTraining extends JpaRepository<ModelTraining, Long> {
}
