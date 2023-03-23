package ci.arti.oriondb.controllers.employee;

import ci.arti.oriondb.data.models.employee.ModelSubdivision;
import ci.arti.oriondb.data.repository.employee.RepositorySubdivision;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subdivision")
public class ControllerSubdivision {

    @Autowired
    private RepositorySubdivision repositorySubdivision;

    @GetMapping("/all")
    private List<ModelSubdivision> getAllSubdivisions(){
        return repositorySubdivision.findAll();
    }

    @GetMapping("/{id}")
    private ModelSubdivision getSubdivisionById(@PathVariable Long id){
        return repositorySubdivision.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subdivision","ID",id));
    }
}
