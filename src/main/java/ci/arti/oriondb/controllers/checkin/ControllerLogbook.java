package ci.arti.oriondb.controllers.checkin;

import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.repository.checkin.RepositoryLogbook;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import ci.arti.oriondb.services.ServicePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/logbook")
public class ControllerLogbook {

    @Autowired
    private RepositoryLogbook repositoryLogbook;

    @Autowired
    ServicePosition servicePosition;

    @GetMapping("/all")
    private List<ModelLogbook> getAllLogs(){return repositoryLogbook.findAll();}

    @GetMapping("/{id}")
    private ModelLogbook getLogById(@PathVariable Long id){
        return repositoryLogbook.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log","ID",id));
    }

    @GetMapping("/{s}/{e}")
    private List<ModelLogbook> getLogBetween(@PathVariable Date s,
                                             @PathVariable Date e){
        return repositoryLogbook.findModelLogbookByLogDateBetween(s,e);
    }

    @GetMapping("/{p}/{s}/{e}")
    private List<ModelLogbook> getPositionLogBetween(@PathVariable Long p,
                                                     @PathVariable Date s,
                                                     @PathVariable Date e){
        ModelPosition position = servicePosition.getASinglePosition(p);
        return repositoryLogbook.findModelLogbookByPositionAndLogDateBetween(position,s,e);
    }
}
