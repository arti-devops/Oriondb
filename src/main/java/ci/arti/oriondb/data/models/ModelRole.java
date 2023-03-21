package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter @Setter @NoArgsConstructor
public class ModelRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<ModelPosition> roles = new ArrayList<>();
}
