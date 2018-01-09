angular.module('appModule')
  .component('todoList', {
	  templateUrl : 'app/appModule/todoList/todoList.component.html',
	  controller: function(todoService,$filter,$routeParams){
		  var vm = this;
		  vm.selected = null;
		  vm.copy = null;
		  vm.todos = [];
		  vm.showCompleted = true;
		  
		  reload();
		  var incompleteFilter =  $filter('incomplete');
		  
		  function reload(){
			  todoService.index().then(function(res){
				  vm.todos = res.data;
			  }).catch(function(error){
				  console.log(error);
			  });
		  }
		  
//		  if (!vm.selected  && parseInt($routeParams.id)) {
//			  console.log(vm.todos);
//			  vm.todos.forEach(function(element){
//				  if(element.id=== parseInt($routeParams.id))
//					  console.log(element);
//					  vm.selected = element;
//			  });
//			  console.log(vm.selected);
//		  }
//		  
		  
		  vm.greyedOut = function(isCompleted){
			  if(isCompleted== true)
				  return 'greyedOut'; 
		  }
		  
		  
		  vm.addTodo = function(todo){
			  todoService.create(todo).then(function(res){
				 console.log(res);
				 reload();
			  }).catch(function(error){
				  console.log(error);
			  });
			  
	       }
		  
		  vm.submitEdit = function(){
			  todoService.update(vm.copy).then(function(res){
				 console.log(res);
				 vm.displayTable();
			  }).catch(function(error){
				  console.log(error);
			  });
	       }
		  
	      vm.updateTodo = function(todo){
	    	  todoService.update(todo).then(function(res){
					 console.log(res);
					 reload();
				  }).catch(function(error){
					  console.log(error);
				  });
	      };
	      
	      vm.getNumTodos = function() {
		        var sum = 0;
		        vm.todos.forEach(function(todo){
		        		if(todo.completed== false)
		        			sum ++;
		        });
		        return sum;
		  };
		  
		  vm.displayTodo = function(todo){
			  vm.selected = todo;
			  vm.copy = angular.copy(vm.selected);
		  };
		  
		  vm.checkNumbTodos = function(){
			  if(vm.getNumTodos() > 10){
				  return 'red';
			  }
			  if(vm.getNumTodos()< 5){
				  return 'green';
			  }
			  return 'yellow';
		  }
		  
		  
		  vm.resetEdit = function(){
			  vm.copy = angular.copy(vm.selected);
		  };
		  
		  vm.destroy = function(id){
			  todoService.destroy(id).then(function(res){
					 console.log(res);
					 reload();
				  }).catch(function(error){
					  console.log(error);
				  });
		  };
		  
		  vm.displayTable = function(){
			  vm.selected = null;
			  vm.copy = null;
			  reload();
		  };
	      
		 
	  },
	  controllerAs: 'vm'
  })
  
  