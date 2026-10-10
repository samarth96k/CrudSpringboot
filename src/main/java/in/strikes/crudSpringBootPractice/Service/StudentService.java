package in.strikes.crudSpringBootPractice.Service;

import in.strikes.crudSpringBootPractice.Repository.StudentRepository;
import in.strikes.crudSpringBootPractice.entity.Student;
import org.springframework.stereotype.Service;

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
}
