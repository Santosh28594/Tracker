(function(){
    'use strict';
    angular.module('tracker')
        .controller('alertCountController',alertCountController);
    alertCountController.$inject=['trackerService'];

    function alertCountController(trackerService){
          
   
    
        var aCountVm = this;
        trackerService.getaCount().then(function(alertCount){
            aCountVm.alertCount=alertCount;
        }, function(error){
            console.log(error);
        });
        
     
    }
})();