package ci.arti.oriondb.data.repository.checkin;

import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLogbook extends JpaRepository<ModelLogbook, Long> {
}
