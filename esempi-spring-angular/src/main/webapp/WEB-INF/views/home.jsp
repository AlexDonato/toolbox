<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<style>
	#div1 {width:350px;height:70px;padding:10px;border:1px solid #aaaaaa;}
	#drag1 {width:350px;height:70px;}
	</style>
	<script>
	function allowDrop(ev) {
	    ev.preventDefault();
	}
	
	function drag(ev) {
	    ev.dataTransfer.setData("text", ev.target.id);
	}
	
	function drop(ev) {
	    ev.preventDefault();
	    var data = ev.dataTransfer.getData("text");
	    ev.target.appendChild(document.getElementById(data));
	}
	</script>	
	<c:set var="static_resource_path" value="${pageContext.request.contextPath}"></c:set>
	<script src="${static_resource_path}/resources/js/angular.js"></script>
</head>
<body data-ng-app="myApp" >
Context path <c:out value="${static_resource_path}"></c:out>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:url var="url" value="/post"/>
<c:out value="${scommessaForm.scommessaId}"></c:out>
<form:form action="${url}" method="post" modelAttribute="scommessaForm">
	<form:errors path="*" />
	<label>Pilota</label>
	<form:input path="scommessaId"/>
	<form:errors path="scommessaId" />
	<form:input path="pilota"/>
	<form:errors path="pilota" />
	<form:button>INVIA</form:button>
</form:form>
<div data-ng-controller="myCtrl">

First Name: <input type="text" data-ng-model="firstName"><br>
Last Name: <input type="text" data-ng-model="lastName"><br>
<br>
Full Name: {{fullName()}}

</div>
<div data-ng-controller="customersCtrl"> 

<ul>
  <li data-ng-repeat="x in names">
    {{ x.Name + ', ' + x.Country }}
  </li>
</ul>

</div>
<script>
var app = angular.module('myApp', []);
	
app.controller('myCtrl', function($scope) {
   	$scope.firstName= "John";
   	$scope.lastName= "Doe";
   	$scope.fullName = function() {
   		var fullName = $scope.firstName + " " + $scope.lastName;
   		console.log ('>' + fullName);
       	return fullName;
   	}    
});

app.controller('customersCtrl', function($scope, $http) {
    $http.get("http://www.w3schools.com/angular/customers.php")
   		.success(function(response) {$scope.names = response.records;});
});

</script>



<script>
var app = angular.module('myAppPippo', []);

</script>

<p>Drag the W3Schools image into the rectangle:</p>

<div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
<br>
<img id="drag1" src="${pageContext.request.contextPath}/resources/imgs/hamilton.jpg" draggable="true" ondragstart="drag(event)">

</body>
</html>
