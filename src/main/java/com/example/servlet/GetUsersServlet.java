package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the users from the Warehouse
        Set<User> users = Warehouse.getInstance().getUsers();

        // Set the "users" attribute in the request
        req.setAttribute("users", users);

        // Forward the request to the "/users" page
        req.getRequestDispatcher("src/main/webapp/jsp/users.jsp").forward(req, resp);
    }
}