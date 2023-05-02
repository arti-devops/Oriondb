package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.models.project.ModelTaskRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceTaskRole {
    List<ModelTaskRole> getAllTaskRoles();
    ModelTaskRole getASingleTaskRole(Long taskRoleId);
    List<ModelTaskRole> getAllTaskRolesByPosition(ModelPosition position);
    List<ModelTaskRole> getAllTaskRoleByTask(ModelTask task);
}
