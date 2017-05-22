app.controller('ForumController',function($scope,$location,ForumService)
{
	console.log("entering forum contoller")
	var self=this;
	$scope.forums;
	$scope.message;
	$scope.forum={id:'', dateTime:'',description:'',reason:'',status:'',title:'',userId:'',errorCode:'',errorMessage:''}
	
	self.registerForum=function()
	{
		console.log("entering add forum")
		ForumService.registerForum($scope.forum)
		.then(
				function(response)
	{
			
			console.log("registration success"+response.status)
			$location.path("/")
	}		
		);
	};
	
	
	listForum=function()
	{
		console.log("entring list forum method")
		ForumService.listForum()
		.then
		(
				function(response)
				{
			console.log("List Forums Successful"+response.status)
			$scope.forums=response
			$scope.message="Successfully Retrived list"
				}
		)
	}
	
	listForum();
	
}		
)