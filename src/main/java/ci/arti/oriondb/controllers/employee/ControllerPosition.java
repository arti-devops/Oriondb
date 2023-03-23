package ci.arti.oriondb.controllers.employee;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.repository.employee.RepositoryPosition;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import ci.arti.oriondb.services.ServicePosition;
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
    ServicePosition servicePosition;

    @GetMapping("/all")
    public List<ModelPosition> getAllPositions(){
        return servicePosition.getAllPositions();
    }

    @GetMapping("/all/active")
    public List<ModelPosition> getAllActivePositions(){
        return servicePosition.getAllActivePositions();
    }

    @GetMapping("/{id}")
    public ModelPosition getPositionById(@PathVariable("id") Long id){
        return servicePosition.getASinglePosition(id);
    }
}
