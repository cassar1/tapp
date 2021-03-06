<%@include file="header.jsp"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Betting</title>

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
		<h2>Bets</h2>
		<div id = "message">
			${model.message}
		</div>
	    <table id = "bets_table" class="table">
	        <thead>
	            <tr>
	                <th>Row</th>
	                <th>Risk Level</th>
	                <th>Amount</th>
	            </tr>
	        </thead>
	        <tbody class="bets_table">
	            <c:forEach var="bets" items="${model.bet}" varStatus="rowCounter">
					<c:choose>
					      <c:when test="${bets.risk_level == 1}">
						      <tr class="warning">
			                	<td>${rowCounter.count}</td>
			                	<td>Low</td>
			                	<td><c:out value="${bets.amount}"></c:out></td>
		            		  </tr>
					      </c:when>
					      <c:when test="${bets.risk_level == 2}">
						      <tr class="info">
			                	<td>${rowCounter.count}</td>
			                	<td>Medium</td>
			                	<td><c:out value="${bets.amount}"></c:out></td>
		            		  </tr>
					      </c:when>
					      <c:otherwise>
					      	  <tr class="success">
			                	<td>${rowCounter.count}</td>
			                	<td>High</td>
			                	<td><c:out value="${bets.amount}"></c:out></td>
		            		  </tr>
					      </c:otherwise>
					</c:choose>              	
	            </c:forEach>

	        </tbody>
	    </table>
      	<a href="#" id="place_bet" class="btn btn-lg btn-primary" data-toggle="modal" data-target="#basicModal">Place New Bet</a>


		<!-- modal-->
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
		            <h4 class="modal-title" id="myModalLabel">Place Bet</h4>
		            </div>
		            <form class="form-horizontal" action = "betting.html" method = "POST">
					  <div class="control-group">
					    <div class="controls form-inline">
					        <label for="inputKey">Risk Level</label>
					      	<select name="risk_level" class="form-control input-small">
							  <option value="1">Low</option>
							  <option value="2">Medium</option>
							  <option value="3">High</option>
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
					  <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		                <button type="submit" id = "place_bet" class="btn btn-primary">Place Bet</button>
		        </div>
					</form>
		            
		    </div>
		  </div>
		</div> 
	</div>
	</body>
</html>
