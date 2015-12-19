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
.style8 {color: #00FF66}
</style>
<body background="390.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%ArrayList<Transaction> transList;
transList=(ArrayList<Transaction>)request.getAttribute("translist");
%>
<table border="6">
<tr>
	<th class="style6">Username</th><th class="style6">Asset ID</th><th class="style6">Asset Name</th><th class="style6">Asset Type</th><th class="style6">Issue Date</th><th class="style6">Returning Date</th>
	<%for(Transaction trans:transList)
	{%>
  <tr>
			<td class="style8"><span style="font-weight: bold"><%=trans.getUsername() %></span></td>
			<td class="style8"><span style="font-weight: bold"><%=trans.getAssetId() %></span></td>
			<td class="style8"><span style="font-weight: bold"><%=trans.getAssetName() %></span></td>
			<td class="style8"><span style="font-weight: bold"><%=trans.getAssetType() %></span></td>
			<td class="style8"><span style="font-weight: bold"><%=trans.getIssueDate() %></span></td>
			<td class="style8"><span style="font-weight: bold"><%=trans.getReturningDate() %></span></td>
  </tr>
	<%}
	%>
</table>
</body>