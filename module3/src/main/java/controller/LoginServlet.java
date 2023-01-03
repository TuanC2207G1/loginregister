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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess = req.getParameter("mess");
        if (mess != null) {
            mess = "Sai tài khoản or mật khẩu";
            req.setAttribute("mess", mess);
        }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
            dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Account account = accountService.checkLogin(email, password);
        if (account != null && account.getRole() == 1) {
            List<Account> accountList = accountService.accountList();
            req.setAttribute("accounts", accountList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/accountlist.jsp");
            dispatcher.forward(req, resp);
        } else if (account != null && account.getRole() == 2) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/products.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login?mess=error");
        }
    }
}
