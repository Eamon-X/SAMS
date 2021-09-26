<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h1>分类查看成绩详细信息</h1>
<table>
                <tr>
                    <th>班级名称</th>
                    <th>课程名称</th>
                    <th>学期</th>
                    <th>平均分</th>
                    <th>最高分</th>
                    <th>最低分</th>
                    <th>及格率</th>
                    
                </tr>
                <c:forEach items="${list}" var="grade_view">
                    <tr>
                   		<td>${grade_view.className}</td>
                        <td>${grade_view.courseName}</td>
                        <td>${grade_view.semester}</td>
                        <td>${grade_view.avg}</td>
                        <td>${grade_view.max}</td>
                        <td>${grade_view.min}</td>
                        <td>${grade_view.pass}</td>
                                                         
                    </tr>
                   
                </c:forEach>
                
            </table>
            
</body>
</html>