package ci.arti.oriondb.data.repository.employee;

import ci.arti.oriondb.data.models.employee.ModelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<ModelEmployee, Long> {
}
