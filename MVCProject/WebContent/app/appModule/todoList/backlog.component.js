 angular.module('appModule')
.component('backlog', {
  templateUrl : 'app/appModule/todoList/backlog.component.html',
  controller : function() {
    var vm =this;
    
    vm.x = 1;
    
    vm.criticalityLevel = 7;

    vm.go = function() {
    		vm.x ++;
    }
  }
})