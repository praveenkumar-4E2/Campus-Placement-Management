package vignan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int staffId;
	private String name;
	private String role;
	private String mail;
	private String mobileNo;
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "department_id",referencedColumnName = "departmentName")
	private Department department;
	
	@OneToMany(mappedBy = "staff")
	private List<Student> student;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int staffId, String name, String role, String mail, String mobileNo, String address,
			Department department, List<Student> student) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.role = role;
		this.mail = mail;
		this.mobileNo = mobileNo;
		this.address = address;
		this.department = department;
		this.student = student;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", name=" + name + ", role=" + role + ", mail=" + mail + ", mobileNo="
				+ mobileNo + ", address=" + address + ", department=" + department + ", student=" + student + "]";
	}
	
	
	
}
