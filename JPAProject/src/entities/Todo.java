package entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String task;
	String description;
	boolean completed;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	private User owner;
	@Column(name = "due_date")
	String dueDate;
	@Column(name = "complete_date")
	String complete_date;
	@Column(name = "created_at")
	Timestamp createdAt;
	@Column(name = "updated_at")
	Timestamp updatedAt;
	
	//------------------------------------
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getComplete_date() {
		return complete_date;
	}
	public void setComplete_date(String complete_date) {
		this.complete_date = complete_date;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", description=" + description + ", completed=" + completed
				+ ", owner=" + owner + ", dueDate=" + dueDate + ", complete_date=" + complete_date + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
