
var app = angular.module('myApp',['ngRoute','ngCookies']);

app.config(function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl : 'views/home.html',
		
	} )
	
	.when('/register',{
		templateUrl : 'views/register.html',
		controller : 'UserController'
	})
	
	.when('/login',{
		templateUrl : 'views/login.html',
		controller : 'UserController'
	})
	
	.when('/listUser',{
		templateUrl : 'views/listUser.html',
		controller : 'UserController'
	})
	.when('/listBlog',{
		templateUrl : 'views/listBlog.html',
		controller : 'BlogController'
	})
	.when('/forum',{
		templateUrl : 'views/Forum.html',
		controller : 'ForumController'
	})
	.when('/listForum',{
		templateUrl : 'views/listForum.html',
		controller : 'ForumController'
	})
	
	.when('/job',{
		templateUrl : 'views/Job.html',
		controller : 'JobController'
	})
	.when('/listJob',{
		templateUrl : 'views/listJob.html',
		controller : 'JobController'
	})
	
	.when('/friend',{
		templateUrl : 'views/Friend.html',
		controller : 'FriendController'
	})
	
	.when('/listFriend',{
		templateUrl : 'views/listFriend.html',
		controller : 'FriendController'
	})
	.when('/event',{
		templateUrl : 'views/Event.html',
		controller : 'EventController'
	})
	.when('/listEvent',{
		templateUrl : 'views/listEvent.html',
		controller : 'EventController'
	})
	
	
	.when('/blog',{
		templateUrl : 'views/Blog.html',
		controller : 'BlogController'
	})
	
	.when('/pendingRequest',{
		templateUrl : 'views/pendingRequest.html',
		controller : 'FriendController'
	})
	
	.when('/uploadPicture',{
		templateUrl:'views/fileUpload.html'
	})
	
	.when('/chat',{
		controller:'ChatCtrl',
		templateUrl:'views/chat.html'
	})

	.when('/terms',{
		controller:'UserController',
		templateUrl:'views/terms.html'
	})
	.otherwise({redirectTo: '/'});
});



app.run( function ($rootScope, $location, $cookieStore, $http) {

	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 console.log("$locationChangeStart")
		 //http://localhost:8080/Collaboration/addjob
	        // redirect to login page if not logged in and trying to access a restricted page
	     
		 var userPages = ['/viewUsers']
		 var adminPages = ["/viewBlogs","/viewJobs"]
		 
		 var currentPage = $location.path()
		 
		 var isUserPage = $.inArray(currentPage, userPages) ==1;
		 var isAdminPage = $.inArray(currentPage, adminPages) ==1;
		 
		 var isLoggedIn = $rootScope.currentUser.id;
	        
	     console.log("isLoggedIn:" +isLoggedIn)
	     console.log("isUserPage:" +isUserPage)
	     console.log("isAdminPage:" +isAdminPage)
	        
	        if(!isLoggedIn)
	        	{
	        	
	        	 if (isUserPage || isAdminPage) {
		        	  console.log("Navigating to login page:")
		        	  alert("You need to loggin to do this operation")

						            $location.path('/');
		                }
	        	}
	        
			 else //logged in
	        	{
	        	
				 var role = $rootScope.currentUser.role;
				 
				 if(isAdminPage && role!='ADMIN' )
					 {
					 
					  alert("You can not do this operation as you are logged as : " + role )
					   $location.path('/login');
					 
					 }
	        	}
	 }
	       );
	 
	 
	 // keep user logged in after page refresh
   $rootScope.currentUser = $cookieStore.get('currentUser') || {};
   if ($rootScope.currentUser) {
       $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
   }

});