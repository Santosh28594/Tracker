(function(){
    'use strict';
    angular.module('tracker')
        .controller('vAlertController',vAlertController);
    vAlertController.$inject=['trackerService'];

    function vAlertController(trackerService){
        console.log("Came here to controller");
          
   
    
        var vAlertVm = this;
        trackerService.get().then(function(alerts){
            vAlertVm.alerts=alerts;
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
