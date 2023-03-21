package ci.arti.oriondb.controllers.training;

import ci.arti.oriondb.data.models.training.ModelCourse;
import ci.arti.oriondb.data.repository.training.RepositoryCourse;
import ci.arti.oriondb.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class ControllerCourse {

    @Autowired
    private RepositoryCourse repositoryCourse;

    @GetMapping("/all")
    private List<ModelCourse> getAllCourses(){
        return repositoryCourse.findAll();
    }

    @GetMapping("/{id}")
    private ModelCourse getCourseById(@PathVariable long id){
        return repositoryCourse.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course","ID",id));
    }
}
