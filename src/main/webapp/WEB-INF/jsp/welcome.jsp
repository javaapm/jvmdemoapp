<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>eG JVM Monitoring Demo</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<script>
function deadLockFunction() {
  var r = confirm("Deadlock can not be stopped once started, press ok to start!");
  if (r == true) {
	  document.location='/eGJvmDemo/deadlock/start';
  } else {
	  document.location='/eGJvmDemo/list';
  }
}
</script>
<br>
<div class="container">
  <div class="row">
    <div class="col-12">
      <div class="card">
         <div class="card-body text-center">
           <h5 class="card-title m-b-0">${message.heading}</h5>
         </div>
     <div class="table-responsive">
		  <table class="table table-bordered table-hover table-striped">
			<thead class="thead-dark">
			  <tr>
				<th scope="col">S.No</th>
				<th scope="col">Demo Type</th>
				<th scope="col">Status</th>
				<th scope="col">Actions</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td>1</td>
				<td>CPU utilizing threads</td>
				<td><img src="/images/${message.highcpuStatus}.gif"></td>
				<td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.highcpuStartDisabled} onclick="location.href='/eGJvmDemo/cpu/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.highcpuStopDisabled} onclick="location.href='/eGJvmDemo/cpu/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			  <tr>
				<td>2</td>
				<td>CPU utilizing due to GC</td>
				<td><img src="/images/${message.highcpuGcStatus}.gif"></td>
				<td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.highcpuGcStartDisabled} onclick="location.href='/eGJvmDemo/cpugc/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.highcpuGcStopDisabled} onclick="location.href='/eGJvmDemo/cpugc/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			  <tr>
				<td>3</td>
				<td>Blocked threads</td>
				<td><img src="/images/${message.blockedStatus}.gif"></td>
				<td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.blockedStartDisabled} onclick="location.href='/eGJvmDemo/blocked/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.blockedStopDisabled} onclick="location.href='/eGJvmDemo/blocked/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			  <tr>
				<td>4</td>
				<td>Waiting threads</td>
				<td><img src="/images/${message.waitedStatus}.gif"></td>
				<td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.waitedStartDisabled} onclick="location.href='/eGJvmDemo/waited/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.waitedStopDisabled} onclick="location.href='/eGJvmDemo/waited/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			  <tr>
				<td>5</td>
				<td>Deadlock threads</td>
				<td><img src="/images/${message.deadlockStatus}.gif"></td>
				 <td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.deadlockStartDisabled} onclick="deadLockFunction()">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" disabled onclick="location.href='/eGJvmDemo/deadlock/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			   <tr>
				<td>6</td>
				<td>Memory leak</td>
				<td><img src="/images/${message.memoryLeakStatus}.gif"></td>
				 <td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.memoryLeakStartDisabled} onclick="location.href='/eGJvmDemo/mleak/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.memoryLeakStopDisabled} onclick="location.href='/eGJvmDemo/mleak/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			  <tr>
				<td>7</td>
				<td>Embedded datasource</td>
				<td><img src="/images/${message.dataSourceStatus}.gif"></td>
				 <td>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.dataSourceStartDisabled} onclick="location.href='/eGJvmDemo/dataSource/start'">
				  <span class="glyphicon glyphicon-stop"></span> Start</button>
				  <button type="button" class="btn btn-secondary btn-sm" ${message.dataSourceStopDisabled} onclick="location.href='/eGJvmDemo/dataSource/stop'">
				  <span class="glyphicon glyphicon-stop"></span> Stop</button>
				</td>
			  </tr>
			</tbody>
		  </table>
		  </div>
       </div>
    </div>
  </div>
</div>
</body>
</html>