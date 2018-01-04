angular.module('appModule')
  .component('todoList', {
	  templateUrl : 'app/appModule/todoList/todoList.component.html',
	  controller: function(todoService){
		  var vm = this;
		  vm.selected = null;
		  vm.copy = null;
		  vm.todos = [];
		  vm.todos = todoService.index();
		 
	      
	      vm.getNumTodos = function() {
		        return vm.todos.length;
		  };
		  
		  vm.addTodo = function(todo){
			  todoService.create(todo);
		  };
		  
		  vm.displayTodo = function(todo){
			  vm.selected = todo;
			  vm.copy = angular.copy(vm.selected);
		  };
		  
		  vm.resetEdit = function(){
			  vm.copy = angular.copy(vm.selected);
		  };
		  
		  vm.destroy = function(todo){
			  console.log('1');
			  todoService.destroy(todo);
			  vm.displayTable();
		  };
		  
		  vm.submitEdit = function(){
			todoService.update(vm.copy);
			vm.displayTable();
		  };
		  
		  vm.displayTable = function(){
			  vm.selected = null;
			  vm.copy = null;
			  vm.todos = todoService.index();
		  };
	      
	  },
	  controllerAs: 'vm'
  })
  
  