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
import java.util.List;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    AccountService accountService=new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = accountService.findById(id);
        req.setAttribute("toan",account);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/edit.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("user_id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        accountService.edit(new Account(id,email,password,first_name,last_name,phonenumber,address));
        List<Account> accountList = accountService.accountList();
        req.setAttribute("accounts", accountList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/accountlist.jsp");
        dispatcher.forward(req, resp);
    }
}