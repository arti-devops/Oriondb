package ci.arti.oriondb.data.repository.employee;

import ci.arti.oriondb.data.models.employee.ModelSubdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySubdivision extends JpaRepository<ModelSubdivision, Long> {
}
