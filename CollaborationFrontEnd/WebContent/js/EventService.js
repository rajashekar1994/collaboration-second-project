app.factory('EventService', function($http, $q, $rootScope)
{
	console.log("Entering EventService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	registerEvent: function(event)
	{
		console.log("Entering Function Register Event")
		return $http.post(BASE_URL + "addEvent",event)
		.then(function(response)
			{
				console.log(response.status)
				return response.status
			},function(errResponse)
			{
				console.log(errResponse.status)
				return errResponse.status
			});
	},
	
	listEvent: function()
	{
		console.log("Entering Function List Event")
		return $http.get(BASE_URL + "listEvent")
		.then(function(response)
			{
				console.log(response.data)
				console.log(response.status)
				return response.data
			})
	}
	}
})