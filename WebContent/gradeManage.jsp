<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.js"></script>
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


                a,
                input[type="submit"] {
                    display: inline-block;
                    height: 30px;
                    line-height: 30px;
                    text-decoration: none;
                    text-align: center;
                    background: #FFF;
                    border: 1px solid #CCC;
                    padding: 0px 10px;
                    margin-left: 30px;
                    font-size: 14px;
                    font-weight: 400;
                    color: #333;
                    border-radius: 4px;
                }

                tr td a,
                input[type="submit"] {
                    margin: 0px 5px;
                }

                a:hover {
                    color: #333;
                    background-color: #EBEBEB;
                    border-color: #ADADAD;
                }

                .ccs,
                .ss {
                    display: inline-block;
                    margin-left: 100px;
                    font-size: 14px;
                    font-weight: 400;
                }
            </style>
        </head>

        <body>
        <script>
    $(function () {

        $("select option").each(function() {
            text = $(this).text();
            if($("select option:contains("+text+")").length > 1)
                $("select option:contains("+text+"):gt(0)").remove();
        });

        console.log(text);
    })
</script>
            <h1>成绩管理 <a href="GradeServlet?method=add">学生选课入口</a>
                <form action="Grade_viewServlet" method="post" class="ccs">


                    <input type="checkbox" name="className" value="1">班级名称
                    <input type="checkbox" name="courseName" value="1">课程名称
                    <input type="checkbox" name="semester" value="1">学期

                    <!-- <input type="hidden" name="method" value="add"> -->
                    <input type="submit" value="分类查看成绩详细信息">

                </form>
                <form action="Student_Semester_GradeServlet" method="post" class="ss">
                    学生学号：<select name="studentId">
                        <c:forEach items="${studentlist}" var="student">

                            <option value="${student.studentId}">${student.studentId}</option>
                        </c:forEach>
                    </select>

                    学期：<select name="semester">
                        <c:forEach items="${gradelist}" var="grade">

                            <option value="${grade.semester}">${grade.semester}</option>
                        </c:forEach>
                        
                    </select>
                    

                    <input type="submit" value="查看学生学期详细信息">

                </form>
            </h1>
            <table>
                <tr>
                    <th>学生学号</th>
                    <th>课程名称</th>

                    <th>学期</th>
                    <th>成绩</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${list}" var="grade">
                    <tr>
                        <td>${grade.studentId}</td>
                        <td>${grade.courseName}</td>

                        <td>${grade.semester}</td>
                        <td>${grade.grade}</td>
                        <td><a
                                href="GradeServlet?method=findBystudentIdandcourseName&studentId=${grade.studentId}&courseName=${grade.courseName}">录入/修改成绩</a>
                            <a
                                href="GradeServlet?method=deleteBystudentIdandcourseName&studentId=${grade.studentId}&courseName=${grade.courseName}">删除</a>
                        </td>

                    </tr>

                </c:forEach>

            </table>



            <!-- <br>
            <h4>分级查看</h4>
            <form action="Grade_viewServlet" method="post">


                <input type="checkbox" name="className" value="1">班级名称
                <input type="checkbox" name="courseName" value="1">课程名称
                <input type="checkbox" name="semester" value="1">学期 -->

            <!-- <input type="hidden" name="method" value="add"> -->
            <!-- <input type="submit" value="提交">

            </form>
            <h4>按学生查看</h4>
            <form action="Student_Semester_GradeServlet" method="post">
            学生学号：<select name="studentId">
             <c:forEach items="${studentlist}" var="student">
                	
                  <option value="${student.studentId}">${student.studentId}</option>
            </c:forEach>
            </select>
             <br>
            学期：<select name="semester">
             <c:forEach items="${gradelist}" var="grade">
                	
                  <option value="${grade.semester}">${grade.semester}</option>
            </c:forEach>
            </select>
            <br>
            <input type="submit" value="提交">

        </form>  -->

        </body>

        </html>