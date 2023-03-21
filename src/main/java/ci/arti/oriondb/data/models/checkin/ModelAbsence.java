package ci.arti.oriondb.data.models.checkin;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ms_absence")
@Getter @Setter @NoArgsConstructor
public class ModelAbsence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long absenceId;

    private Date absDate;

    private String justified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private ModelPosition position;

}
