app.controller('EventController',function($scope,$location,EventService)
{
	console.log("entering event contoller")
	var self=this;
	$scope.events;
	$scope.message;
	$scope.event={id:'', date_time:'',description:'',name:'',venue:'',errorCode:'',errorMessage:''}
	
	self.registerEvent=function()
	{
		console.log("entering add event")
		EventService.registerEvent($scope.event)
		.then(
				function(response)
	{
			
			console.log("registration success"+response.status)
			$location.path("/")
	}		
		);
	};
	
	
	listEvent=function()
	{
		console.log("entring list event method")
		EventService.listEvent()
		.then
		(
				function(response)
				{
			console.log("List Events Successful"+response.status)
			$scope.events=response
			$scope.message="Successfully Retrived list"
				}
		)
	}
	
	listEvent();
	
}		
)