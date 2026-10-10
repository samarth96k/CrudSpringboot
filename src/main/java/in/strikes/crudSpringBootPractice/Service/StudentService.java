package in.strikes.crudSpringBootPractice.Service;

import in.strikes.crudSpringBootPractice.Repository.StudentRepository;
import in.strikes.crudSpringBootPractice.entity.Student;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student create(Student student) {
        Student studReq = studentRepository.save(student);
        return studReq;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()) return studentResp.get();
        return  null;
    }

    public List<Student> getAllStudent() {
        List<Student > studentData = studentRepository.findAll();
        return studentData;
    }
}
