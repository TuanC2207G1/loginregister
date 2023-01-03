package service;

import dao.AccountDao;
import model.Account;

import java.util.List;

public class AccountService {
    AccountDao accountDao = new AccountDao();

    public Account checkLogin(String username, String password) {
        return accountDao.checkLogin(username, password);
    }

    public List<Account> accountList() {
        return accountDao.getAll();
    }

    public void deleteAccount(int user_id) {
        accountDao.deleteAccount(user_id);
    }

    public boolean registerAccount(Account account) {
        return accountDao.registerAccount(account);
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public boolean edit(Account account) {
        return accountDao.edit(account);
    }
    public void changeStatus(int user_status,int id){
        accountDao.changeStatus(user_status,id);
    }
}
