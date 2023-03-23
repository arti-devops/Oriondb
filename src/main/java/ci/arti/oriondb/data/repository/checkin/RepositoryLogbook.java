package ci.arti.oriondb.data.repository.checkin;

import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import ci.arti.oriondb.data.models.employee.ModelPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepositoryLogbook extends JpaRepository<ModelLogbook, Long> {
    List<ModelLogbook> findModelLogbookByLogDateBetween(Date startDate, Date endDate);
    List<ModelLogbook> findModelLogbookByPositionAndLogDateBetween(ModelPosition position, Date startDate, Date endDate);
}
