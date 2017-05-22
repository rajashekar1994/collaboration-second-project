app.factory('FriendService', function($http, $q, $rootScope)
{
	console.log("Entering FriendService")
	var BASE_URL = "http://localhost:8080/CollaborationRestController/"
		return{
	//var userService = this;
	
	
	
	
	pendingRequest:function(){
		console.log('PENDING REQUEST')
		return $http.get(BASE_URL +"pendingRequest")
		
	},
		
	acceptFriend:function(user_id){
		console.log('ACCEPT FRIEND'+user_id)
		return $http.get(BASE_URL +"acceptFriend-"+user_id)
		.then
		(
				function(response)
				{
					return response.data;
				},
				function(errResponse)
				{
					console.log("error adding friend");
					return $q.reject(errResponse);
				}
		);
	},
	
	rejectFriend:function(user_id){
		console.log('REJECTING FRIEND')
		return $http.get(BASE_URL +"rejectFriend-"+user_id)
		.then
		(
				function(response)
				{
					return response.data;
				},
				function(errResponse)
				{
					console.log("error rejecting friend");
					return $q.reject(errResponse);
				}
		);
		
		
		
		
	},
	
	unFriend:function(user_id){
		console.log('UNFRIEND')
		return $http.get(BASE_URL +"unFriend/"+user_id)
		
	},
		
		
		
		
		
		
		
	listFriend: function()
	{
		console.log("Entering Function List Friend")
		return $http.get(BASE_URL + "listFriend")
//		.then(function(response)
//			{
//				console.log(response.data)
//				console.log(response.status)
//				return response.data
//			})
	}
	}
})