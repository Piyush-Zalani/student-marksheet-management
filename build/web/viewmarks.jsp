<%-- 
    Document   : viewmarks
    Created on : May 4, 2015, 4:38:36 AM
    Author     : Piyush
--%>

<%@page import="com.college.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="CSS/college.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <%
            BASE64Encoder encoder = new BASE64Encoder();
            List<byte[]> images = (List<byte[]>)request.getAttribute("images");
        %>
         <% for(byte[] image : images) { %>
         
             <%if(image != null) {%>
    <center><img width="600" height="800" src="data:image/jpg;base64,<%=encoder.encode(image)%>"></center>
    <hr><br><br>
             <%}%>
             
             </br>
        <% } %>
        
    </body>
</html>

