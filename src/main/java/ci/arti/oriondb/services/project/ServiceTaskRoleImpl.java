package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.models.project.ModelTaskRole;
import ci.arti.oriondb.data.repository.project.RepositoryTaskRole;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTaskRoleImpl implements ServiceTaskRole{

    @Autowired
    RepositoryTaskRole repositoryTaskRole;

    @Override
    public List<ModelTaskRole> getAllTaskRoles() {
        return repositoryTaskRole.findAll();
    }

    @Override
    public ModelTaskRole getASingleTaskRole(Long taskRoleId) {
        return repositoryTaskRole.findById(taskRoleId).orElseThrow(
                () -> new ResourceNotFoundException("TaskRole","ID",taskRoleId)
        );
    }

    @Override
    public List<ModelTaskRole> getAllTaskRolesByPosition(ModelPosition position) {
        List<ModelTaskRole> taskRoles = repositoryTaskRole.findAllModelTaskRoleByPosition(position);
        for (ModelTaskRole taskRole: taskRoles) {
            taskRole.setPosition(null);
        };
        return taskRoles;
    }

    @Override
    public List<ModelTaskRole> getAllTaskRoleByTask(ModelTask task) {
        List<ModelTaskRole> taskRoles = repositoryTaskRole.findAllModelTaskRoleByTask(task);
        for(ModelTaskRole taskRole : taskRoles){
            taskRole.setTask(null);
        }
        return taskRoles;
    }
}
