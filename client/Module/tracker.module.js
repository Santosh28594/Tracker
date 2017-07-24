(function() {
  'use strict';
  var tracker = angular.module('tracker', ['ngRoute', 'zingchart-angularjs']);
  
  angular.module('tracker')
  .config(moduleConfig);
  
   tracker.config(function($httpProvider) {
      //Enable cross domain calls
      $httpProvider.defaults.useXDomain = true;

      //Remove the header used to identify ajax call  that would prevent CORS from working
      delete $httpProvider.defaults.headers.common['X-Requested-With'];
  });
    
moduleConfig.$inject=['$routeProvider'];
  
  function moduleConfig($routeProvider){
    $routeProvider
    
    .when('/vehicles',{
      templateUrl: 'Html/vehicle-list.tmpl.html',
      
    })
    .when('/vehicles/:vin',{ 
      templateUrl: 'Html/vehicle-details.tmpl.html',
      
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
    
    angular.module('tracker')
  .config(module2Config);
  module2Config.$inject=['$routeProvider'];
   function module2Config($routeProvider){
    $routeProvider
    
    .when('/alerts-count',{
      templateUrl: 'Html/vehicle-alertcount.tmpl.html',
      controller: 'alertCountController',
      controllerAs: 'aCountVm'
    })
    
    
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
    
     angular.module('tracker')
  .config(module3Config);
  module3Config.$inject=['$routeProvider'];
   function module3Config($routeProvider){
    $routeProvider
    

    
     .when('/alerts-history',{
      templateUrl: 'Html/vehicle-alerthistory.tmpl.html',
      
    })
     .when('/alerts-history/:vin',{ 
      templateUrl: 'Html/history-details.tmpl.html',
     
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
      angular.module('tracker')
  .config(module4Config);
  module4Config.$inject=['$routeProvider'];
   function module4Config($routeProvider){
    $routeProvider
    

    
     .when('/location',{
      templateUrl: 'Html/vehicle-location.tmpl.html',
      
    })
     .when('/location/:vin',{ 
      templateUrl: 'Html/vehicle-location-track.tmpl.html',
     
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
     angular.module('tracker')
  .config(module5Config);
  module5Config.$inject=['$routeProvider'];
   function module5Config($routeProvider){
    $routeProvider
    

    
     .when('/plots',{
      templateUrl: 'Html/readings-plot.tmpl.html',
      
    })
     .when('/plots/:vin',{ 
      templateUrl: 'Html/readings-plot-graph.tmpl.html',
     
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }


})();