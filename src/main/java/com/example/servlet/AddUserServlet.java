package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the "/add" page
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the first name and last name parameters from the request
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        // Create a new User object
        User user = new User(firstName, lastName);

        // Save the user in the Warehouse
        Warehouse.getInstance().addUser(user);

        // Set the "user" attribute in the request
        req.setAttribute("user", user);

        // Forward the request back to the "/add" page
        req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
    }
}