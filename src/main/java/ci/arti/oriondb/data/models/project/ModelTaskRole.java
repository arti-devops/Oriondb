package ci.arti.oriondb.data.models.project;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_taskrole")
@Getter @Setter @NoArgsConstructor
public class ModelTaskRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskroleId;

    @Column(nullable = false)
    private String role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private ModelTask task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private ModelPosition position;
}
