<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h2>Error</h2>
    <p>${message}</p>
    <a href="${pageContext.request.contextPath}/students">Back to Student List</a>

</body>
</html>