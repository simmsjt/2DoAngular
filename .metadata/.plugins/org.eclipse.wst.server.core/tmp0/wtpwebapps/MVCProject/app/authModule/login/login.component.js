angular.module('authModule')
.component('login',{
	templateUrl : 'app/authModule/login/login.component.html',
	controllerAs: 'vm',
	controller : function(authService){
		var vm = this;
		
		vm.login = function(user) {
	            if (user.password === user.confirm) {
	                delete user.confirm;
	                authService.register(user)
	            } else {
	                console.log("PASSWORDS DO NOT MATCH")
	            }
	        }
	}
})