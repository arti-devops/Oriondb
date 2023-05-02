package ci.arti.oriondb.data.repository.project;

import ci.arti.oriondb.data.models.project.ModelTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTask extends JpaRepository<ModelTask, Long> {
    List<ModelTask> findAllModelTaskByProject(ModelTask project);
}
