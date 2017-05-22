app.factory('UserService', function($http, $q, $rootScope)
{
	console.log("Entering UserService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	registerUser: function(user)
	{
		console.log("Entering Function Register User")
		return $http.post(BASE_URL + "addUser", user)
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
	
	
	authenticate: function(user)
	{
		console.log("Entering Function Validate User")
		return $http.post(BASE_URL + "login", user)
		.then(
				function(response)
				{
					if(response.data.errorMessage == "Success")
						{
							$rootScope.currentUser = 
								{
									id: response.data.id,
									name: response.data.name,
									address:response.data.address,
									
									email: response.data.email,
									mobile: response.data.mobile,
									status: response.data.status,
									role: response.data.role,
									reason: response.data.reason,
									is_online: response.data.is_online
								};
						}
					return response.data;
				},
				function(errResponse)
				{
					$rootScope.userLoggedIn = false;
					console.error(errResponse.status);
					console.error("Error while validating");
					return $q.reject(errResponse);
				});
	},
	
	logout: function()
	{
		console.log("Entering Logout")
		return $http.get(BASE_URL + "logout")
		.then
		(
			function(response)
			{
				return response.data;
			},
			function (errResponse)
			{
				console.log("Error Logging out");
				return $q.reject(errResponse);
			}
		);
	},

	registerFriend: function(id)
	{
		console.log("Entering Function Register Friend")
		console.log(BASE_URL + "addFriend_"+id)
		return $http.get(BASE_URL + "addFriend_"+id)
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
	
	listUser: function()
	{
		console.log("Entering Function List User")
		return $http.get(BASE_URL + "listUser")
		.then(function(response)
			{
				console.log(response.data)
				console.log(response.status)
				return response.data
			})
	}
	}
})