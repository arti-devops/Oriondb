package ci.arti.oriondb.data.repository.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.models.project.ModelTaskRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTaskRole extends JpaRepository<ModelTaskRole, Long> {
    List<ModelTaskRole> findAllModelTaskRoleByPosition(ModelPosition position);
    List<ModelTaskRole> findAllModelTaskRoleByTask(ModelTask task);
}
