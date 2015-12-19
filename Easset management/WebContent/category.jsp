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
</style>
<body background="Metallic_color.jpg">
<%@page import="java.util.*"%>
<%ArrayList<String> assetTypeList=(ArrayList<String>)request.getAttribute("assettypelist"); %>
<div class="style6" id="Layer1">
<form action="ReportServlet">
<table border="6" background="list1.jpg">
<tr><th><span style="color: white; font-size: 20">Assets Category</span></th><th><span style="color: white; font-size: 20">Choice</span></th></tr>
<%for(String atype:assetTypeList)
{%>
<tr><td><span style="color: black; font-weight: bold"><%=atype%></span></td><td><input type="radio" name="choice" value="<%=atype %>"/></td></tr>
<%} %>
<tr><td><input type="submit" name="name" value="Generate by Category"/></td></tr>
</table>
</form>
</div>
</body>
<br/>
