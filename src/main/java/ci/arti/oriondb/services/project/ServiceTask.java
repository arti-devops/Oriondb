package ci.arti.oriondb.services.project;

import ci.arti.oriondb.data.models.project.ModelTask;

public interface ServiceTask {
    ModelTask getASingleTask(Long taskId);
}
