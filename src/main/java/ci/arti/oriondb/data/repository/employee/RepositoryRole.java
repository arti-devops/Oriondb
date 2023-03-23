package ci.arti.oriondb.data.repository.employee;

import ci.arti.oriondb.data.models.employee.ModelRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public interface RepositoryRole extends JpaRepository<ModelRole, Long> {
}
