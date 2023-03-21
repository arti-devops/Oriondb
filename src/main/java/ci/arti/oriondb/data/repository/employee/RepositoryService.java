package ci.arti.oriondb.data.repository.employee;

import ci.arti.oriondb.data.models.employee.ModelService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryService extends JpaRepository<ModelService, Long> {
}
