package vignan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import vignan.model.Staff;
import vignan.service.StaffService;

@Controller
public class StaffController {

	private StaffService staffService;
	
	@PostMapping("staff/add")
	public Staff addStaff (@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}
	
	@GetMapping("staff/all")
	public List<Staff> findAllStaff()
	{
		return staffService.getAllStaff();
	}
	
	@DeleteMapping("staff/delete/{id}")
	public String deleteStaff(@PathVariable int id) {
		return staffService.deleteStaff(id);
	}
	
	
	
	
	
}
