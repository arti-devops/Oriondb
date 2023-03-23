package ci.arti.oriondb.data.repository.training;

import ci.arti.oriondb.data.models.training.ModelCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCourse extends JpaRepository<ModelCourse, Long> {
}
