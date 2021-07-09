package az.unique.amigossecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/student")
public class ManagementController {

    private static final List<Student> studentList = Arrays.asList(
            new Student(1,"abbas"),
            new Student(2,"resul"),
            new Student(3,"konul")
    );

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')") //Burada ayrica olaraq bu apiye muracietde yoxlama aparilir
    public List<Student> getAllStudents(){
        return studentList;
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student.toString());
    }

    @PreAuthorize("hasAuthority('student:write')")
    @PatchMapping("/{id}")
    public void updateStudent(Integer id, @RequestBody Student student){
        System.out.println(String.format("%s %s",id,student.toString()));
    }

    @PreAuthorize("hasAuthority('student:write')")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        System.out.println("deleted student");
    }


}
