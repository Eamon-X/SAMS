<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>
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
        <body>
            <h1>学生管理 <a href="StudentServlet?method=add">添加学生</a></h1>
            <table>
                <tr>
                    <th>学生学号</th>
                    <th>学生姓名</th>
                    <th>性别</th>
                    <th>班级</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${studentlist}" var="student">
                    <tr>
                        <td>${student.studentId}</td>
                        <td>${student.studentName}</td>
                        <td>${student.sex}</td>
                        <td>${student.className}</td>
                        <td>
                            <a href="StudentServlet?method=deleteBystudentId&studentId=${student.studentId}">删除</a>
                            <a href="StudentServlet?method=findBystudentId&studentId=${student.studentId}">修改</a>

                        </td>
                    </tr>

                </c:forEach>

            </table>

            



        </body>

        </html>