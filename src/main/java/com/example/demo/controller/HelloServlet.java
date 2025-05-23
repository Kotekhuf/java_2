package com.example.demo.controller;

import java.io.*;

import com.example.demo.DIContainer;
import com.example.demo.service.UserService;
import com.example.demo.service.entity.UserRegisterData;
import com.example.demo.view.model.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private UserService userService;

    public void init() {
        message = "Hello World!";
        userService = DIContainer.instance.getUserService();
    }

    // разобраться с аннотациями
    // doPost(string login, string password)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        var result = userService.addUser(new UserRegisterData());
        if(result)
        {
            var viewmodel = new User("name");
            // redirect to jsp

            request.setAttribute("user", viewmodel);
            //forward
        }



        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}