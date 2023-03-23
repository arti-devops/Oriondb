package ci.arti.oriondb.data.models.checkin;

import ci.arti.oriondb.data.models.employee.ModelPosition;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "ms_logbook")
@Getter @Setter @NoArgsConstructor
public class ModelLogbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logbookId;

    @Column(nullable = false)
    private Date logDate;

    @Column(nullable = false)
    private Time checkinTime;

    @Column(nullable = false)
    private Time checkoutTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @JsonManagedReference
    private ModelPosition position;

}
