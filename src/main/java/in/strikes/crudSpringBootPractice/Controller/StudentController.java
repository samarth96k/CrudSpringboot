package in.strikes.crudSpringBootPractice.Controller;

import in.strikes.crudSpringBootPractice.Service.StudentService;
import in.strikes.crudSpringBootPractice.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentResp = studentService.getAllStudent();
        if(studentResp.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(studentResp);
    }
}
