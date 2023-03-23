package ci.arti.oriondb.data.models.project;

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
@Table(name = "tb_task")
@Getter @Setter @NoArgsConstructor
public class ModelTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column(length = 20, nullable = false, unique = true)
    private String code;
    @Column(length = 500, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String type;
    private Date startDate;
    private Date endDate;
    @Column(length = 20)
    private String status;
    private Double progress;
    private Long budget;
    @Column(length = 1000)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @JsonManagedReference
    private ModelTask project;

    @OneToMany(mappedBy = "project")
    @JsonBackReference
    private List<ModelTask> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "task")
    @JsonBackReference
    private List<ModelTaskRole> taskRoles = new ArrayList<>();

}
