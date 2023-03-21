package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter @Setter @NoArgsConstructor
public class ModelRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;
}
