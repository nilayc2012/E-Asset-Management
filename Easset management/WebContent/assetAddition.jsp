
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Asset Addition</title>
<style type="text/css">
<!--
body {
	background-repeat: no-repeat;
	}
.style6 {font-family: Georgia, "Times New Roman", Times, serif; color: #192B43; font-size: 80px;}
#Layer1 {
	position:absolute;
	width:400px;
	height:200px;
	z-index:1;
	left: 144px;
	top: 149px;
	visibility: visible;
}
.style11 {color: #000000; font-size: 24px; }
.style18 {color: #FFFFFF}
.style22 {
	color: #000066;
	font-size: 30px;
}
.style24 {color: #000066; font-size: 30px; font-weight: bold; }
.style25 {font-size: 60px}

-->
</style></head>

<body background="assetadd.jpg">
  <pre class="style6 style18 style25">     		Asset Addition</pre>
  <div class="style6" id="Layer1">
  
  <form action="AdditionServlet">
  <table width="441" height="328" border="6" background="addback.jpg" >
	  <tr>
		<td height="260" >
          	
          	<center>
          	  <span class="style18 style11"><strong><span class="style22">Asset name</span></strong></span>
          	</center>
          	<center><input type="text" name="asset_name" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
			<center>
			  <span class="style24">Asset desc</span>
			</center>
			<center><input type="text" name="asset_desc" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
		  <center>
		  <center>
			  <span class="style24">Asset type</span>
		  </center>
			<center><input type="text" name="asset_type" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
		  
			<center>
			<input type="submit" value="ADD"/>
	 </center>
		</td>
	  </tr>
</table>
</form>
</div>

</body>
<%@page import="javax.servlet.http.*" %>
<%
String data=(String)request.getAttribute("data");
if(data!=null)
{
%><font color="red"><span style="font-size: 20; font-weight: bold"><%=data%></span></font>
<%}%>



