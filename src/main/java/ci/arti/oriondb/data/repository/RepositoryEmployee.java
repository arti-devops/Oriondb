package ci.arti.oriondb.data.repository;

import ci.arti.oriondb.data.model.ModelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<ModelEmployee, Long> {
}
