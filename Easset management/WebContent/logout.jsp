<%@page import="javax.servlet.http.*"%>
<%HttpSession hs=request.getSession(false);
hs.invalidate();
request.setAttribute("data","You are Logged Out");
%>
<jsp:forward page="index.jsp"></jsp:forward>