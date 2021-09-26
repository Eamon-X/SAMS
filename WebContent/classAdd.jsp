<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
                .bootstrap-frm {
                    margin: 100px auto;
                    max-width: 500px;
                    background: #FFF;
                    padding: 20px 30px 20px 30px;
                    font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
                    color: #888;
                    text-shadow: 1px 1px 1px #FFF;
                    border: 1px solid #DDD;
                    border-radius: 5px;
                    -webkit-border-radius: 5px;
                    -moz-border-radius: 5px;
                }

                .bootstrap-frm h1 {
                    font: 25px "Helvetica Neue", Helvetica, Arial, sans-serif;
                    padding: 0px 0px 10px 40px;
                    display: block;
                    border-bottom: 1px solid #DADADA;
                    margin: -10px -30px 30px -30px;
                    color: #888;
                }

                .bootstrap-frm h1>span {
                    display: block;
                    font-size: 11px;
                }

                .bootstrap-frm label {
                    display: block;
                    margin: 0px 0px 5px;
                }

                .bootstrap-frm label>span {
                    float: left;
                    width: 20%;
                    text-align: right;
                    padding-right: 10px;
                    margin-top: 10px;
                    color: #333;
                    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                    font-weight: bold;
                }

                .bootstrap-frm input[type="text"] {
                    border: 1px solid #CCC;
                    color: #888;
                    height: 20px;
                    line-height: 15px;
                    margin-bottom: 16px;
                    margin-right: 6px;
                    margin-top: 2px;
                    outline: 0 none;
                    padding: 5px 0px 5px 5px;
                    width: 70%;
                    border-radius: 4px;
                    -webkit-border-radius: 4px;
                    -moz-border-radius: 4px;
                    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
                    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
                    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
                }

               

                .btn {
                    text-align: center;
                }

                .bootstrap-frm .button {
                    background: #FFF;
                    border: 1px solid #CCC;
                    padding: 10px 25px 10px 25px;
                    margin: 0 10px;
                    color: #333;
                    border-radius: 4px;
                }

                .bootstrap-frm .button:hover {
                    color: #333;
                    background-color: #EBEBEB;
                    border-color: #ADADAD;
                }
            </style>
</head>
<body>

	 <form action="ClassroomServlet" method="post" class="bootstrap-frm">
	 <h1>添加班级</h1>
	 <label><span>班级名称：</span><input type="text" name="className"></label>
       <div class="btn"> 
            <input type="hidden" name="method" value="add">
            <input type="submit" class="button" value="添加">
             <input type="reset" class="button" value="重设" />
		</div>
        </form>

</body>
</html>