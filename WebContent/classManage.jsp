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

        a:hover {
            color: #333;
            background-color: #EBEBEB;
            border-color: #ADADAD;
        }
        
        tr td a {
        margin:0px 5px;
        }
    </style>
</head>
<body>
			<h1>班级管理 <a href="classAdd.jsp">添加班级</a></h1>
            <table>
                <tr>
                    <th>班级名称</th>
                    <th>班级人数</th>
                    <th>操作</th>
                    
                </tr>
                <c:forEach items="${list}" var="classroom">
                    <tr>
                        <td>${classroom.className}</td>
                        <td>${classroom.studentNum}</td>
                       	<td>
                            <a href="ClassroomServlet?method=deleteByclassName&className=${classroom.className}">删除</a>
                            
 
                       	</td>
                      
                    </tr>
                   
                </c:forEach>
                
            </table>
            
            
            

</body>
</html>