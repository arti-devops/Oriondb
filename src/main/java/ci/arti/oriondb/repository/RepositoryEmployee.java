package ci.arti.oriondb.repository;

import ci.arti.oriondb.model.ModelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<ModelEmployee, Long> {
}
