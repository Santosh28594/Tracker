
(function(){
    'use strict';
    angular.module('tracker')
        .controller('trackerController',trackerController);
    
    
    trackerController.$inject=['trackerService'];

    function trackerController(trackerService){
        console.log("Came here to controller");
          
   
    
        var trackVm = this;
        trackerService.get().then(function(vehicles){
            trackVm.vehicles=vehicles;
            
            console.log(vehicles);
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
