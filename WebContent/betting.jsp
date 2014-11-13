<%@include file="header.jsp"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

	<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
    .input-small { width: 90px; } 
    .form-horizontal
    {
    	margin:20px;
    }
	</style>
</head>
	<body>
		<div class="bs-example">
	    <table class="table">
	        <thead>
	            <tr>
	                <th>Row</th>
	                <th>Risk Level</th>
	                <th>Amount</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr class="warning">
	                <td>1</td>
	                <td>Low</td>
	                <td>04/07/2014</td>
	            </tr>
	            <tr class="info">
	                <td>2</td>
	                <td>Medium</td>
	                <td>01/07/2014</td>
	            </tr>
	            <tr class="success">
	                <td>3</td>
	                <td>High</td>
	                <td>05/07/2014</td>
	            </tr>
	            <tr class="warning">
	                <td>4</td>
	                <td>Low</td>
	                <td>03/07/2014</td>
	            </tr>
	            <tr class="success">
	                <td>5</td>
	                <td>High</td>
	                <td>06/07/2014</td>
	            </tr>
	        </tbody>
	    </table>
      	<a href="#" class="btn btn-lg btn-primary" data-toggle="modal" data-target="#basicModal">Place New Bet</a>


		<!-- modal-->
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
		            <h4 class="modal-title" id="myModalLabel">Place Bet</h4>
		            </div>
		            <form class="form-horizontal">
					  <div class="control-group">
					    <div class="controls form-inline">
					        <label for="inputKey">Risk Level</label>
					      	<select class="form-control input-small">
							  <option value="low">Low</option>
							  <option value="medium">Medium</option>
							  <option value="high">High</option>
							</select>
					    </div>
					  </div>
					  <br>
					  <div class="control-group">
					    <div class="controls form-inline">
					        <label for="inputKey">Amount</label>
					      	<input type="text" name="amount" id="betting_amount" class="form-control  input-small" placeholder="Amount" tabindex="4">
					    </div>
					  </div>
					</form>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		                <button type="button" class="btn btn-primary">Place Bet</button>
		        </div>
		    </div>
		  </div>
		</div> 
	</div>
	</body>
</html>