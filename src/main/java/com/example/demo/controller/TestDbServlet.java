package com.example.demo.controller;

import com.example.demo.repository.DatabaseConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testDbServlet", value = "/test-db")
public class TestDbServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        boolean isConnected = DatabaseConnection.testConnection();
        
        out.println("<html><body>");
        if (isConnected) {
            out.println("<h2>Database connection successful!</h2>");
        } else {
            out.println("<h2>Database connection failed!</h2>");
        }
        out.println("</body></html>");
    }
}