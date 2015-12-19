<style>
body{background-repeat:no-repeat;}
#Layer1 {
	position:absolute;
	z-index:1;
	left: 118px;
	top: 22px;
	visibility: visible;
}
</style>
<body background="23rd.jpg">
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%ArrayList<Asset> assetList;
assetList=(ArrayList<Asset>)request.getAttribute("assetlist");
%>
<div class="style6" id="Layer1">
<table border="6" background="assettable.jpg">
<tr>
	<th><font color="black"><span style="font-size: 20">Asset ID</span></font></th><th><font color="black"><span style="font-size: 20">Asset Name</span></font></th><th><font color="black"><span style="font-size: 20">Asset Desc</span></font></th><th><font color="black"><span style="font-size: 20">Asset Type</span></font></th>
	<%for(Asset asset:assetList)
	{%>
		<tr>
			<td><font color="#004080"><span style="font-weight: bold"><%=asset.getAssetId() %></span></font></td>
			<td><font color="#004080"><span style="font-weight: bold"><%=asset.getAssetName() %></span></font></td>
			<td><font color="#004080"><span style="font-weight: bold"><%=asset.getAssetDesc() %></span></font></td>
			<td><font color="#004080"><span style="font-weight: bold"><%=asset.getAssetType() %></span></font></td>
		</tr>
	<%}
	%>
</table>
</div>
<br/>
</body>