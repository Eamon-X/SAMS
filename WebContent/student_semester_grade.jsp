<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看学生学期详细信息</title>
<style type="text/css">
 h1 {
            padding: 10px;
            font-size: 20px;
            border-bottom: 3px solid #5bb7bd;
        }
table {
            width: 100%;
            table-layout: fixed;
            text-align: center;
            border-collapse: collapse;
        }

        tr {
            height: 60px;
            border-bottom: 1px solid #e7e7e7;
        }

        tr:hover {
            background: #f5f5f5;
        }
</style>
</head>
<body>
<h1>查看学生学期详细信息</h1>
	 <table>
                <tr>
                    <th>学生学号</th>
                    <th>学生姓名</th>
                    <th>学期</th>
                    <th>平均成绩</th>

                </tr>
                <c:forEach items="${list}" var="avg_grade">
                    <tr>
                        <td>${avg_grade.studentId}</td>
                        <td>${avg_grade.studentName}</td>
                        <td>${avg_grade.semester}</td>
                        <td>${avg_grade.avg}</td>
                        
                    </tr>

                </c:forEach>

            </table>
	
</body>
</html>