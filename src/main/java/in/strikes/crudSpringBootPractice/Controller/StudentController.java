package in.strikes.crudSpringBootPractice.Controller;

import in.strikes.crudSpringBootPractice.Service.StudentService;
import in.strikes.crudSpringBootPractice.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public String createStatement(@RequestBody Student student){
        Student createdStudent = studentService.create(student);
        System.out.println("Inside contorller");
        return "Student Created";
    }


}
