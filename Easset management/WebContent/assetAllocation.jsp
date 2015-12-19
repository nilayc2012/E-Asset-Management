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
	left: 200px;
	top: 120px;
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
<%ArrayList<Asset> assetList;
HttpSession hts=request.getSession();
assetList=(ArrayList<Asset>)hts.getAttribute("assetlist");
%><div class="style6" id="Layer1">
<form action="AllocDeallocServlet">
<table border="6" background="8.jpg">
<tr>
	<th><span class="style7" style="color: brown; font-size: 20">Asset ID</span></th>
	<th><span class="style7" style="color: brown; font-size: 20">Asset Name</span></th>
	<th><span class="style7" style="color: brown; font-size: 20">Asset Desc</span></th>
	<th><span class="style7" style="color: brown; font-size: 20">Asset Type</span></th>
	<th><span class="style7" style="color: brown; font-size: 20">Choice</span></th>
	<%for(Asset asset:assetList)
	{%>
	  <tr>
			<td><span class="style8" style="color: darkblue; font-weight: bold"><%=asset.getAssetId() %></span></td>
			<td><span class="style8" style="color: darkblue; font-weight: bold"><%=asset.getAssetName() %></span></td>
			<td><span class="style8" style="color: darkblue; font-weight: bold"><%=asset.getAssetDesc() %></span></td>
			<td><span class="style8" style="color: darkblue; font-weight: bold"><%=asset.getAssetType() %></span></td>
			<td><input type="radio" name="choice" value="<%=asset.getAssetId() %>" style="color: darkblue"/></td>
	  </tr>
	<%}
	%>
<tr><td><input type="submit" name="data" value="Apply"/></td></tr>
</table>
</form>
</div>
<%@page import="javax.servlet.http.*" %>
<%
String data=(String)request.getAttribute("data");
if(data!=null)
{
%><font color="red"><span style="font-size: 20; font-weight: bold"><%=data%></span></font>
<%if(data.equals("Asset already issued")) 
{%>
<form action="AllocDeallocServlet"><input type="submit" name="data" value="Reserve"/></form>
<%}
}%><br/>
</body>