package az.unique.amigossecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {


    private static final List<Student> list = Arrays.asList(
            new Student("abbas","123456"),
            new Student("resul","123456"),
            new Student("unknown","123456")
    );

    @GetMapping("/{username}")
    public Student getStudent(@PathVariable String username){
        return list.stream().
                filter(student -> student.getUsername().equals(username)).
                findFirst().
                orElseThrow(()-> new IllegalStateException(username));
    }

}
