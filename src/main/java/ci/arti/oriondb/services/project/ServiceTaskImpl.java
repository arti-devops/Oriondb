package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.repository.project.RepositoryTask;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTaskImpl implements ServiceTask{

    @Autowired
    RepositoryTask repositoryTask;
    @Override
    public ModelTask getASingleTask(Long taskId) {
        return repositoryTask.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task","ID",taskId));
    }

    @Override
    public List<ModelTask> getAllProjectTasks(ModelTask project) {
        return repositoryTask.findAllModelTaskByProject(project);
    }
}
