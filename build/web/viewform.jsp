
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
           <link href="CSS/addstudent.css" rel="stylesheet" type="text/css"/>
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
                
            </div>
            
            <h1>Rishiraj Institue Of Technology</h1>
               <div id="ct">
                   
                  <hr>
                    <h1 color="blue" ; align="center"> Student Profile </h1>       
                  <hr>
         <%
            BASE64Encoder encoder = new BASE64Encoder();
            List<Student> students = (List<Student>)request.getAttribute("students");
        %>
         <% for(Student student : students) { %>
         <table cellpadding="10" border="0" align="center">
         <tr>
         
             <td><img width="150" height="200" src="data:image/jpg;base64,<%=encoder.encode(student.getPhoto())%>"</td>
             
        <td><h3>Student Name : <%=student.getFirstName()%> <%=student.getLastName()%></h3></td><br/>
         <tr> <td><h3>Father Name : <%=student.getFatherName()%></h3></td></tr>
        <tr><td>
                     <h3>Address : <%=student.getAddress()%></h3>
            </td></tr>
             </tr>
             
             <tr>
                 <td>
                     <h3>Enrollment Number :<%=student.getEnrollmentNo()%></h3>
                 </td>
             </tr>
             <tr>
                 <td>
                     <h3>Date Of Birth : <%=student.getDob()%></h3>
                 </td>
             </tr>
       <tr>
                 <td>
                     <h3>Branch : <%=student.getBranch()%></h3>
                     <h3>Year : <%=student.getYear()%></h3>
                     <h3>Semester : <%=student.getSem()%></h3>
                 </td>
             </tr>
       <tr>
                 <td>
                     <h3>Mobile Number : +91<%=student.getMobile()%></h3>
                     
                 </td>
             </tr>
       <tr>
                 <td>
                     <h3>Email : <a href="http://www.gmail.com"><%=student.getEmail()%></a></h3>
                 </td>
             </tr>
       
       
             
            <tr> <td>
                 <button text-align="left"> <a href="ViewMarks?id=<%=student.getId()%>">View marks</a> </button>
         </td> </tr>
         </table>
        <% } %>
               </div>
        </div>
    </body>
</html>
