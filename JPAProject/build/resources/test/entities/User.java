package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String email;
	String password;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "owner")
	private List<Todo> tasks;
	
	//---------------------------------------
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Todo> getTasks() {
		return tasks;
	}
	public void setTasks(List<Todo> tasks) {
		this.tasks = tasks;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", tasks=" + tasks + "]";
	}
	
	
}
