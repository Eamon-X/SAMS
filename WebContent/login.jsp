<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>欢迎登录</title>
        <style>
            body {
                padding: 0;
                margin: 0;
                background: url(login_img/bg.jpg);
                background-size: cover;

                font-family: sans-serif;
            }

            .loginbox {
                width: 320px;
                height: 420px;
                background: rgba(0, 0, 0, .5);
                color: #fff;
                top: 50%;
                left: 50%;
                position: absolute;
                
                transform: translate(-50%, -50%);
                box-sizing: border-box;
                padding: 70px 30px;

            }

            .user {
                width: 100px;
                height: 100px;
                border-radius: 50%;
                position: absolute;
                top: -50px;
                left: calc(50% - 50px);
            }

            h1 {
                margin: 0;
                padding: 0;
                text-align: center;
                font-size: 22px;
            }

            .loginbox p {
                margin: 0;
                padding: 0;
                font-weight: bold;
            }

            .loginbox input {
                width: 100%;
                margin-bottom: 20px;

            }

            .loginbox input[type="text"],
            input[type="password"] {
                border: none;
                border-bottom: 1px solid #FFF;
                background: transparent;
                outline: none;
                height: 40px;
                color: #FFF;
                font-size: 16px;

            }


            .loginbox input[type="submit"] {
                border: none;
                outline: none;
                height: 40px;
                background: #fb2525;
                color: #fff;
                font-size: 18px;
                border-radius: 20px;
            }

            .loginbox input[type="submit"]:hover {
                cursor: pointer;
                background: #ffc107;
                color: #000;
            }

            .loginbox span {
                display: block;
                height: 30px;
                color: red;
                text-align:center;
            }
        </style>
    </head>

    <body>
        <%String errorMsg=(String)request.getAttribute("errorMsg"); if(errorMsg==null) { errorMsg="" ; } %>
            <div class="loginbox">
                <img src="login_img/user.png" alt="" class="user">
                <h1>欢迎登录成绩管理系统</h1><br>
                <form action="LoginServlet" method="POST">
                    <p>用户名</p>
                    <input type="text" name="account" placeholder="请输入用户名" autocomplete="off">
                    <p>密码</p>
                    <input type="password" name="password" placeholder="请输入密码">
                    <span class="errorMsg">
                        <%=errorMsg %>
                    </span>
                    <input type="submit" value="登录">
                </form>



            </div>
    </body>

    </html>