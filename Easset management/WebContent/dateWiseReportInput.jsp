<style type="text/css">
<!--

#Layer1 {
	position:absolute;
	width:400px;
	height:200px;
	z-index:1;
	left: 151px;
	top: 172px;
	visibility: visible;
}
.style8 {
	color: #FFFFFF;
	font-weight: bold;
}
.style9 {color: #FFFFFF}
</style>
<body background="Technology.jpg">
<%String choice=request.getParameter("choice");
%>
<%if(choice.equals("day"))
{%><div class="style6" id="Layer1">
<form action="ReportServlet">
<table border="6">
<tr><td>
<span class="style7 style9" style="font-weight: bold">Enter date(Ex: 14-oct-12)</span>
<select name="day" size="1">
<%for(int i=1;i<=31;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select>
<select name="month" size="1">
<option value="jan">jan</option><option value="feb">feb</option><option value="mar">mar</option><option value="apr">apr</option><option value="may">may</option><option value="jun">jun</option><option value="jul">jul</option><option value="aug">aug</option><option value="sep">sep</option><option value="oct">oct</option><option value="nov">nov</option><option value="dec">dec</option>
</select>
<select name="year" size="1">
<%for(int i=1;i<=12;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select></td></tr> 
<tr><td><input type="submit" name="name" value="Generate for a day"/></td></tr>
</table>
</form>
</div>
<%}

if(choice.equals("month"))
{%><div class="style6" id="Layer1">
<form action="ReportServlet">
<span class="style7 style9" style="font-weight: bold">Enter month(Ex: oct)</span><select name="month" size="1">
<option value="jan">jan</option>
<option value="feb">feb</option>
<option value="mar">mar</option>
<option value="apr">apr</option>
<option value="may">may</option>
<option value="jun">jun</option>
<option value="jul">jul</option>
<option value="aug">aug</option>
<option value="sep">sep</option>
<option value="oct">oct</option>
<option value="nov">nov</option>
<option value="dec">dec</option>
</select>
<input type="submit" name="name" value="Generate for a month"/>
</form>
</div>
<%}
if(choice.equals("period"))
{%><div class="style6" id="Layer1">
<form action="ReportServlet">
<table border="6">
<tr><td>
<span class="style7 style9" style="font-weight: bold">Enter from date(Ex: 14-oct-12)</span>
<select name="day1" size="1">
<%for(int i=1;i<=31;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select>
<select name="month1" size="1">
<option value="jan">jan</option><option value="feb">feb</option><option value="mar">mar</option><option value="apr">apr</option><option value="may">may</option><option value="jun">jun</option><option value="jul">jul</option><option value="aug">aug</option><option value="sep">sep</option><option value="oct">oct</option><option value="nov">nov</option><option value="dec">dec</option>
</select>
<select name="year1" size="1">
<%for(int i=2000;i<=2012;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select></td></tr>
<tr><td> 
<span class="style7 style9" style="font-weight: bold">Enter to date(Ex: 14-oct-12)</span>
<select name="day2" size="1">
<%for(int i=1;i<=31;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select>
<select name="month2" size="1">
<option value="jan">jan</option><option value="feb">feb</option><option value="mar">mar</option><option value="apr">apr</option><option value="may">may</option><option value="jun">jun</option><option value="jul">jul</option><option value="aug">aug</option><option value="sep">sep</option><option value="oct">oct</option><option value="nov">nov</option><option value="dec">dec</option>
</select>
<select name="year2" size="1">
<%for(int i=2001;i<=2012;i++)
{%>
<option value="<%=i %>"><%=i %></option>
<%} %>
</select></td></tr>  
<tr><td><input type="submit" name="name" value="Generate for a period"/></td></tr>
</table>
</form>
</div>
<%}%>
<form action="dateWiseReportChoice.jsp"><input type="submit" value="Back to Previous Page"/></form>
<p>&nbsp;</p>
