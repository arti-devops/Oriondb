package ci.arti.oriondb.services;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServicePosition {
    List<ModelPosition> getAllPositions();
    List<ModelPosition> getAllActivePositions();
    ModelPosition getASinglePosition(Long positionId);
}
