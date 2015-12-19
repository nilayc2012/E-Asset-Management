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
.style4 {color: #000099}
.style6 {color: #FF0000; }
.style7 {color: #FFFFFF}
</style>
<body background="textures.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%ArrayList<Transaction> transList;
transList=(ArrayList<Transaction>)request.getAttribute("translist");
int total=0;
%>
<table border="3" bgcolor="aliceblue">
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
			<td class="style4"><span style="font-weight: bold"><%=trans.getUsername() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getAssetId() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getAssetName() %></span></td>
	<td class="style4"><span style="font-weight: bold"><%=trans.getAssetType() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getIssueDate() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getReturningDate() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getReturnedDate() %></span></td>
			<td class="style4"><span style="font-weight: bold"><%=trans.getFine() %></span></td>
  </tr>
	<%total=total+trans.getFine();
	}
	%>
	<tr><th class="style6">Total Due Amount</th>
	<td class="style4"><span style="font-weight: bold"><%=total%></span></td></tr>
</table>
</body>