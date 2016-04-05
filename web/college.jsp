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
        <link href="CSS/college.css" rel="stylesheet" type="text/css"/>
            
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
    
        <script>
            $(function(){
        $('form').submit(function(event){
            event.preventDefault();
            window.location = $('input[type=radio]:checked').val();
                                        });
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
                        <div class="topnavlinks">
    <a id="menulinktutorials" class="largetopnav" href="javascript:void(0);">TUTORIALS<span class="caret"></span></a>
    <a id="menulinkreferences" class="largetopnav" href="javascript:void(0);">REFERENCES<span class="caret"></span></a>
    <a id="menulinkexamples" class="largetopnav" href="javascript:void(0);">EXAMPLES<span class="caret"></span></a>
    <!--<a  class='largetopnav' href='/forum/default.asp'title='W3Schools Forum'>FORUM</a>-->
    <a id="menulinktranslate" href='javascript:void(0);' class='largetopnav' title='Translate W3Schools'><span class="glyphicons glyphicons-globe-af" style="line-height:71px;font-size:20px;"></span></a>
    <a id="menulinksearch" href='javascript:void(0);' class='largetopnav' title='Search W3Schools'><span class="glyphicons glyphicons-search" style="line-height:71px;font-size:20px;"></span></a>    
  </div>
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
                    <form name="form" method="post" action="">
                        <table align="center" cellpadding="10" border="0">
                            <tr>
                        <td><input type="radio"  id="AddStudent" name="url" value="addstudent.jsp" /> Add Student</td>
                    
                        <td><input type="radio" id="ViewStudent" name="url" value="ViewStudent" />View Student</td>
                        </tr>
                            <tr>
                                <td><input type="submit" name="submit" value="submit"></td>
                        </tr>
                        </table>
                    </form>    
                       
                      
                </div>
       </div>
       
    </body>
</html>
