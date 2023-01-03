package controller;

import model.Account;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/register.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService=new AccountService();
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String first_name=req.getParameter("first_name");
        String last_name=req.getParameter("last_name");
        String phonenumber=req.getParameter("phonenumber");
        String address=req.getParameter("address");
        Account account= new Account(email,password,first_name,last_name,phonenumber,address);
        if (!accountService.registerAccount(account)){
            resp.sendRedirect("/login");
        }
    }
}
