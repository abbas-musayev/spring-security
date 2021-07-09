package az.unique.amigossecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class Controller {


    private static final List<Student> list = Arrays.asList(
            new Student(1,"abbas"),
            new Student(2,"resul"),
            new Student(3,"konul")
    );

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return list.stream().
                filter(student -> id.equals(student.getId())).
                findFirst().
                orElseThrow(()-> new IllegalStateException(id.toString()));
    }

}
