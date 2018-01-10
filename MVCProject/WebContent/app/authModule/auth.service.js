angular.module('authModule')
.factory('authService', function($http, $cookies, $location){
	var service = {};
	
	service.getToken = function(){
		var user = {};
		user.id = $cookies.get('uid');
		return user;
	}
	
	var removeToken = function() {
	     $cookies.removie('uid');
	 }
	
	var saveToken = function(user) {
        $cookies.put('uid', user.id);
	}

	service.register = function(user) {
	 return $http({
	     method : 'POST',
	     url : 'rest/auth/register',
	     headers :  {
	         'Content-Type' : 'application/json'
	     },
	     data : user
	 })
	 .then(function(response) {
	     saveToken(response.data);
	     $location.path('/todo');
	 })
	 .catch(console.error)
	}
	
	service.login = function(user){
		return $http({
		     method : 'POST',
		     url : 'rest/auth/login',
		     headers :  {
		         'Content-Type' : 'application/json'
		     },
		     data : user
		 })
		 .then(function(response) {
		     saveToken(response.data);
		     $location.path('/todo');
		 })
		 .catch(console.error)
	}
	
	service.logout = function(user){
		return $http({
		     method : 'POST',
		     url : 'rest/auth/logout',
		     headers :  {
		         'Content-Type' : 'application/json'
		     }
		 })
	}
	
	
	
	return service;
})
