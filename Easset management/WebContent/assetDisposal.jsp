<%@page import="javax.servlet.http.*" %>
<%
String data=(String)request.getAttribute("data");
if(data!=null)
{
%><font color="red"><span style="font-size: 20; font-weight: bold"><%=data%></span></font>
<%}%>
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
<%@page import="java.util.*"%>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.beans.*"%>
<%ArrayList<Asset> assetList;
HttpSession hts=request.getSession();
assetList=(ArrayList<Asset>)hts.getAttribute("assetlist");
%>
<body background="496.jpg">
<pre> </pre>
<div class="style6" id="Layer1">
<form action="DisposalServlet">
 <pre>       <table border="3" background="assettable.jpg">
    <tr>
      <th><span style="color: navy; font-size: 20">Asset ID</span></th>
      <th><span style="color: navy; font-size: 20">Asset Name</span></th>
      <th><span style="color: navy; font-size: 20">Asset Desc</span></th>
      <th><span style="color: navy; font-size: 20">Asset Type</span></th>
      <th><span style="color: navy; font-size: 20">Choice</span></th>
      <%for(Asset asset:assetList)
	{%>
    <tr>
      <td><span style="font-weight: bold"><%=asset.getAssetId() %></span></td>
      <td><span style="font-weight: bold"><%=asset.getAssetName() %></span></td>
      <td><span style="font-weight: bold"><%=asset.getAssetDesc() %></span></td>
      <td><span style="font-weight: bold"><%=asset.getAssetType() %></span></td>
      <td><input type="radio" name="choice" value="<%=asset.getAssetId() %>"/></td>
    </tr>
    <%}
	%>
    <tr>
      <td><input type="submit" name="data" value="Delete"/></td>
    </tr>
  </table></pre>
</form></div>

</body>