var agentsApp = angular.module('tsApp', ['ngCookies', 'ngRoute','ngResource', 'ui.bootstrap']);

agentsApp.config(function($routeProvider){
				
				$routeProvider
						.when(
							"/",
							{
									templateUrl : "index.html"
							}
						)
						.otherwise(
							{
							redirectTo: "/"
							}	
						);
	}
);
