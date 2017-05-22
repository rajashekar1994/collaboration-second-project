app.factory('JobService', function($http, $q, $rootScope)
{
	console.log("Entering JobService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	registerJob: function(job)
	{
		console.log("Entering Function Register job")
		return $http.post(BASE_URL + "addJob", job)
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
	
	listJob: function()
	{
		console.log("Entering Function List Job")
		return $http.get(BASE_URL + "listJob")
		.then(function(response)
			{
				console.log(response.data)
				console.log(response.status)
				return response.data
			})
	}
	}
})