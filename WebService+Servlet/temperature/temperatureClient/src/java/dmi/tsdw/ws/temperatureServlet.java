/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmi.tsdw.ws;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author longo
 */
@WebServlet(name = "temperatureServlet", urlPatterns = {"/temperatureServlet"})
public class temperatureServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet temperatureServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet temperatureServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            /*                         
            if("POST".equals(request.getMethod())) {
                String ct = request.getParameter("city");
                Double tmp = getTemperature(ct);
                if(tmp==0.0) out.println("<h1>Città non trovata nel dataset</h1>");
                else out.println("<h1>Temperatura a " + ct + ": " + tmp + " gradi</h1>");
            }
            else {
                String allCity = getAllTemperature();
                out.println(allCity);
            }
            
             */
            String isPressed = request.getParameter("name");
            
            out.println(isPressed);
            
            if(isPressed.compareTo("nameCity")==0) {
                String ct = request.getParameter("city");
                Double tmp = getTemperature(ct);
                if(tmp==0.0) out.println("<h1>Città non trovata nel dataset</h1>");
                else out.println("<h1>Temperatura a " + ct + ": " + tmp + " gradi</h1>");
            }
            if(isPressed.compareTo("allCity")==0) {
                String allCity = getAllTemperature();
                out.println(allCity);
            }
            
           
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

    private static Double getTemperature(java.lang.String city) {
        dmi.tsdw.TemperatureWS_Service service = new dmi.tsdw.TemperatureWS_Service();
        dmi.tsdw.TemperatureWS port = service.getTemperatureWSPort();
        return port.getTemperature(city);
    }

    private static String getAllTemperature() {
        dmi.tsdw.TemperatureWS_Service service = new dmi.tsdw.TemperatureWS_Service();
        dmi.tsdw.TemperatureWS port = service.getTemperatureWSPort();
        return port.getAllTemperature();
    }

}
