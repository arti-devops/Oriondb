package ci.arti.oriondb.data.repository.tables;

import ci.arti.oriondb.data.models.ModelService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryService extends JpaRepository<ModelService, Long> {
}
