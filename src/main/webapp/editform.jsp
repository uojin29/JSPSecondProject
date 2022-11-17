<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.MemberDAO, com.example.bean.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	MemberDAO boardDAO = new MemberDAO();
	String id=request.getParameter("id");	
	MemberVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
<tr><td>UserName:</td><td><input type="text" name="uname" value="<%= u.getUname()%>"/></td></tr>
<tr><td>UserID:</td><td><input type="text" name="uid" value="<%= u.getUid()%>" /></td></tr>
	<tr><td>Password:</td><td><input type="text" name="password" value="<%= u.getPassword()%>"/></td></tr>
	<tr><td>Photo:</td><td><input type="file" name="photo" value="<%= u.getPhoto()%>/></td></tr>
	<tr><td>PhoneNumber:</td><td><input type="text" name="pnum" value="<%= u.getPnum()%>" /></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>