





(function(){
    'use strict';
    angular.module('tracker')
        .controller('readingsPlotController',readingsPlotController);
   readingsPlotController.$inject=['trackerService'];

    function readingsPlotController(trackerService){
          
   
    
        var readPlotVm = this;
        trackerService.get().then(function(plot){
            readPlotVm.plot=plot;
            
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
