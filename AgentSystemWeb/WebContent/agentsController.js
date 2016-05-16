
//consoleController

angular.module('agentsApp')

	.controller('agentsController', ['$scope', '$websocket', 
	       function($scope, $websocket){
				$scope.cc.accordion = {
						messages: true,
						agents: true
				};
				$scope.cc.agents = xjaf.agents;
				$scope.cc.messages = [];
				
				$scope.cc.clearConsole = function() {
					cc.messages = [];
				}
				
				var socket = $websocket("ws://" + window.location.host + "/AgentSystemWeb/console");

				socket.onMessage(function(message) {
					var msg = JSON.parse(message.data);
					if(msg.type === "LOG") {
						var d = new Date();
					    var time = ("0" + d.getHours()).substr(-2) + ':' + ("0" + d.getMinutes()).substr(-2) + ':' + ("0" + d.getSeconds()).substr(-2);
						$scope.cc.messages.push(time + " - " + msg.data);
					} else if(msg.type === "ADD") {
						xjaf.agents.array.push(JSON.parse(msg.data));
					} else if(msg.type === "REMOVE") {
						var agent = JSON.parse(msg.data);
						for(var i = 0, n = xjaf.agents.array.length; i < n; i++) {
							if(agent.str === xjaf.agents.array[i].str) {
								xjaf.agents.array.splice(i, 1);
								break;
							}
						}
					}
				});

				socket.onOpen(function() {
					console.log("WebSocket for console connection opened.");
				});

				socket.onClose(function(e) {
					console.log("WebSocket for console connection closed.");
				});

				socket.onError(function(e) {
				    console.log("WebSocket for console  connection error: " + e.data);
				});
		
	}]);