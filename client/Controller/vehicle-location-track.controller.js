



(function(){
    'use strict';
    angular.module('tracker')
        .controller('vehicleTrackController',vehicleTrackController);
   vehicleTrackController.$inject=['trackerService','$routeParams'];

    function vehicleTrackController(trackerService, $routeParams){
        console.log("Came here to controller");
            function initMap(maps){
              var myOptions = {
                     center: new google.maps.LatLng( maps[0].latitude, maps[0].longitude ),
		              	zoom:7
                };
                 var map = new google.maps.Map(document.getElementById("map"), myOptions );
                 var uluru1 = {lat: parseFloat(maps[0].latitude), lng: parseFloat(maps[0].longitude)};
            var marker1 = new google.maps.Marker({
          position: uluru1,
          map: map
        });
          for(var ma in maps){
            var uluru1 = {lat: parseFloat(maps[ma].latitude), lng: parseFloat(maps[ma].longitude)};
            var marker1 = new google.maps.Marker({
          position: uluru1,
          map: map
        });
          }
          
          
          
        }
        
    
        var vehicletrackVm = this;
        trackerService.getVt($routeParams.vin)
        .then(function(map){
          vehicletrackVm.map=map;
       initMap(map);
        },function(error){
          console.log(error);
        });
       
        console.log($routeParams.vin);
        
      
        
        
      
     
    }
})();