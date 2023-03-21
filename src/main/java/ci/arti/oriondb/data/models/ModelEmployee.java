package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter @Setter @NoArgsConstructor
public class ModelEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

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
}
