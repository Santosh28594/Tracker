(function(){
    'use strict';
    angular.module('tracker')
        .controller('trackerController',trackerController);
    trackerController.$inject=['trackerService'];

    function trackerController(trackerService){
        var trackVm = this;
        trackVm.title='Car-Tracker project';
        trackerService.get().then(function(response){
            trackVm.vehicles=response;
        }, function(error){
            console.log(error);
        });
    }
})();