package ci.arti.oriondb.controller;

import ci.arti.oriondb.data.models.ModelPosition;
import ci.arti.oriondb.data.repository.RepositoryPosition;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/position")
public class ControllerPosition {

    @Autowired
    RepositoryPosition repositoryPosition;

    @GetMapping("/all")
    public List<ModelPosition> getAllPositions(){return repositoryPosition.findAll();}

    @GetMapping("/{id}")
    public ModelPosition getPositionById(@PathVariable("id") Long id){
        return repositoryPosition.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position","ID",id));
    }
}
