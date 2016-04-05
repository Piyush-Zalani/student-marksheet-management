
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author Anuj Pal
 */
public class CheckUser extends HttpServlet {

     Connection con;
     PreparedStatement ps;
     ResultSet rs;
    
    @Override
    public void init(ServletConfig cfg)
            
    {
       
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        ps=con.prepareStatement("select user_id from user where user_id=? and pswd=?");
        }
        catch(Exception ex){
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String user=request.getParameter("username");//userid
        String pswd=request.getParameter("password");//password

        try
        {
        ps.setString(1, user);
        ps.setString(2, pswd);
        rs=ps.executeQuery();
        if(rs.next())
        {
            String name=rs.getString(1);
            javax.servlet.http.HttpSession session=request.getSession();
            session.setAttribute("username", name);


           response.sendRedirect("SMS.jsp");
       
        }
        else
        {
            out.println("<h1>Invalid User</h1>");
            out.println("<a href=login.jsp>Try-Again</a>");
        }
        }
        catch(Exception ex){out.println("Registration Failed");}
    }
    @Override
    public void destroy()
    {
        try
        {
            con.close();
        }
        catch(Exception ex){}
    }
}  