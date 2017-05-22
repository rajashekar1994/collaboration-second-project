app.controller('JobController',function($scope,$location,JobService)
{
	console.log("entering job contoller")
	var self=this;
	$scope.jobs;
	$scope.message;
	$scope.job={id:'', dateTime:'',description:'',qualification:'',reason:'',status:'',title:'',user_id:'',errorCode:'',errorMessage:''}
	
	self.registerJob=function()
	{
		console.log("entering add job")
		JobService.registerJob($scope.job)
		.then(
				function(response)
	{
			
			console.log("registration success"+response.status)
			$location.path("/")
	}		
		);
	};
	
	
	listJob=function()
	{
		console.log("entring list job method")
		JobService.listJob()
		.then
		(
				function(response)
				{
			console.log("List Job Successful"+response.status)
			$scope.jobs=response
			$scope.message="Successfully Retrived list"
				}
		)
	}
	
	listJob();
	
}		
)