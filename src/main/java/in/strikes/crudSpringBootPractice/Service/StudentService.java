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
        student.setDeleted(false);
        Student studReq = studentRepository.save(student);
        return studReq;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()) return studentResp.get();
        return  null;
    }

    public List<Student> getAllStudent() {
        List<Student > studentData = studentRepository.findByDeletedIsFalse();
        return studentData;
    }

    public Boolean deleteStudent(Long id){
        Boolean isStuden = studentRepository.existsById(id);
        if(!isStuden) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteSoftly(Long id){
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) return false;
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
