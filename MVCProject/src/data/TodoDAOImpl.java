package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Todo;
import entities.User;

@Transactional
@Repository
public class TodoDAOImpl implements TodoDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Set<Todo> index(int uid) {
		String query = "SELECT t FROM Todo t WHERE t.owner.id = :uid";
		List<Todo> todos = em.createQuery(query, Todo.class).setParameter("uid", uid).getResultList();
		return new HashSet<Todo>(todos);
	}


	@Override
	public Todo show(int uid, int tid) {
		Todo todo = em.find(Todo.class, tid);
		if(todo.getOwner().getId() != uid) {
			
		}
		return todo;
	}

	@Override
	public Todo create(int uid, String todoJson) {
		ObjectMapper om = new ObjectMapper();
		Todo todo = null;
		try {
			todo = om.readValue(todoJson, Todo.class);
			User user = em.find(User.class, uid);
			todo.setOwner(user);
			em.persist(todo);
			em.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public Todo update(int uid, int tid, String todoJson) {
		ObjectMapper om = new ObjectMapper();
		Todo updateTodo = null;
		Todo ogTodo = null;
		try {
			updateTodo = om.readValue(todoJson, Todo.class);
			ogTodo = em.find(Todo.class, tid);
			ogTodo.setTask(updateTodo.getTask());
			ogTodo.setCompleted(updateTodo.isCompleted());
			ogTodo.setComplete_date(updateTodo.getComplete_date());
			ogTodo.setDescription(updateTodo.getDescription());
			ogTodo.setDueDate(updateTodo.getDueDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ogTodo;
	}

	@Override
	public Boolean destroy(int uid, int tid) {
//		Todo todo = em.find(Todo.class, tid);
//		if(todo == null) {
//			return null;
//		}
//		em.remove(todo);
//		
//		if(em.find(Todo.class, tid)==null) {
//			return true;
//		}
//		return false;
//		
		String query = "DELETE FROM Todo t WHERE t.id = :tid";
		int updates  = em.createQuery(query).setParameter("tid", tid).executeUpdate();
		
		if(updates > 0) {
			return true;
		}
		
		return false;
	}

}
