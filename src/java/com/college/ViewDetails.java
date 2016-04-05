/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.college;

import com.college.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * @author ankit
 */
@WebServlet(name = "ViewDetails", urlPatterns = {"/ViewDetails"})
public class ViewDetails extends HttpServlet {

    private Connection con;
    private Statement stmt;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            stmt = con.createStatement();

            if (id != null) {
                String sql = "select id, firstname, lastname, fathername, enrollmentNo, dob, year, branch, sem, address, mobile, email, photo from student where id=" + id;
                ResultSet rs = stmt.executeQuery(sql);

                List<Student> students = new ArrayList<Student>();
                while (rs.next()) {
                    //Retrieve by column name
                    
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String fathername = rs.getString("fathername");
                    String enrollmentNo = rs.getString("enrollmentNo");
                    String dob = rs.getString("dob");
                    String year = rs.getString("year");
                    String branch = rs.getString("branch");
                    String sem = rs.getString("sem");
                    String address = rs.getString("address");
                    String mobile = rs.getString("mobile");
                    String email = rs.getString("email");

                    byte[] photo = rs.getBytes("photo");
                    
                    Student student = new Student();
                    
                    student.setId(Integer.parseInt(id));
                    student.setFirstName(firstname);
                    student.setFatherName(fathername);
                    student.setLastName(lastname);
                    student.setEnrollmentNo(enrollmentNo);
                    student.setDob(dob);
                    student.setYear(year);
                    student.setBranch(branch);
                    student.setSem(sem);
                    student.setAddress(address);
                    student.setMobile(mobile);
                    student.setEmail(email);
                    student.setPhoto(photo);
                    
                    students.add(student);
                }
                rs.close();

                request.setAttribute("students", students);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewform.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            out.println(ex.getMessage());
            ex.printStackTrace();
            Logger.getLogger(ViewStudentsList.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
