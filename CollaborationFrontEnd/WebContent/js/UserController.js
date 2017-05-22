app.controller('UserController',function($scope,$location,UserService,$rootScope, $cookieStore, $http)
{
	console.log("entering user contoller")
	var self=this;
	$scope.users;
	$scope.message;
	$scope.user={id:'', name:'',password:'',address:'',email:'',mobile:'',status:'',reason:'',role:'',is_online:'',errorCode:'',errorMessage:''}
	
	self.registerUser=function()
	{
		console.log("entering add user")
		UserService.registerUser($scope.user)
		.then(
				function(response)
	{
			
			console.log("registration success"+response.status)
			$location.path("/")
	}		
		);
	};
	
	
	self.authenticate = function(user)
	{
		console.log("Authenticate Function");
		UserService.authenticate(user)
		.then 
		(
			function(d)
			{
				$scope.user = d;
				console.log("User ErrorCode - "+$scope.user.errorCode)
				if($scope.user.status == 'R')
					{
						alert("Your Registeration is Rejected. Please Contact ADMIN");
						user.setErrorCode("404");
						user.setErrorMsg("Your Registeration is Rejected");
					}
				if($scope.user.status == 'N')
				{
					alert("Your Registeration is Not Approved.");
					user.setErrorCode("404");
					user.setErrorMsg("Your Registeration is Not Approved");
				}
				if($scope.user.id == null)
				{
					alert("Invalid Username or Password");
					console.log("Invalid Username or Password")
					$location.path("/login");
				}
				
				else
				{
					console.log("Valid Credentials, Navigating to home page "+$scope.user.status)
					$scope.message1="Successfully Logged in as ";
					$rootScope.currentUser = 
						{
							id: $scope.user.id,
							name: $scope.user.name,
							
							address:$scope.user.address,
							mobile: $scope.user.mobile,
							email: $scope.user.email,
							status: $scope.user.status,
							role: $scope.user.role,
							reason:$scope.user.reason,
							is_online: $scope.user.is_online
							
						};
					$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser;
					$cookieStore.put('currentUser', $rootScope.currentUser)
					$location.path("/home");
				}
			}, 	function(errResponse)
			{
				console.error("Error Authenticating User");
				$scope.message = "Invalid username or password.";
				$location.path("/login");
			}
		);
	};
	
	
	self.login= function()
	{
		console.log("Validating Login "+$scope.user);
		self.authenticate($scope.user);
	};

	self.logout= function()
	{
		console.log("Entering Logout Function");
		$rootScope.currentUser = {};
		$cookieStore.remove('currentUser');
		
		console.log("Calling Session Logout");
		UserService.logout()
		$location.path('/login');
	};

	self.registerFriend=function(id)
	{
		console.log("entering add friend -"+id)
		UserService.registerFriend(id)
		.then(
				function(response)
	{
			console.log("registration success "+response.status)
			alert('Friend Request Sent')
			$location.path("/")
	}		
		)
	};
	
	listUser=function()
	{
		console.log("entring list user method")
		UserService.listUser()
		.then
		(
				function(response)
				{
			console.log("List Users Successful"+response.status)
			$scope.users=response
			$scope.message="Successfully Retrived list"
				}
		)
	}
	
	listUser();
	
}		
)