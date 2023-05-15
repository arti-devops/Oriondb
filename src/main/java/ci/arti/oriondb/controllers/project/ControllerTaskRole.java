package ci.arti.oriondb.controllers.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.models.project.ModelTaskRole;
import ci.arti.oriondb.services.ServicePosition;
import ci.arti.oriondb.services.project.ServiceTask;
import ci.arti.oriondb.services.project.ServiceTaskRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taskrole")
public class ControllerTaskRole {

    @Autowired
    private ServiceTask serviceTask;
    @Autowired
    private ServiceTaskRole serviceTaskRole;
    @Autowired
    private ServicePosition servicePosition;

    @GetMapping("/all")
    private List<ModelTaskRole> getAllTaskRoles(){
        return serviceTaskRole.getAllTaskRoles();
    }

    @GetMapping("/{taskRoleId}")
    private ModelTaskRole getTaskRoleById(@PathVariable long taskRoleId){
        return serviceTaskRole.getASingleTaskRole(taskRoleId);
    }

    @GetMapping("/position/{positionId}")
    private List<ModelTaskRole> getAllTaskRolesByPosition(@PathVariable Long positionId){
        ModelPosition position = servicePosition.getASinglePosition(positionId);
        return serviceTaskRole.getAllTaskRolesByPosition(position);
    }

    @GetMapping("task/{taskId}")
    private List<ModelTaskRole> getAllTaskRolesByTask(@PathVariable Long taskId){
        ModelTask task = serviceTask.getASingleTask(taskId);
        return serviceTaskRole.getAllTaskRoleByTask(task);
    }
}
