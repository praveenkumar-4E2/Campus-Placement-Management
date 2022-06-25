package vignan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vignan.model.Student;
import vignan.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("student/add")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	
	@GetMapping("student/name:{firstName}")
	public Student findByUserName(@PathVariable String firstName) {
        return studentService.getByName(firstName);
    }
	
	@GetMapping("student/rollNo:{rollNo}")
	public Student findbyRoll(@PathVariable String rollNo)
	{
		return studentService.getByUserRollNo(rollNo);
	}
	
	@GetMapping("student/all")
	public List<Student> findAll()
	{
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("student/rollno/{rollNo}")
	public String deleteStudent(@PathVariable String rollNo)
	{
		return studentService.deleteByRollNo(rollNo);
		
	}
	
	@PutMapping("student/update")
	public Student updateStudent(@PathVariable Student student)
	{
		return studentService.update(student);
	}
	
	

}
