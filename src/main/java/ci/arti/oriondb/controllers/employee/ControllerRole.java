package ci.arti.oriondb.controllers.employee;

import ci.arti.oriondb.data.models.employee.ModelRole;
import ci.arti.oriondb.data.repository.employee.RepositoryRole;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class ControllerRole {

    @Autowired
    private RepositoryRole repositoryRole;

    @GetMapping("/all")
    private List<ModelRole> getAllRoles(){return repositoryRole.findAll();}

    @GetMapping("/{id}")
    private ModelRole getRoleById(@PathVariable Long id){
        return repositoryRole.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role","ID",id));
    }
}
