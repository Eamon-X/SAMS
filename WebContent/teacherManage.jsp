<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
        
         a {
        	display:inline-block;
        	
        	height:30px;
        	line-height:30px;
        	text-decoration: none;
        	text-align:center;
            background: #FFF;
            border: 1px solid #CCC;
            padding: 0px 10px;
            margin-left:30px;
            font-size:14px;
            font-weight:400;
            color: #333;
            border-radius: 4px;
        }
        
         tr td a {
        margin:0px 5px;
        }

        a:hover {
            color: #333;
            background-color: #EBEBEB;
            border-color: #ADADAD;
        }
    </style>
</head>
<body>
	<h1>教师管理   <a href="teacherAdd.jsp">增加教师</a></h1>
	<table>
                <tr>
                    <th>教师姓名</th>
                    <th>教师性别</th>
                    <th>教师工号</th>
                    <th>操作</th>
                    
                </tr>
                <c:forEach items="${list}" var="teacher">
                    <tr>
                        <td>${teacher.teacherName}</td>
                        <td>${teacher.teacherSex}</td>
                        <td>${teacher.teacherId}</td>
                        <td>
                            <a href="TeacherServlet?method=deleteByteacherId&teacherId=${teacher.teacherId}">删除</a>
                        </td>
                       
                      
                    </tr>
                   
                </c:forEach>
                
            </table>
            
	
</body>
</html>