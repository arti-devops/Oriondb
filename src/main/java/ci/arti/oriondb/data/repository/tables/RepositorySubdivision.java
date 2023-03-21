package ci.arti.oriondb.data.repository.tables;

import ci.arti.oriondb.data.models.ModelSubdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySubdivision extends JpaRepository<ModelSubdivision, Long> {
}
