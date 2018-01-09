angular.module('appModule')
.filter('incomplete',function(){
	return function(todos, showCompleted){
		var results = [];
		if(showCompleted === true){
			return todos
		}
		todos.forEach(function(todo){
			if(todo.completed === false)
				results.push(todo);	
		});
		return results;
	}
	
})