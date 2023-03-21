package ci.arti.oriondb.controllers.checkin;

import ci.arti.oriondb.data.models.checkin.ModelAbsence;
import ci.arti.oriondb.data.repository.checkin.RepositoryAbsence;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/absence")
public class ControllerAbsence {

    @Autowired
    private RepositoryAbsence repositoryAbsence;

    @GetMapping("/all")
    private List<ModelAbsence> getAllAbsences(){return repositoryAbsence.findAll();}

    @GetMapping("/{id}")
    private ModelAbsence getAbsenceById(@PathVariable Long id){
        return repositoryAbsence.findById(id).orElseThrow(() -> new ResourceNotFoundException("Absence","ID",id));
    }
}
