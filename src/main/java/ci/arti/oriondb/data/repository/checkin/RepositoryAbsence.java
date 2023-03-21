package ci.arti.oriondb.data.repository.checkin;

import ci.arti.oriondb.data.models.checkin.ModelAbsence;
import ci.arti.oriondb.data.models.employee.ModelPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepositoryAbsence extends JpaRepository<ModelAbsence, Long> {
    List<ModelAbsence> findAllByAbsDateBetween(Date s, Date e);
    List<ModelAbsence> findAllByPositionAndAbsDateBetween(ModelPosition p, Date s, Date e);
}
