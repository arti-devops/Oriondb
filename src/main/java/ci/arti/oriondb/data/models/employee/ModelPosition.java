package ci.arti.oriondb.data.models.employee;

import ci.arti.oriondb.data.models.employee.ModelEmployee;
import ci.arti.oriondb.data.models.employee.ModelRole;
import ci.arti.oriondb.data.models.employee.ModelService;
import ci.arti.oriondb.data.models.employee.ModelSubdivision;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ms_position")
@Getter @Setter @NoArgsConstructor
public class ModelPosition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "position_date")
    private Date positionDate;

    @Column(nullable = true)
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private ModelEmployee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @JsonManagedReference
    private ModelRole role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    @JsonManagedReference
    private ModelService service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subdivision_id")
    @JsonManagedReference
    private ModelSubdivision subdivision;


}