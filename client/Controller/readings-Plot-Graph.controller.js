












(function(){
    'use strict';
    angular.module('tracker')
        .controller('readingsPlotGraphController',readingsPlotGraphController);
    readingsPlotGraphController.$inject=['trackerService','$routeParams','$scope'];

    function readingsPlotGraphController(trackerService, $routeParams, $scope){
         var plotGraphVm = this;
      
        
         $scope.type =["engineRpm", "engineHp", "speed","fuelVolume"];
        
         
        
        $scope.setSelected = function(){
          
         trackService($scope.selectedName,$scope.selectedTime);
        }
        
        function getValues(plots,selected,time) {
          var st=time*60*1000;
          var d = new Date();
           var n = d.getTime();
           var t= n-st;
          
           var tempArr=[];
           var timeArr = [];
          for(var obj in plots){
            
            if(plots[obj].timestamp>=t ){
              
          
            tempArr.push(plots[obj][selected]);
            
            }
           
          }
           $scope.myJson = {
          type : 'line',
          series : [
                    { values : tempArr } 
         
          ]
        };
        }
       
        
    function trackService(selected,time){
   
        trackerService.getPlot($routeParams.vin)
        .then(function(plots){
          plotGraphVm.plots=plots;
          
             getValues(plots,selected,time);
          
          
         
          
        },function(error){
          console.log(error);
        });
    }
       
       
        
     
    }
})();