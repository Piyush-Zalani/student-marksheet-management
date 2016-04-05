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
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link href="CSS/addstudent.css" rel="stylesheet" type="text/css"/>
            
            <script>
$(document).ready(function(){
    $("#ct form table button").click(function(){
        $.post("Addstud.java", function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
                </script>
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
            
            <h1>Rishiraj Institue Of Technology</h1>
               <div id="ct">
                   
                  
                    <h1 color="blue" ;align="center"> Please fill Student registration Form </h1>       
                    <hr>  
                    <form action="Addstud" method="post" enctype="multipart/form-data"><br>
                        
                        <h1> Student Details</h1> <hr>
                        <table cellpadding="10" border="0" align="center">
                           
                            
                            <tr>

                                  <th>First Name</th>
                                  <td><input type="text" required="required" name="fn" size="20">*</td>

                                    <th> Last Name</th>
                                    <td> <input type="text" required="required" name="ln" size="20">* </td>
                            </tr>
                           
                            <tr>
                                <th>Father Name</th>
                                <td> <input type="text" name="father" size="20" required="required">* </td>
                                
                                <th>Enrollment No.</th>
                                <td> <input type="text"  name="enroll" size="20">* </td>
                                
                                
                            </tr>
                            
                             <tr>
                                 <th>D.O.B</th>
                                <td>
                                    <input type="text" name="dob" required="required" size="20"/>* 
                                </td>

                                  <th>Branch</th>
                                  <td><input type="text" required="required" name="branch" size="20"/>*</td>
                             </tr>
                             
                             <tr>
                                  <th>Year</th>
                                  <td><input type="text" name="year" required="required" size="20"/>*</td>
                            <th>Semester</th>
                            <td> <input type="text" name="sem" size="20" required="required"/>* </td>
                             </tr>
                             
                             <tr>

                                  <th>Address</th>
                                  <td><textarea name="address" required="required" size="20"></textarea>*</td>

                                  <th>Mobile No.</th>
                                  <td><input type="text" name="mobile" size="20" required="required">*</td>
                            </tr>
                             <tr>
                                 <th> Email Id</th>
                                    <td> <input type="text" name="email" size="20" required="required"/>* </td>
                                 
                                 <th>Profile Pic</th>
                                  <td><input type="file" name="photo" size="20" />*</td>
                             </tr>
                                 <tr>
                                     <td></td>
                                         <td></td>
                                             <td></td>
                                 </tr>
                                      
                             <tr>
                                    <td>First Sem</td>
                                    <td><input type="file" name="first"/></td>
                                
                                
                                    <td>Second Sem</td>
                                    <td><input type="file" name="second"/></td>
                                </tr>
                                <tr>
                                    <td>Third Sem</td>
                                    <td><input type="file" name="third"/></td>
                                
                                    <td>Four Sem </td>
                                    <td><input type="file" name="four"/></td>           
                                
                                    
                                </tr>
                                <tr>
                                    <td>Five Sem</td>
                                    <td><input type="file" name="five"/></td>
                                
                                
                                    <td>Six Sem</td>
                                    <td><input type="file" name="six"/></td>
                                </tr>
                                <tr>
                                    <td>Seven Sem</td>
                                    <td><input type="file" name="seven"/></td>
                                
                                
                                    <td>Eight Sem</td>
                                    <td><input type="file" name="eight"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td align="center"><input type="submit" value="submit"/></td>
                                    
                                    <td><input type="reset" value="Reset"/></td>
                                        
                                        
                                </tr>
                        </table>
                    </form>
                        <hr>
                    <form action="ViewStudent" method="post" name="view student">
                        <table align="center">
                        <tr>
                            <td><button> <input type="submit" value="view Student"/></button> </td>
                        </tr>
                        </table>
                    </form>
                        <hr>
                       
                </div>
       </div>
       
    </body>
</html>