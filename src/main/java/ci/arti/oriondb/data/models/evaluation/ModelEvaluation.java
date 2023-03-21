package ci.arti.oriondb.data.models.evaluation;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ms_evaluation")
@Getter @Setter @NoArgsConstructor
public class ModelEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Long evaluationId;
    private String subtitle;
    private Date evalDate;
    private String status;
    @Column(length = 1000)
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private ModelPosition position;
}
