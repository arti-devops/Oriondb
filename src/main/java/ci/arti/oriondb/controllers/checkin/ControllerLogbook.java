package ci.arti.oriondb.controllers.checkin;

import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import ci.arti.oriondb.data.repository.checkin.RepositoryLogbook;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logbook")
public class ControllerLogbook {

    @Autowired
    private RepositoryLogbook repositoryLogbook;

    @GetMapping("/all")
    private List<ModelLogbook> getAllLogs(){return repositoryLogbook.findAll();}

    @GetMapping("/{id}")
    private ModelLogbook getLogById(@PathVariable Long id){
        return repositoryLogbook.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log","ID",id));
    }
}
