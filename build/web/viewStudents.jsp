<%-- 
    Document   : studentsList.jsp
    Created on : May 2, 2015, 2:50:42 AM
    Author     : Piyush
--%>
<%
    String name =(String)session.getAttribute("username");
    if(name==null)
               {
        response.sendRedirect("login.jsp");
    }
    long v=session.getCreationTime();
    
    java.util.Date dt=new java.util.Date(v);
%>

<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="com.college.model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
        <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
        <link href="CSS/college.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
          <div id="border">
            <div id="head_ct">Student <span>MarkSheet</span> System</div>
            <div id="menu" >
                <ul>
                    <li><a href="">About </a></li>
                    <li><a href="">Admin</a></li>
                    <li><a href="">Careers</a></li>
                    <li><a href="">Student</a></li>
                    <li><a href="">Contact </a></li>
                </ul>
            </div>
            
            <marquee bgcolor="#6495ED" onmouseover="this.stop();" onmouseout="this.start();" scrollamount="4">
                <font size="+2"> Welcome To Student Mark-Sheet System </font>
            </marquee>
            
            <div class="sign_out">
                <a href="logout.jsp">Sign Out</a><br/>
                  <font size="+2" align="left">Welcome : <%=name%> </font>
            </div>
            
            <h1>Rishiraj Institue Of Technology</h1>

                <div id="ct">
                    <hr>
                    <h1 align="center">List of Students</h1>
                        <hr>
        <table style ="width:100%">
           
            <tr>
                
                <th>Student Name</th>
                <th>Enrollment No.</th>
                <th>Year</th>
                <th>Branch</th>
                    
                 <th>Sem</th>
                     
            </tr>
                    <%
            BASE64Encoder encoder = new BASE64Encoder();
            List<Student> students = (List<Student>)request.getAttribute("students");
        %>

            <% for(Student student : students) { %>
                <tr>
                    
                    <td><%=student.getFirstName()%> <%=student.getLastName()%></td>
                    <td><%=student.getEnrollmentNo()%></td>
                    <td><%=student.getYear()%></td>
                    <td><%=student.getBranch() %></td>
                        <td><%=student.getSem() %></td>
                    <%--     <td><img width="100" height="100" src="data:image/jpg;base64,<%=encoder.encode(student.getPhoto())%>"></td> --%>
                    <%--               <td><img width="100" height="100" src="data:image/jpg;base64,<%=encoder.encode(student.getM1())%>"></td> --%>
                    <td><a href="ViewDetails?id=<%=student.getId()%>"> View Detail </a></td>
                    <td><a href="Delete?id=<%=student.getId()%>"> Delete </a> </td>    
                        <td><a href="additionalMarksheetForm.jsp?studentId=<%=student.getId()%>&studentName=<%=student.getFirstName()%> <%=student.getLastName()%>"> Add Additional Certificate/Marsheets </a></td>
                </tr> 
                
            <% } %>
        </table>
                </div>
          </div>
    </body>
</html>
