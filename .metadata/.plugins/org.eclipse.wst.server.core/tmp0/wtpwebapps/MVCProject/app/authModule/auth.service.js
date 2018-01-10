angular.module('authModule')
.factory('authService', function($http, $cookies, $location){
	var service = {};
	
	service.getToken = function(){
		var user = {};
		user.id = $cookies.get('uid');
		return user;
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
	     saveToke(response.data)
	 })
	 .catch(console.error)
	}
	
	return service;
})