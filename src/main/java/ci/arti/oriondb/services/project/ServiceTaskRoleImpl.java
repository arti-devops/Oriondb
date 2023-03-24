package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
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
        return repositoryTaskRole.findAllModelTaskRoleByPosition(position);
    }
}
