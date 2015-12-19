<style type="text/css">
<!--
body {
	background-repeat: no-repeat;
	}
	
#Layer1 {
	position:absolute;
	width:400px;
	height:200px;
	z-index:1;
	left: 296px;
	top: 159px;
	visibility: visible;
}
.style6 {color: #00FFFF}
.style7 {color: #FF0000}
.style8 {color: #FFFFFF}
</style>
<body background="Info8.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%@page import="javax.servlet.http.*" %>
<%
HttpSession hts=request.getSession();
ArrayList<Asset> asstList=(ArrayList<Asset>)hts.getAttribute("asset");
if(asstList!=null)
{
%>
<form action="AllocDeallocServlet">
<table border="6" background="8.jpg">
<tr>
	<th><span style="color: brown; font-size: 20">Asset ID</span></th><th><span style="color: brown; font-size: 20">Asset Name</span></th><th><span style="color: brown; font-size: 20">Asset Desc</span></th><th><span style="color: brown; font-size: 20">Asset Type</span></th><th><span style="color: brown; font-size: 20">Choice</span></th>

<%for(Asset asset:asstList)
	{%>	
	<tr>
			<td><span style="font-weight: bold"><%=asset.getAssetId() %></span></td>
			<td><span style="font-weight: bold"><%=asset.getAssetName() %></span></td>
			<td><span style="font-weight: bold"><%=asset.getAssetDesc() %></span></td>
			<td><span style="font-weight: bold"><%=asset.getAssetType() %></span></td>
			<td><input type="radio" name="choice" value="<%=asset.getAssetId() %>"/></td>
	</tr><%} %>
<tr><td><input type="submit" name="data" value="Return"/></td></tr>
</table>
</form>
<div id="Layer1">
<%}
String data=(String)request.getAttribute("data");
if(data!=null)
{
%><font color="red"><span style="font-size: 20; font-weight: bold"><%=data%></span></font>
<%}
%></div>
<br/>
</body>