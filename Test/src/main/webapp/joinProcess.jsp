<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.tech.w01.MemberDAO"%>
<%
request.setCharacterEncoding("utf-8");

out.println("<h1>result</h1>");
%>
<%--빈 사용 --%>
<jsp:useBean id="mb" class="com.tech.w01.MemberBean" /> 
<%--빈에 데이터 저장 --%>
<jsp:setProperty property="*" name="mb" />
<%
MemberDAO dao = MemberDAO.getInstance();
dao.joinMember(mb);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	window.onload = function() {
		document.getElementById('btn').addEventListener('click', func);
	};

	function func() {
		history.go(-1);
	}
</script>
</head>
<body>
	<h2><%=mb.getId()%></h2>
	<h2><%=mb.getPw()%></h2>
	<br>
	<br>
	<hr>
	<input type="button" id="btn" value="뒤로가기">
</body>
</html>