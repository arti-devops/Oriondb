package ci.arti.oriondb.data.models.training;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_training")
@Getter @Setter @NoArgsConstructor
public class ModelTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;
    private String name;
    private String school;
    private Long duration;      // IN DAYS
    private String location;

    @OneToMany(mappedBy = "training")
    @JsonBackReference
    private List<ModelCourse> courses = new ArrayList<>();
}
