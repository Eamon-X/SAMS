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
	<h1>可开设课程 <a href="courseAdd.jsp">添加可开设课程</a></h1>
	<table>
                <tr>
                    <th>课程名称</th>
                    <th>课程学时</th>
                    <th>课程学分</th>
                  
                    <th>操作</th>
                    
                </tr>
                <c:forEach items="${courselist}" var="course">
                    <tr>
                        <td>${course.courseName}</td>
                        <td>${course.courseHour}</td>
                        <td>${course.credit}</td>
                      
                        <td><a href="CourseServlet?method=deleteBycourseName&courseName=${course.courseName }">删除</a></td>
                      
                    </tr>
                   
                </c:forEach>
                
            </table>
            
            
     <h1>已安排的课程 <a href="TeachingServlet?method=add">管理课程</a></h1>
        <table>
                <tr>
                    <th>开设课程</th>
                    
                    <th>授课教师</th>
                    <th>授课教师工号</th>
                    <th>操作</th>
                    
                </tr>
                <c:forEach items="${teaching_viewlist}" var="teaching_view">
                    <tr>
                        <td>${teaching_view.courseName}</td>
                        
                        <td>${teaching_view.teacherName}</td>
                        <td>${teaching_view.teacherId}</td>
                        <td><a href="TeachingServlet?method=deleteBycourseNameandteacherId&courseName=${teaching_view.courseName}&teacherId=${teaching_view.teacherId}">删除</a></td>
                      
                    </tr>
                   
                </c:forEach>
                
            </table>
            
</body>
</html>