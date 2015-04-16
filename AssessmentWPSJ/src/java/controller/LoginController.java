/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Libary;
import entity.Story;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginModel;
import model.LibaryModel;
import model.StatusModel;
import model.StoryMoel;

/**
 *
 * @author NamIT
 */
public class LoginController extends HttpServlet {

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
            LoginModel lm = new LoginModel();
            //
            HttpSession session;
            RequestDispatcher rd;
            LibaryModel al1;
            ArrayList<Libary> al;
            StoryMoel sModel;
            ArrayList<Story> sL;
            //
            String name = request.getParameter("user");
            String pass = request.getParameter("pass");
            System.out.println(name+":"+pass);
            if (lm.checklogin(name, pass)) {
                sModel = new StoryMoel();
                al1 = new LibaryModel();
                al = al1.getSreach("");
                sL = sModel.getALL(name);
                session = request.getSession(true);
                rd = request.getRequestDispatcher("/Home.jsp?satus=not");
                session.setAttribute("login", name);
                request.setAttribute("Book",al);
                request.setAttribute("Story",sL);
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
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

}
