package ci.arti.oriondb.controllers.project;

import ci.arti.oriondb.data.models.project.ModelTaskRole;
import ci.arti.oriondb.data.repository.project.RepositoryTaskRole;
import ci.arti.oriondb.exception.ResourceNotFoundException;
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
    private RepositoryTaskRole repositoryTaskRole;

    @GetMapping("/all")
    private List<ModelTaskRole> getAllTaskRoles(){
        return repositoryTaskRole.findAll();
    }

    @GetMapping("/{id}")
    private ModelTaskRole getTaskRoleById(@PathVariable long id){
        return repositoryTaskRole.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskRole","ID",id));
    }
}
