<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.MemberDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.example.bean.MemberVO" />
<jsp:setProperty property="*" name="u"/>

<%
	MemberDAO boardDAO = new MemberDAO();
	int i = boardDAO.insertBoard(u);
	String msg = "데이터 추가 성공 !";
	if(i == 0) msg = "[에러] 데이터 추가 실패";
%>

<script>
	alert('<%=msg%>');
	location.href='posts.jsp';
</script>