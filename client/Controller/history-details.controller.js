(function(){
    'use strict';
    angular.module('tracker')
        .controller('historyDetailsController',historyDetailsController);
    historyDetailsController.$inject=['trackerService','$routeParams'];

    function historyDetailsController(trackerService, $routeParams){
          
        
    
        var  hDetailVm = this;
        trackerService.getHD($routeParams.vin)
        .then(function(historyDetails){
          hDetailVm.historyDetails = historyDetails;
        },function(error){
          console.log(error);
        });
       
       
     
    }
})();