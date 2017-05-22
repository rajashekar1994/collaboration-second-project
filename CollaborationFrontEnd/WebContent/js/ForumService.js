app.factory('ForumService', function($http, $q, $rootScope)
{
	console.log("Entering ForumService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	registerForum: function(forum)
	{
		console.log("Entering Function Register forum")
		return $http.post(BASE_URL + "addForum", forum)
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
	
	
	
	listForum: function()
	{
		console.log("Entering Function List Forum")
		return $http.get(BASE_URL + "listForum")
		.then(function(response)
			{
				console.log(response.data)
				console.log(response.status)
				return response.data
			})
	}
	}
})