<%@page import="javax.servlet.http.*" %>
<head>
<title>E-Assets Manager</title>
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
	left: 540px;
	top: 169px;
	visibility: visible;
}
.style11 {color: #000000; font-size: 24px; }
.style13 {color: #000000; font-size: 16px; }
.style15 {color: #000000; font-size: 14px; }
.style16 {
	font-size: 18px;
	font-weight: bold;
}
.style17 {
	color: #3366FF;
	font-size: 70px;
}
.style19 {color: #F2F5FC}
.style20 {color: #1C2D47}

-->
</style></head>

<body background="main.jpg">
<%

HttpSession hs=request.getSession(true);
String data=(String)hs.getAttribute("data");
	String userType=(String)hs.getAttribute("usertype");
	String opr=(String)hs.getAttribute("opr1");%>
	   <%if(data!=null)
{
%><font color="red"><span style="font-size: 20; font-weight: bold"><%=data%></span></font>
<%}%>
	<% if(opr==null)
	{
		response.sendRedirect("ReminderServlet");
	}
	if(userType!=null)
	{
		if(userType.equals("admin"))
		{
			response.sendRedirect("adminLogin.jsp");
		}
		else
		{
			response.sendRedirect("borrowerLogin.jsp");
		}
		
	}
%>
  <pre class="style6 style17">          <span class="style19">E-Assets</span> <span class="style20">Manager</span></pre>

  <div class="style6" id="Layer1">
 
  <form action="LoginServlet">
  <table width="441" height="328" border="6" background="pagebackground.jpg" >
	  </tr>
	  <tr>
		<td height="260" >
          	
          	<center><span class="style11">Username</span></center>
          	<center><input type="text" name="username" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
			<center><span class="style11">Password</span>
			</center>
			<center><input type="password" name="password" width="200" height="30" size="30" style="background-color:#00CCFF"/></center>
		  <center>
		    <span class="style16">User Type:</span>
		  </center>
			<center><input type="radio" name="usertype" value="admin" /><span class="style13">Admin</span>
			<input type="radio" name="usertype" value="borrower" /><span class="style15">Borrower</span><br/>
			<input type="submit" value="Login"/>
	 </center>
		</td>
	  </tr>
	  <tr><td><center> <a href='newuser.jsp' class="style11">New Borrower</a></center></td>
	  </tr>
</table>
</form>
</div>
</body>


