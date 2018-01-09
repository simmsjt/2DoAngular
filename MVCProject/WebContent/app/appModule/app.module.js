angular.module('appModule',[]);


angular.module('appModule', ['ngRoute'])
.config(function($routeProvider){
	$routeProvider
    .when('/', {
      template : '<home></home>'
    })
    .when('/contact', {
      template : '<contact></contact>'
    })
    .when('/about', {
      template : '<about></about>'
    })
    .when('/todo', {
      template : '<todo-list></todo-list>'
    })
    .when('/todo/:id', {
      template : '<todo-list></todo-list>'
    })
    .otherwise({
      template : '<not-found></not-found>'
    })
    
});