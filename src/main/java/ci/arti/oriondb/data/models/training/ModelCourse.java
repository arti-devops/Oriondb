package ci.arti.oriondb.data.models.training;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tb_course")
@Getter @Setter @NoArgsConstructor
public class ModelCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private Date startDate;
    private Date endDate;
    private String status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    @JsonManagedReference
    private ModelTraining training;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private ModelPosition position;
}
