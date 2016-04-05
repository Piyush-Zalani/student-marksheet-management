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
        <link href="CSS/sms.css" rel="stylesheet" type="text/css"/>
    </head>
    <body >
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
            
            <h1>Select Collage To Add/View Student Details</h1>
            
            <div class="container_form">
                
                <form action="college.jsp">
                    <table cellpadding="15" border="0" align="center">
                     <tr>
                         
                         <td><b>Country</b></td>
                         
                         
                         
                         <td>
                             <select name="country">
                                 <option value="India">India</option>
                                 <%--   <option value="Pakistan"></option> --%>
                             </select>
                         </td>
                     </tr>
                    
                    <br><br>
                    
                    <tr>
                        
                        <td>
                            <b>State</b>
                        </td>
   
                        <td>  
                            <select name="State">
                                <option value="Madhya Pradesh">Madhya Pradesh</option>
                                <option value="Maharastra">Maharastra</option>
                            </select>
                        </td>
                    
                    </tr>
                    
                    <br><br>
                    
                    <tr>
                        
                        <td>
                            <b>City</b>
                        </td>
                        
                        <td>
                            <select name="City">
                                <option value="Indore">Indore</option>
                                <option value="Bhopal">Bhopal</option>
                                <option value="Pune">Pune</option>
                                <option value="Mumbai">Mumbai</option>
                            </select>
                        </td>
                        
                    </tr>
                    
                    <br><br>
                    
                    <tr>
                        
                        <td>
                            <b>Univercity</b>
                        </td>
                        
                        <td>
                            <select name="Select Univercity">
                                <option value="R.G.P.V.">R.G.P.V.</option>
                                <option value="D.A.V.V.">D.A.V.V.</option>
                            </select>
                        </td>
                    
                    </tr>
                    
                    <br><br>
                    
                    <tr>
                        
                        <td>
                            <b>College</b>
                        </td>
                        
                        <td>
                            <select name="Select College">
                                <option value="Rishiraj Institute Of Technology">Rishiraj Institute Of Technology</option>
                                <option value="Laxhmi Narayan Institute Of Technology">Laxhmi Narayan Institute Of Technology</option>
                                <option value="Holkar Institue Of Management And Science">Holkar Institue Of Management And Science</option>
                                <option value="Prestige Institue Of Technology">Prestige Institue Of Technology</option>
                            </select>
                        </td>
                    
                    </tr>
                    
                    <br><br>
                    
                    <tr>
                        
                        <td>
                            <input type="submit" value="Enter">
                        </td>
                        
                    </tr>
                    
                    </table>
                
                </form>
           
            
            </div>
        
        
        </div>
        
    </body>
</html>
