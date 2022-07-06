package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Department;
import vignan.model.Staff;
import vignan.model.Student;
import vignan.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> getall()
	{
		return departmentRepository.findAll();
	}
	
	
	
	public Department getByDepartmentName(String branch) {
		return departmentRepository.findBydepartmentName(branch);
	}
	
	public String  deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);
		return "deleted";
	}
	
	public Department updateDepartmentStudent(String branch , Student student) {
		Department newDepartment=getByDepartmentName(branch);
		List<Student> newStudents=newDepartment.getStudent();
		newStudents.add(student);
		newDepartment.setStudent(newStudents);
		return departmentRepository.save(newDepartment);
	}
	
	public Department updateDepartmentStaff(String branch , Staff staff) {
		Department newDepartment=getByDepartmentName(branch);
		List<Staff> newStaff=newDepartment.getStaff();
		newStaff.add(staff);
		newDepartment.setStaff(newStaff);
		return departmentRepository.save(newDepartment);
	}
	
	
	
	
}

