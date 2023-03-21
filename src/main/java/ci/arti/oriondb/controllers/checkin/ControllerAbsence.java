package ci.arti.oriondb.controllers.checkin;

import ci.arti.oriondb.data.models.checkin.ModelAbsence;
import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.repository.checkin.RepositoryAbsence;
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
@RequestMapping("/api/v1/absence")
public class ControllerAbsence {

    @Autowired
    private RepositoryAbsence repositoryAbsence;

    @Autowired
    private ServicePosition servicePosition;

    @GetMapping("/all")
    private List<ModelAbsence> getAllAbsences(){return repositoryAbsence.findAll();}

    @GetMapping("/{id}")
    private ModelAbsence getAbsenceById(@PathVariable Long id){
        return repositoryAbsence.findById(id).orElseThrow(() -> new ResourceNotFoundException("Absence","ID",id));
    }

    @GetMapping("/{s}/{e}")
    private List<ModelAbsence> getAllByAbsDateBetween(@PathVariable Date s,
                                                      @PathVariable Date e){
        return repositoryAbsence.findAllByAbsDateBetween(s,e);
    }

    @GetMapping("/{p}/{s}/{e}")
    private List<ModelAbsence> getAllByPositionAndAbsDateBetween(@PathVariable Long p,
                                                                 @PathVariable Date e,
                                                                 @PathVariable Date s){
        ModelPosition position = servicePosition.getASinglePosition(p);
        return repositoryAbsence.findAllByPositionAndAbsDateBetween(position, s, e);
    }
}
