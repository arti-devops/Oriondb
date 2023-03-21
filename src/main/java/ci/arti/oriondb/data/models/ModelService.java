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
@Table(name = "tb_service")
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
    @JoinColumn(name = "subdivision_id")
    @JsonBackReference
    private ModelSubdivision subdivision;

    @OneToMany(mappedBy = "service")
    @JsonBackReference
    private List<ModelPosition> positions = new ArrayList<>();
}
