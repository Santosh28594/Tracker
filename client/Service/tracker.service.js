(function(){
    'use strict';
    var tracker = angular.module('tracker')
        .service('trackerService', trackerService);

    trackerService.$inject = ['$q', '$http'];

    function trackerService($q,$http){
        var self=this;
        self.get=getVehicles;
       self.getByVin=getVehicleByVin;
//        self.getAlert= getAlerts;
        self.getaCount = getalertCount;
        self.getHD=getAlertByVin;
        self.getVt = getTrack;
        self.getPlot = getPlotByVin;
        console.log("Came here");
        
        
        
        function getVehicles(){
            return $http.get('http://localhost:8080/api/vehicles')
                .then(successFn, errorFn);
        }
        
        function getVehicleByVin(vin) {
        return $http.get('http://localhost:8080/api/vehicles/' + vin)
        .then(successFn, errorFn);
    }
        
        
        function getalertCount(){
          return $http.get('http://localhost:8080/api/alertCount')
                .then(successFn, errorFn);
          
        }
        
           function getAlertByVin(vin) {
        return $http.get('http://localhost:8080/api/vehicles/alerts/'+vin)
        .then(successFn, errorFn);
    }
        
         function getTrack(vin){
          return $http.get('http://localhost:8080/api/vehicles/geo/'+ vin)
                .then(successFn, errorFn);
          
        }
          function getPlotByVin(vin){
          return $http.get('http://localhost:8080/api/readings/'+ vin)
                .then(successFn, errorFn);
          
        }
        
        function successFn(response){
          console.log("sucess!!");
            return response.data;
        }
        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();