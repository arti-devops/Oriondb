package ci.arti.oriondb.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "direction_id")
    @JsonManagedReference
    private ModelSubdivision direction;

    @OneToMany(mappedBy = "direction")
    @JsonBackReference
    private List<ModelSubdivision> subdivisions = new ArrayList<>();

    // Foreign relationships
    @OneToMany(mappedBy = "subdivision")
    @JsonBackReference
    private List<ModelService> services = new ArrayList<>();

    @OneToMany(mappedBy = "subdivision")
    @JsonBackReference
    private List<ModelPosition> positions = new ArrayList<>();
}
