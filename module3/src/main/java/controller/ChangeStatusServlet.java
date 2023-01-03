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

@WebServlet(urlPatterns = "/changestatus")
public class ChangeStatusServlet extends HttpServlet {
    AccountService accountService=new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account= accountService.findById(id);
        accountService.changeStatus(account.getUser_status(),id);
        List<Account> accountList = accountService.accountList();
        req.setAttribute("accounts", accountList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/accountlist.jsp");
        dispatcher.forward(req, resp);
    }
}
