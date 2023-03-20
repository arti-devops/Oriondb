package ci.arti.oriondb.Controller;

import ci.arti.oriondb.exception.ResourceNotFoundException;
import ci.arti.oriondb.model.ModelEmployee;
import ci.arti.oriondb.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class ControllerEmployee {

    @Autowired
    RepositoryEmployee repositoryEmployee;

    @GetMapping("/list")
    public List<ModelEmployee> getEmployeeList(){
        return repositoryEmployee.findAll();
    }

    @GetMapping("/{id}")
    public ModelEmployee getEmployeeById(@PathVariable("id") Long id){
        return repositoryEmployee.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","ID",id));
    }
}
