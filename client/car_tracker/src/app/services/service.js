(function(){
    'use strict';
    var tracker = angular.module('tracker')
        .service('trackerService', trackerService);

    trackerService.$inject = ['$q', '$http'];

    function trackerService($q,$http){
        var self=this;
        self.get=getVehicles;
        console.log("Came here");
        function getVehicles(){
            return $http.get('http://localhost:8080/api/vehicles')
                .then(successFn, errorFn);
        }

        function successFn(response){
            return response.data;
        }
        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();