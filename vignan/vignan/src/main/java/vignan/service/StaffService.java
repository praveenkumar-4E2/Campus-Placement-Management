package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Staff;
import vignan.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	public Staff saveStaff(Staff staff)
	{
		return staffRepository.save(staff);
	}
	
	public List<Staff> getAllStaff()
	{
		return staffRepository.findAll();
	}
	
	
	public String deleteStaff(int id)
	{
		staffRepository.deleteById(id);
		return "staff deleted";
	}
}
