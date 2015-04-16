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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.StatusModel;
import model.LibaryModel;
import model.StoryMoel;

/**
 *
 * @author NamIT
 */
public class StatusController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        StatusModel model;
        StoryMoel sModel;
        RequestDispatcher rd;
        try (PrintWriter out = response.getWriter()) {     
            if (action.equals("UPDATE")) {
                model = new StatusModel();
                int code = Integer.parseInt(request.getParameter("updateCode"));
                boolean bon = Boolean.valueOf(request.getParameter("updateBON"));
                String name = request.getParameter("name");
                HttpSession session = request.getSession(false);
                if (model.updateStatus(code, bon)) {
                    sModel = new StoryMoel();
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
                    String s = formatter.format(date);
                    if(sModel.AddStory(s,name, code)){
                        rd = request.getRequestDispatcher("update");
                        request.setAttribute("name", name);
                        rd.forward(request, response);
                    }

                }else{
                    rd = request.getRequestDispatcher("/error.jsp?ms=AddU");
                    rd.forward(request, response);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
