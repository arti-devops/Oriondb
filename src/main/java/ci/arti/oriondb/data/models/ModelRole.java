package ci.arti.oriondb.data.models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class ModelRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;
}
