package ci.arti.oriondb.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
@Getter @Setter @NoArgsConstructor
public class ModelService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivision_id", nullable = true)
    private ModelSubdivision subdivision;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ModelPosition> services = new ArrayList<>();
}
