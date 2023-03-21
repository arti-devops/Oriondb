package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_subdivision")
@Getter @Setter @NoArgsConstructor
public class ModelSubdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "subdivision_id")
    private Integer subdivisionId;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "direction_id")
    private ModelSubdivision direction;

    @OneToMany(mappedBy = "direction")
    private List<ModelSubdivision> subdivisions = new ArrayList<>();

    @OneToMany(mappedBy = "subdivision", cascade = CascadeType.ALL)
    private List<ModelService> services = new ArrayList<>();

    @OneToMany(mappedBy = "subdivision", cascade = CascadeType.ALL)
    private List<ModelPosition> subdivision = new ArrayList<>();
}
