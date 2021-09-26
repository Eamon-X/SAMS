<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tr {
		text-align:center;
	}
</style>
</head>
<body>
	<table>
                <tr>
                    <th>课程名称</th>
                    <th>课程学时</th>
                    <th>课程学分</th>
                    <th>授课老师姓名</th>
                    <th>操作</th>
                    
                </tr>
                <c:forEach items="${list}" var="course_view">
                    <tr>
                        <td>${course_view.courseName}</td>
                        <td>${course_view.courseName}</td>
                        <td>${course_view.courseName}</td>
                        <td>${course_view.courseName}</td>
                        <td><a href="#">删除</a></td>
                      
                    </tr>
                   
                </c:forEach>
                
            </table>
            
            <a href="TeachingServlet?method=add">管理课程</a>
             <a href="index.jsp">返回菜单</a>
	
</body>
</html>