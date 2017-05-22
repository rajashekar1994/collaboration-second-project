app.controller('BlogController',function($scope,$location,BlogService)
{
	console.log("entering blog contoller")
	var self=this;
	$scope.blogs;
	$scope.message;
	$scope.blog={id:'', dateTime:'',description:'',reason:'',status:'',title:'',userId:'',errorCode:'',errorMessage:''}
	
	self.registerBlog=function()
	{
		console.log("entering add blog")
		BlogService.registerBlog($scope.blog)
		.then(
				function(response)
	{
			
			console.log("registration success"+response.status)
			$location.path("/")
	}		
		);
	};
	
	
	listBlog=function()
	{
		console.log("entring list blog method")
		BlogService.listBlog()
		.then
		(
				function(response)
				{
			console.log("List Blogs Successful"+response.status)
			$scope.blogs=response
			$scope.message="Successfully Retrived list"
				}
		)
	}
	
	listBlog();
	
}		
)