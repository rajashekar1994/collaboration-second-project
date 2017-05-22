app.factory('BlogService', function($http, $q, $rootScope)
{
	console.log("Entering BlogService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	registerBlog: function(blog)
	{
		console.log("Entering Function Register Blog")
		return $http.post(BASE_URL + "addBlog", blog)
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
	
	listBlog: function()
	{
		console.log("Entering Function List Blog")
		return $http.get(BASE_URL + "listBlog")
		.then(function(response)
			{
				console.log(response.data)
				console.log(response.status)
				return response.data
			})
	}
	}
})