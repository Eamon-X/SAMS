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
            <h1>???????????? <a href="GradeServlet?method=add">??????????????????</a>
                <form action="Grade_viewServlet" method="post" class="ccs">


                    <input type="checkbox" name="className" value="1">????????????
                    <input type="checkbox" name="courseName" value="1">????????????
                    <input type="checkbox" name="semester" value="1">??????

                    <!-- <input type="hidden" name="method" value="add"> -->
                    <input type="submit" value="??????????????????????????????">

                </form>
                <form action="Student_Semester_GradeServlet" method="post" class="ss">
                    ???????????????<select name="studentId">
                        <c:forEach items="${studentlist}" var="student">

                            <option value="${student.studentId}">${student.studentId}</option>
                        </c:forEach>
                    </select>

                    ?????????<select name="semester">
                        <c:forEach items="${gradelist}" var="grade">

                            <option value="${grade.semester}">${grade.semester}</option>
                        </c:forEach>
                        
                    </select>
                    

                    <input type="submit" value="??????????????????????????????">

                </form>
            </h1>
            <table>
                <tr>
                    <th>????????????</th>
                    <th>????????????</th>

                    <th>??????</th>
                    <th>??????</th>
                    <th>??????</th>

                </tr>
                <c:forEach items="${list}" var="grade">
                    <tr>
                        <td>${grade.studentId}</td>
                        <td>${grade.courseName}</td>

                        <td>${grade.semester}</td>
                        <td>${grade.grade}</td>
                        <td><a
                                href="GradeServlet?method=findBystudentIdandcourseName&studentId=${grade.studentId}&courseName=${grade.courseName}">??????/????????????</a>
                            <a
                                href="GradeServlet?method=deleteBystudentIdandcourseName&studentId=${grade.studentId}&courseName=${grade.courseName}">??????</a>
                        </td>

                    </tr>

                </c:forEach>

            </table>



            <!-- <br>
            <h4>????????????</h4>
            <form action="Grade_viewServlet" method="post">


                <input type="checkbox" name="className" value="1">????????????
                <input type="checkbox" name="courseName" value="1">????????????
                <input type="checkbox" name="semester" value="1">?????? -->

            <!-- <input type="hidden" name="method" value="add"> -->
            <!-- <input type="submit" value="??????">

            </form>
            <h4>???????????????</h4>
            <form action="Student_Semester_GradeServlet" method="post">
            ???????????????<select name="studentId">
             <c:forEach items="${studentlist}" var="student">
                	
                  <option value="${student.studentId}">${student.studentId}</option>
            </c:forEach>
            </select>
             <br>
            ?????????<select name="semester">
             <c:forEach items="${gradelist}" var="grade">
                	
                  <option value="${grade.semester}">${grade.semester}</option>
            </c:forEach>
            </select>
            <br>
            <input type="submit" value="??????">

        </form>  -->

        </body>

        </html>