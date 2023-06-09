package ci.arti.oriondb.data.models.employee;

import ci.arti.oriondb.data.models.checkin.ModelAbsence;
import ci.arti.oriondb.data.models.checkin.ModelLogbook;
import ci.arti.oriondb.data.models.evaluation.ModelEvaluation;
import ci.arti.oriondb.data.models.project.ModelTaskRole;
import ci.arti.oriondb.data.models.training.ModelCourse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private String status;

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

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<ModelLogbook> logs = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<ModelAbsence> absences = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<ModelCourse> courses = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<ModelEvaluation> evaluations = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<ModelTaskRole> taskRoles = new ArrayList<>();
}
