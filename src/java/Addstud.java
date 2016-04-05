
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Addstud extends HttpServlet {

    Connection con;
    PreparedStatement ps;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String fn = request.getParameter("fn");
            String ln = request.getParameter("ln");
            String father = request.getParameter("father");
            String enroll = request.getParameter("enroll");
            String dob = request.getParameter("dob");
            String year = request.getParameter("year");
            String branch = request.getParameter("branch");
            String sem = request.getParameter("sem");
            String address = request.getParameter("address");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            ps = con.prepareStatement("insert into student (firstname, lastname, fathername, enrollmentNo, dob, year, branch, sem, address, mobile, email, photo, first, second, third, four, five, six, seven, eight) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload sfu = new ServletFileUpload(factory);
            List items = sfu.parseRequest(request);

            Iterator iter = items.iterator();
            byte[] b = null;
            byte[] first = null;
            byte[] second = null;
            byte[] third = null;
            byte[] four = null;
            byte[] five = null;
            byte[] six = null;
            byte[] seven = null;
            byte[] eight = null;
            
            
            
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                
                byte[] blobValue = item.get();
                if (blobValue != null && blobValue.length > 0) {
                    String fieldName = item.getFieldName();
                    
                    if (!item.isFormField()) { //This if clause is for images.
                        if ("photo".equalsIgnoreCase(fieldName)) {
                            b = blobValue;
                        }else if ("first".equalsIgnoreCase(fieldName)) {
                            first = blobValue;
                        }else if ("second".equalsIgnoreCase(fieldName)) {
                            second = blobValue;
                        }else if ("third".equalsIgnoreCase(fieldName)) {
                            third = blobValue;
                        }else if ("four".equalsIgnoreCase(fieldName)) {
                            four = blobValue;
                        }else if ("five".equalsIgnoreCase(fieldName)) {
                            five = blobValue;
                        }else if ("six".equalsIgnoreCase(fieldName)) {
                            six = blobValue;
                        }else if ("seven".equalsIgnoreCase(fieldName)) {
                            seven = blobValue;
                        }else if ("eight".equalsIgnoreCase(fieldName)) {
                            eight = blobValue;
                        }
                        
                        // you can add more clauses here.
                    } else { // This else clause if for other fields.
                        String fieldValue = new String(blobValue);
                        if (item.getFieldName() != null) {        
                            if ("fn".equalsIgnoreCase(fieldName)) {
                                fn = fieldValue;
                            } else if ("ln".equalsIgnoreCase(fieldName)) {
                                ln = fieldValue;
                            } else if ("father".equalsIgnoreCase(fieldName)) {
                                father = fieldValue;
                            } else if ("enroll".equalsIgnoreCase(fieldName)) {
                                enroll = fieldValue;
                            } else if ("dob".equalsIgnoreCase(fieldName)) {
                                dob = fieldValue;
                            } else if ("year".equalsIgnoreCase(fieldName)) {
                                year = fieldValue;
                            } else if ("branch".equalsIgnoreCase(fieldName)) {
                                branch = fieldValue;
                            } else if ("sem".equalsIgnoreCase(fieldName)) {
                                sem = fieldValue;
                            } else if ("address".equalsIgnoreCase(fieldName)) {
                                address = fieldValue;
                            } else if ("mobile".equalsIgnoreCase(fieldName)) {
                                mobile = fieldValue;
                            } else if ("email".equalsIgnoreCase(fieldName)) {
                                email = fieldValue;
                            }
                            
                            // add more fields here.
                        }
                    }
                }
            }

            ps.setString(1, fn);
            ps.setString(2, ln);
            ps.setString(3, father);
            ps.setString(4, enroll);
            ps.setString(5, dob);
            ps.setString(6, year);
            ps.setString(7, branch);
            ps.setString(8, sem);
            ps.setString(9, address);
            ps.setString(10, mobile);
            ps.setString(11, email);
            ps.setBytes(12, b);
            ps.setBytes(13, first);
            ps.setBytes(14, second);
            ps.setBytes(15, third);
            ps.setBytes(16, four);
            ps.setBytes(17, five);
            ps.setBytes(18, six);
            ps.setBytes(19, seven);
            ps.setBytes(20, eight);

            
            int i = ps.executeUpdate();
            if (i != 0) {
                out.println("Success");
                
                response.sendRedirect("addstudent.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Addstud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Addstud.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Addstud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Addstud.class.getName()).log(Level.SEVERE, null, ex);
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
