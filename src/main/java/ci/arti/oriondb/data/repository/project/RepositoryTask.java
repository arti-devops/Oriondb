package ci.arti.oriondb.data.repository.project;

import ci.arti.oriondb.data.models.project.ModelTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTask extends JpaRepository<ModelTask, Long> {
}
