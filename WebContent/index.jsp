<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>学生成绩管理系统</title>
          <style>
        body, html {
            margin: 0;
            padding: 0;
            height:100%;
        }

        .header {
            position: relative;
            display: flex;
            align-items: center;

            width: 100%;
            height: 80px;
            line-height: 80px;
            background: #393e44;
            color: #fff;

        }

        .header img {
            width: 60px;
            height: 60px;
            margin: 0 5px;

        }

        .header .title {
            padding: 0 10px;

            font-size: 30px;

            color: white;
            font-weight: 700;
        }
        
        .header .welcome {
        	position: absolute;
            right: 150px;
            color: #fff;
            font-size: 16px;

        }

        .header a {
            position: absolute;
            right: 50px;
            text-decoration: none;
            color: #fff;
        }

        .header a:hover {
            color: lightblue;
            text-decoration: underline;
        }

        .nav {
         	position: relative;
            float: left;
            width: 10%;
            min-height:calc( 100% - 80px );
            height:auto;
            background: #ececec;
        }

        .page {
            float: right;
            width: 90%;
            
            min-height:calc( 100% - 80px );
            height:calc( 100% - 80px );
            
            
        }
        
        .page iframe{
            
            
            height: 100%;
            
            
        }

        ul {
            margin: 0;
            padding: 0;
        }

        ul li {

            list-style: none;

            text-align: center;
            border-bottom: 1px solid #000;

        }

        ul li a {
            display: block;
            height: 80px;
            line-height: 80px;
            text-decoration: none;

            color: black;
        }

        ul li a:hover {

            background-color: lightblue;

        }

       

        .nav .about {
            position: absolute;
            bottom: 0;
            font-size: 12px;
            text-align: left;
        }
    </style>
    </head>

    <body>
        <div class="header">
        	
            <img src="login_img/user.png" alt="">
            <span class="title">学生成绩管理系统</span>
            <span class="welcome">当前用户为：${account}</span>
            <a href="login.jsp">退出登录</a>

        </div>
        <div class="nav">
            <ul>
                <li><a href="StudentServlet" target="page">学生管理</a></li>
                <li><a href="ClassroomServlet" target="page">班级管理</a></li>
                <li><a href="GradeServlet" target="page">成绩管理</a></li>
                <li><a href="CourseServlet" target="page">教学管理</a></li>
                <li><a href="TeacherServlet" target="page">教师管理</a></li>
            </ul>
            <div class="about">
                    Author: EamonX <br>
                    Update: 2021年7月16日 <br>
                    Version: v1.0
                </div>
        </div>

        <div class="page">
			 <iframe name="page" width=100% height=100% marginwidth=0 marginheight=0 frameborder="no" border="0"  src="welcome.jsp" ></iframe> 

        </div>



    </body>

    </html>