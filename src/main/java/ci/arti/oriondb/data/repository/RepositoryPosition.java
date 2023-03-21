package ci.arti.oriondb.data.repository;

import ci.arti.oriondb.data.models.ModelPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPosition extends JpaRepository<ModelPosition, Long> {
}
