package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.project.ModelTask;

import java.util.List;

public interface ServiceTask {
    ModelTask getASingleTask(Long taskId);
    List<ModelTask> getAllProjectTasks(ModelTask projectId);
}
