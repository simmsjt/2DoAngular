package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TodoDAO;
import entities.Todo;

@RestController
public class TodoController {
	@Autowired
	private TodoDAO dao;
	
	@RequestMapping(path = "user/{uid}/todo", method = RequestMethod.GET)
	public Set<Todo> todo(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid) {
	  return dao.index(uid);
	}
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.GET)
	public Todo show(HttpServletRequest req, 
			HttpServletResponse res,
			@PathVariable int uid,
			@PathVariable int tid
			) 
	{
	 Todo todo = null;
	 try {
		 todo = dao.show(uid, tid);
	 } catch (Exception e) {
		 res.setStatus(401);
		 return null;
	 }
	  return todo;
	}
	
	@RequestMapping(path = "user/{uid}/todo", method = RequestMethod.POST)
	public Todo create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @RequestBody String todoJson) {
		
		Todo todo = dao.create(uid,todoJson);
		if(todo ==null ) {
			res.setStatus(400);
		}
		return todo;
	}
	
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.PUT)
	public Todo update(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int tid, @RequestBody String todoJson) {
		Todo todo = dao.update(uid, tid, todoJson);
		if(todo == null) {
			res.setStatus(400);
		}
		return todo;
	}
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.DELETE)
	public boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int tid) {
		return dao.destroy(uid, tid);
	}
	
}
