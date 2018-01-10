angular.module('appModule')
.factory('todoService',function($http, $filter){
	var service = {};
	
	service.index = function(){
		return $http({
		      method : 'GET',
		      url : 'rest/user/1/todo'
		    })
	};
	
	service.create = function(task){
		task.completed = false; 
		return $http({
			method: 'POST',
			url : 'rest/user/1/todo',
			headers : {
			    'Content-Type' : 'application/json'
			  },
			data : task
		})
	};
	
	service.destroy = function(id){
		return $http({
			method: 'DELETE',
			url : 'rest/user/1/todo/' + id
		})
	};
      
    service.getNumTasks = function() {
        return tasks.length;
    };

    service.update = function(task){
    		if(task.completed == true){
    			task.complete_date = $filter('date')(Date.now(), 'MM/dd/yyyy');
    			console.log(task.complete_date);
    		} else {
    			task.complete_date = "";
    			console.log(task.complete_date);
    		}
    		return $http({
    			method: 'PUT',
    			url: 'rest/user/1/todo/' + task.id,
    			headers : {
    			    'Content-Type' : 'application/json'
    			  },
    			data : task
    		})
    	
    };
    

	return service;
})