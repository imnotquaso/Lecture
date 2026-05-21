package com.wanted.servlet.i_filter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession(false);
//        String existUser = (String)session.getAttribute("loggedInUser");
//
//        session.setAttribute("loggedInUser", existUser);
//
//        RequestDispatcher rd = req.getRequestDispatcher("/i_filter/auth.jsp");
//        rd.forward(req, resp);

        HttpSession session = req.getSession(false);
        String existUser = null;

        if (session != null) {
            existUser = (String) session.getAttribute("loggedInUser");
        }

        req.setAttribute("loggedInUser", (existUser != null) ? existUser : "게스트");

        RequestDispatcher rd = req.getRequestDispatcher("/i_filter/auth.jsp");
        rd.forward(req, resp);

    }
}
