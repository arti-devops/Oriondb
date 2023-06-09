package ci.arti.oriondb.data.models.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_role")
@Getter @Setter @NoArgsConstructor
public class ModelRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;

    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<ModelPosition> positions = new ArrayList<>();
}
