package ci.arti.oriondb.data.repository.employee;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryPosition extends JpaRepository<ModelPosition, Long> {
    List<ModelPosition> findAllModelPositionByStatus(String status);
}
