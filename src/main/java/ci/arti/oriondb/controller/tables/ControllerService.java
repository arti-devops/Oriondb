package ci.arti.oriondb.controller.tables;

import ci.arti.oriondb.data.models.ModelService;
import ci.arti.oriondb.data.repository.tables.RepositoryService;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
public class ControllerService {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/all")
    private List<ModelService> getAllServices(){return repositoryService.findAll();}

    @GetMapping("/{id}")
    private ModelService getServiceById(@PathVariable Long id){
        return repositoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Service","ID",id));
    }
}
