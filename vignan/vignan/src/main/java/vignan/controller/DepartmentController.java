package vignan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vignan.model.Department;
import vignan.model.Staff;
import vignan.model.Student;
import vignan.repository.DepartmentRepository;
import vignan.service.DepartmentService;




@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("department")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
		
	}
	
	@GetMapping("department")
	public List<Department> get(){
		return departmentService.getall();
	}
	
	@GetMapping("department/{branch}")
	public Department getDepartment(@PathVariable String branch) {
		return departmentService.getByDepartmentName(branch);
	}

	@DeleteMapping("department/{branch}")
	public String deleteDepartment(@PathVariable Integer branch) {
		return departmentService.deleteDepartment(branch);
		
	}
	
	@PutMapping("department/{branch}")
	public Department updateDepartment(@PathVariable String branch,@RequestBody Student student) {
		return departmentService.updateDepartment(branch, student);
	}
	
}
