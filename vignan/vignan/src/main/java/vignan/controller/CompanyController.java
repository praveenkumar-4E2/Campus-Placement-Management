package vignan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vignan.model.Company;
import vignan.service.CompanyService;

@RestController
public class CompanyController {
	
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("companys")
	public Company saveCompany(@RequestBody  Company company) {
		return companyService.addCompany(company);
	}
	
	@GetMapping("companys")
	public List<Company> get(){
		return companyService.getall();
	}
	
	@DeleteMapping("companys/{name}")
	public String deleteCompany(@PathVariable int name) {
		return companyService.deleteCompany(name);
	}
}
