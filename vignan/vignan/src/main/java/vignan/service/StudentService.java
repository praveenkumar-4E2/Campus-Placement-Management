package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vignan.model.Department;
import vignan.model.Student;
import vignan.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository  studentRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	public Department saveStudent(String branch, Student student)
	{
		Student savedStudent= studentRepository.save(student);
		
		return departmentService.updateDepartment(branch, savedStudent);
	}
	
	public Student getByUserRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }
	
	public Student getByName(String firstName) {
        return studentRepository.findByName(firstName);
    }
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}

	
	public String deleteByRollNo(String rollNo)
	{
		 studentRepository.deleteByRollNo(rollNo);
		return "student "+rollNo + " deleted";

		
	}
	
	
	public Student update(Student student)
	{
		Student existingStudent=studentRepository.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		
		existingStudent.setRollNo(student.getRollNo());
		existingStudent.setSection(student.getSection());
		existingStudent.setMarks(student.getMarks());
		existingStudent.setMail(student.getMail());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setMobileNo(student.getMobileNo());
		existingStudent.setPassingYear(student.getPassingYear());
		existingStudent.setPlaced(student.isPlaced());
		return studentRepository.save(null);
	}
	
}
