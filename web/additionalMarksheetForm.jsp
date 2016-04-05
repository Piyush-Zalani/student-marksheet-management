<%
    String name =(String)session.getAttribute("username");
    if(name==null)
               {
        response.sendRedirect("login.jsp");
    }
    long v=session.getCreationTime();
    
    java.util.Date dt=new java.util.Date(v);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SMS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <link href="CSS/addstudent.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="border">
            Add Additional Marksheet for student: <%=request.getParameter("studentName")%>
            
            <form action="AddAdditionalMarksheet" method="post" enctype="multipart/form-data"></br>
                <input type="hidden" name='studentId' value='<%=request.getParameter("studentId")%>' />
                <input type="hidden" name='studentName' value='<%=request.getParameter("studentName")%>' />
                Addtional Marksheet: <input type="file" name="certificate"/>
                <input type="Submit" value="Add" />
            </form>
        </div>
       
    </body>
</html>