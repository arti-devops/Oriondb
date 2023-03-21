package ci.arti.oriondb.data.models;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ModelService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String shortName;
}
