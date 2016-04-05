/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ankit
 */
public class AddAdditionalMarksheet extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;
    private String studentId;
    private String studentName;

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

        try {

            String certificateName = request.getParameter("certificateName");
           
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            ps = con.prepareStatement("insert into certificate (studentId, certificate) values (?,?)");

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload sfu = new ServletFileUpload(factory);
            List items = sfu.parseRequest(request);

            Iterator iter = items.iterator();
            byte[] certificate = null;
            
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                
                byte[] blobValue = item.get();
                if (blobValue != null && blobValue.length > 0) {
                    String fieldName = item.getFieldName();
                    
                    if (!item.isFormField()) { //This if clause is for images.
                        if ("certificate".equalsIgnoreCase(fieldName)) {
                            certificate = blobValue;
                        }
                        
                        // you can add more clauses here.
                    } else { // This else clause if for other fields.
                        String fieldValue = new String(blobValue);
                        if (item.getFieldName() != null) {        
                            if ("studentId".equalsIgnoreCase(fieldName)) {
                                studentId = fieldValue;
                            } else if ("studentName".equalsIgnoreCase(fieldName)) {
                                studentName = fieldValue;
                            }
                            
                            // add more fields here.
                        }
                    }
                }
            }

            ps.setString(1, studentId);
            ps.setBytes(2, certificate);
            
            int i = ps.executeUpdate();
            if (i != 0) {
                out.println("Success");
                response.sendRedirect("additionalMarksheetForm.jsp?studentName=" + studentName + "&studentId=" + studentId);
                out.println("Success");
            } else {
                out.println("Failed");
            }
        } catch (Exception ex) {
            out.println(ex);
        } finally {
            out.close();
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
