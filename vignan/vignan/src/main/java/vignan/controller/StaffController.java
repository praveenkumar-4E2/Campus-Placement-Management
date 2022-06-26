package vignan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vignan.model.Staff;
import vignan.service.StaffService;

@RestController
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	@PostMapping("staff")
	public Staff addStaff (@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}
	
	@GetMapping("staff")
	public List<Staff> findAllStaff()
	{
		return staffService.getAllStaff();
	}
	
	@DeleteMapping("staff/{id}")
	public String deleteStaff(@PathVariable int id) {
		return staffService.deleteStaff(id);
	}
	
	
	
	
	
}
