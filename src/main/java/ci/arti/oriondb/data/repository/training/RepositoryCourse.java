package ci.arti.oriondb.data.repository.training;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.training.ModelCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryCourse extends JpaRepository<ModelCourse, Long> {
    List<ModelCourse> findAllByPosition(ModelPosition position);
}
