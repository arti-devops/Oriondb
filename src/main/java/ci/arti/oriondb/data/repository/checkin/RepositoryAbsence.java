package ci.arti.oriondb.data.repository.checkin;

import ci.arti.oriondb.data.models.checkin.ModelAbsence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAbsence extends JpaRepository<ModelAbsence, Long> {
}
