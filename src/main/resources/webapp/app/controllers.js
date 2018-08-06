(function(angular) {
  var AppController = function($scope,$http) {
    
    $scope.save=function() { 
    	console.log("fileupload");
        var fd = new FormData();
        var files = document.querySelector('input[type=file]').files;
        var file2 = document.querySelector('input[name="file2"]').files[0];
        var file3 = document.querySelector('input[name="file3"]').files[0];
       // var filesArray=new Array();
       // angular.forEach(files, function(data){
        	console.log(files);
        	console.log(file2);
        	console.log(file3);
       // 	filesArray.push(data);
        //	});
        fd.append('file1', files); 
        fd.append('file2', file2);
        fd.append('file3', file3);
        fd.append('test', true); 
         $http({
              method:'POST',
              url:"/file/upload",
              data: fd,
              headers: {'Content-Type':undefined},
              transformRequest: angular.identity 
               }).then( function ( response )
                       {
                       //上传成功的操作
                       alert("uplaod success");
                       }, function errorCallback(response) {
                   		// 请求失败执行代码
                       }); 

     };
    $scope.filedown=function (url, name) {
          window.location.href = "/file/download";
    };
  };
  
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));