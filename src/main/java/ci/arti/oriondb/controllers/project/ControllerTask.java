package ci.arti.oriondb.controllers.project;

import ci.arti.oriondb.data.models.project.ModelTask;
import ci.arti.oriondb.data.repository.project.RepositoryTask;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class ControllerTask {

    @Autowired
    private RepositoryTask repositoryTask;

    @GetMapping("/all")
    private List<ModelTask> getAllTasks(){ return repositoryTask.findAll();}

    @GetMapping("/{id}")
    private ModelTask getTaskById(@PathVariable Long id){
        return repositoryTask.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","ID",id));
    }
}
