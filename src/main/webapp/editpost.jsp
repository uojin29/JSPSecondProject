<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO"%>
<%@ page import="com.example.common.FileUpload" %>
<%@ page import="com.example.bean.MemberVO" %>

<% request.setCharacterEncoding("utf-8"); %>

<%
	MemberDAO boardDAO = new MemberDAO();
	FileUpload upload = new FileUpload();
	MemberVO u = upload.uploadPhoto(request);

	int i=boardDAO.updateBoard(u);
	response.sendRedirect("posts.jsp");
%>