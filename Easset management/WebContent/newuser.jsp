<%@page import="javax.servlet.http.*" %>
<head>
<title>User Registration</title>
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
	left: 270px;
	top: 155px;
	visibility: visible;
}
.style11 {color: #000000; font-size: 24px; }
.style13 {
	color: #FFFF99;
	font-size: 16px;
	font-weight: bold;
}
.style15 {color: #000000; font-size: 14px; }
.style16 {
	font-size: 24px;
	font-weight: bold;
	color: #FFFFFF;
}
.style18 {color: #FFFFFF}
.style19 {
	color: #FFFFFF;
	font-size: 30px;
	font-weight: bold;
}
.style22 {
	color: #FFFFFF;
	font-size: 30px;
}
.style24 {color: #FFFFFF; font-weight: bold; }

-->
</style></head>

<body background="it-15.jpg">
  <pre class="style6 style18">          User Registration</pre>
    <%
String data=(String)request.getAttribute("data");
if(data!=null)
{
%><font color="red"><span style="color: red; font-size: 20; font-weight: bold"><%=data%></span></font>
<%}%>
  <div class="style6" id="Layer1">

  <form action="RegServlet">
  <table width="441" height="328" border="6" background="IT.jpg" >
	  <tr>
		<td height="260" >
          	
          	<center>
          	  <span class="style18 style11"><strong><span class="style22">Enter Username</span></strong></span>
          	</center>
          	<center><input type="text" name="username" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
			<center>
			  <span class="style19">Enter Password</span>
			</center>
			<center><input type="password" name="password" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
		  <center>
		  <center>
			  <span class="style19">Confirm Password</span>
			</center>
			<center><input type="password" name="password1" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
		  <center>
		    <span class="style16">User Type:</span>
		  </center>
			<center><input type="radio" name="usertype" value="admin" /><span class="style13 style18">Admin</span>
			<input type="radio" name="usertype" value="borrower" /><span class="style15"><span class="style24">Borrower</span></span><br/>
			<input type="submit" value="Register"/>
	 </center>
		</td>
	  </tr>
</table>
</form>
</div>
<br/>
<form action="index.jsp"><input type="submit" value="Go Back To Log In" /></form> 
</body>