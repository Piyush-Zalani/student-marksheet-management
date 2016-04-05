/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.college;

import com.college.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Piyush
 */
@WebServlet(name = "ViewMarks", urlPatterns = {"/ViewMarks"})
public class ViewMarks extends HttpServlet {

    
    private Connection con;
    private Statement stmt;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            stmt = con.createStatement();

            if (id != null) {
                String sql = "select id, first, second, third, four, five, six, seven, eight from student where id=" + id;
                ResultSet rs = stmt.executeQuery(sql);

                List<byte[]> images = new ArrayList<byte[]>();
                rs.next();
                
                //Retrieve by column name
                 byte[] first = rs.getBytes("first");
                 byte[] second = rs.getBytes("second");
                 byte[] third = rs.getBytes("third");
                 byte[] four = rs.getBytes("four");
                 byte[] five = rs.getBytes("five");
                 byte[] six = rs.getBytes("six");
                 byte[] seven = rs.getBytes("seven");
                 byte[] eight = rs.getBytes("eight");

                 images.add(first);
                 images.add(second);
                 images.add(third);
                 images.add(four);
                 images.add(five);
                 images.add(six);
                 images.add(seven);
                 images.add(eight);

                rs.close();
                        
                sql = "select certificate from certificate where studentId = " + id;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    byte[] certificate = rs.getBytes("certificate");
                    images.add(certificate);
                }
                rs.close();

                request.setAttribute("images", images);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewmarks.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            out.println(ex.getMessage());
            ex.printStackTrace();
            Logger.getLogger(ViewDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
