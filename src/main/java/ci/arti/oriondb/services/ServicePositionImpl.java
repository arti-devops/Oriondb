package ci.arti.oriondb.services;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import ci.arti.oriondb.data.repository.employee.RepositoryPosition;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePositionImpl implements ServicePosition{

    @Autowired
    RepositoryPosition repositoryPosition;

    @Override
    public List<ModelPosition> getAllPositions() {
        return repositoryPosition.findAll();
    }

    @Override
    public ModelPosition getASinglePosition(Long positionId) {
        return repositoryPosition.findById(positionId).orElseThrow(() -> new ResourceNotFoundException("Position","ID",positionId));
    }
}
