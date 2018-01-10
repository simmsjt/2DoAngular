angular.module('appModule', ['ngRoute', 'authModule'])
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
    .when('/register', {
      template : '<register>loading...</register>'
    })
    .when('/login', {
      template : '<login></login>'
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