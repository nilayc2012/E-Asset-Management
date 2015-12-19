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
.style3 {color: #99FF33}
.style4 {color: #0000FF}
</style>
<body background="it_support.jpg">
<%@page import="java.util.*"%>
<%ArrayList<String> userTypeList=(ArrayList<String>)request.getAttribute("usertypelist"); %>
<div class="style6" id="Layer1">
<form action="ReportServlet">
<table border="6" background="8.jpg">
<tr><th><span class="style4" style="font-size: 20">Borrower</span></th>
<th><span class="style4" style="font-size: 20">Choice</span></th>
</tr>
<%for(String atype:userTypeList)
{%>
<tr><td><span style="font-weight: bold"><%=atype%></span></td><td><input type="radio" name="choice" value="<%=atype %>"/></td></tr>
<%} %>
<tr><td><input type="submit" name="name" value="Generate by username"/></td></tr>
</table>
</form>
</div>
</body>