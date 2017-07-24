(function(){
    'use strict';
    angular.module('tracker')
        .controller('locationController',locationController);
    locationController.$inject=['trackerService'];

    function locationController(trackerService){
          
        var locationVm = this;
        trackerService.get().then(function(geo){
            locationVm.geo=geo;
           
        }, function(error){
            console.log(error);
        });
        
        
        
        
        
     
    }
})();