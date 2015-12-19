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
<body background="Web_Page.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%ArrayList<Transaction> transList;
transList=(ArrayList<Transaction>)request.getAttribute("translist");
%>
<table border="6" background="pagebackground.jpg">
<tr>
	<th class="style6"><span style="font-size: 15">Username</span></th>
	<th class="style6"><span style="font-size: 15">Asset ID</span></th>
	<th class="style6"><span style="font-size: 15">Asset Name</span></th>
	<th class="style6"><span style="font-size: 15">Asset Type</span></th>
	<th class="style6"><span style="font-size: 15">Issue Date</span></th>
	<th class="style6"><span style="font-size: 15">Returning Date</span></th>
	<th class="style6"><span style="font-size: 15">Returned Date</span></th>
	<th><span class="style6" style="font-size: 15">Fine</span></th>
	<%for(Transaction trans:transList)
	{%>
  <tr>
			<td><span class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getUsername() %></span></td>
<td><span class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getAssetId() %></span></td>
<td><span class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getAssetName() %></span></td>
<td><span class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getAssetType() %></span></td>
<td><span class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getIssueDate() %></span></td>
	  <td class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getReturningDate() %></td>
	  <td class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getReturnedDate() %></td>
	  <td class="style4" style="color: cornsilk; font-weight: bold"><%=trans.getFine() %></td>
  </tr>
	<%}
	%>
</table>
</body>