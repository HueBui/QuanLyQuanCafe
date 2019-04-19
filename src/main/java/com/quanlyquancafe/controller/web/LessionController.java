package com.quanlyquancafe.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ={"/list-lession","/lession-detail"})
public class LessionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action!=null&&action.equals("list")){
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/lession.jsp");
            rd.forward(request, response);
        }else if(action!=null&& action.equals("detail")) {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/lession-detail.jsp");
        rd.forward(request, response);
        }
        else {

        }
    }
}
