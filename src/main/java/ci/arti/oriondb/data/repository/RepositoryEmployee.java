package ci.arti.oriondb.data.repository;

import ci.arti.oriondb.data.models.ModelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<ModelEmployee, Long> {
}
