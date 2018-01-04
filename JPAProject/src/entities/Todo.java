package entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String task;
	String description;
	boolean completed;
	@ManyToOne(fetch=FetchType.LAZY)
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
	
	
}
