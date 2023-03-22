package ci.arti.oriondb.data.repository.project;

import ci.arti.oriondb.data.models.project.ModelTaskRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTaskRole extends JpaRepository<ModelTaskRole, Long> {
}
