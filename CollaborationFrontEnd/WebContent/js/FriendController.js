app.controller('FriendController',function($scope,$location,FriendService)
{
	console.log("entering friend contoller")
	var self=this;
	$scope.friends;
	$scope.message;
	$scope.friend={id:'',friend_id:'',status:'',user_id:'',errorCode:'',errorMessage:''}
	
	
	
	$scope.pendingRequest=
		FriendService.pendingRequest()
		.then(function(response){
		console.log('PENDING REQUEST')
		console.log(response.status);
		$scope.pendingRequest=response.data
		console.log($scope.pendingRequest)
		//alert($scope.pendingRequest);
		},function(errResponse){
			console.log(errResponse.data);
			
		})
		
		$scope.acceptFriend=function(user_id){
		FriendService.acceptFriend(user_id)
		.then(function(response){
		console.log('FRIEND REQUEST ACCEPTED')
		console.log(response.status);
		alert('FRIEND REQUEST ACCEPTED');
		$location.path("/listFriend")
		
		},function(response){
			console.log('response.status');
			$location.path("/pendingRequest")
		})
	}
	
	

	$scope.rejectFriend=function(user_id){
	FriendService.rejectFriend(user_id)
	.then(function(response){
	console.log('FRIEND REQUEST REJECTED')
	console.log(response.status);
	alert('FRIEND REQUEST REJECTED');
	$location.path("/myFriendsList")
	
	},function(response){
		console.log('response.status');
		$location.path("/pendingRequest")
	})
}
	

	$scope.unFriend=function(friend_id){
	FriendService.unFriendd(friend_id)
	.then(function(response){
	console.log('UNFRIEND')
	console.log(response.status);
	alert('UNFRIEND');
	$location.path("/listFriend")
	
	},function(response){
		console.log('response.status');
		$location.path("/listFriend")
	})
}
		
		
	
	
//	$scope.friends=FriendService.listFriend()
//	{
//		console.log("entring list friend method")
//		.then
//		(
//				function(response)
//				{
//			console.log("List Friend Successful"+response.status)
//			$scope.friends=response.data
//			$scope.message="Successfully Retrived list"
//				}
//		)
//	}
	
	
	
	
	function listFriend(){
		   console.log('ENTERING LIST OF FRIENDS')
		   FriendService.listFriend()
			   .then(function(response){
				   console.log(response.status)
			   console.log(response.data)
			   $scope.friends=response.data
		   }
		   )
	}
	listFriend()

	
}		
)