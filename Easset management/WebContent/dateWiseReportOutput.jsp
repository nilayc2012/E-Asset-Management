<style type="text/css">
<!--

#Layer1 {
	position:absolute;
	width:400px;
	height:200px;
	z-index:1;
	left: 200px;
	top: 120px;
	visibility: visible;
}
.style7 {color: #FFFFFF}
</style>
<body background="973.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%String date=(String)request.getAttribute("date");
if(date.equals("day"))
{	
	ArrayList<Transaction> transList;
	transList=(ArrayList<Transaction>)request.getAttribute("bydaylist");
	%>
<table border="3">
<tr>
	<th bgcolor="#FFFFFF">Username</th>
	<th bgcolor="#FFFFFF">Asset ID</th>
	<th bgcolor="#FFFFFF">Asset Name</th>
	<th bgcolor="#FFFFFF">Asset Type</th>
	<th bgcolor="#FFFFFF">Issue Date</th>
	<th bgcolor="#FFFFFF">Returning Date</th>
	<th bgcolor="#FFFFFF">Returned Date</th>
	<th bgcolor="#FFFFFF">Fine</th>
	<%for(Transaction trans:transList)
	{%>
  <tr>
			<td><span class="style7" style="font-weight: bold"><%=trans.getUsername() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetId() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetName() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetType() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getIssueDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturningDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturnedDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getFine() %></span></td>
		</tr>
	<%}
	%>
</table>
<%}%>

<%if(date.equals("month"))
{
ArrayList<Transaction> transList;
	transList=(ArrayList<Transaction>)request.getAttribute("bymonthlist");
	%>
<table border="3">
<tr>
	<th bgcolor="#FFFFFF">Username</th><th bgcolor="#FFFFFF">Asset ID</th><th bgcolor="#FFFFFF">Asset Name</th><th bgcolor="#FFFFFF">Asset Type</th><th bgcolor="#FFFFFF">Issue Date</th><th bgcolor="#FFFFFF">Returning Date</th><th bgcolor="#FFFFFF">Returned Date</th><th bgcolor="#FFFFFF">Fine</th>
	<%for(Transaction trans:transList)
	{%>
  <tr>
			<td><span class="style7" style="font-weight: bold"><%=trans.getUsername() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetId() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetName() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetType() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getIssueDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturningDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturnedDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getFine() %></span></td>
		</tr>
	<%}
	%>
</table>
<%}%>

<%if(date.equals("period"))
{
ArrayList<Transaction> transList;
	transList=(ArrayList<Transaction>)request.getAttribute("byperiodlist");
	%>
<table border="3">
<tr>
	<th bgcolor="#FFFFFF">Username</th><th bgcolor="#FFFFFF">Asset ID</th><th bgcolor="#FFFFFF">Asset Name</th><th bgcolor="#FFFFFF">Asset Type</th><th bgcolor="#FFFFFF">Issue Date</th><th bgcolor="#FFFFFF">Returning Date</th><th bgcolor="#FFFFFF">Returned Date</th><th bgcolor="#FFFFFF">Fine</th>
	<%for(Transaction trans:transList)
	{%>
  <tr>
			<td><span class="style7" style="font-weight: bold"><%=trans.getUsername() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetId() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetName() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getAssetType() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getIssueDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturningDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getReturnedDate() %></span></td>
			<td><span class="style7" style="font-weight: bold"><%=trans.getFine() %></span></td>
		</tr>
	<%}
	%>
</table>
<%}%>
</body>