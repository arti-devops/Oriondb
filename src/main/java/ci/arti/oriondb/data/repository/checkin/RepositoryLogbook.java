package ci.arti.oriondb.data.repository.checkin;

import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepositoryLogbook extends JpaRepository<ModelLogbook, Long> {
    List<ModelLogbook> findModelLogbookByLogDateBetween(Date startDate, Date endDate);
}
