<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>${student.id == 0 ? 'Add Student' : 'Edit Student'}</h2>
    <form:form modelAttribute="student"  action="${student.id == 0 ? 'add' : 'edit'}">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <form:input path="name"/>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <form:input path="email"/>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                    <a href="${pageContext.request.contextPath}/students">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>

