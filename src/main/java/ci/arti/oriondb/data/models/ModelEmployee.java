package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_employee")
@Getter @Setter @NoArgsConstructor
public class ModelEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String contact;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ModelPosition> roles = new ArrayList<>();
}
