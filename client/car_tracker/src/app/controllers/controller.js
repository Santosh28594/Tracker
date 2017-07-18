(function(){
    'use strict';
    var tracker = angular.module('tracker')
        .controller('trackerController',trackerController);
    trackerController.$inject=['trackerService'];

    function trackerController(trackerService){
        console.log("Came here to controller");
        var trackVm = this;
        trackerService.get().then(function(response){
            trackVm.vehicles=response;
        }, function(error){
            console.log(error);
        });
    }
})();