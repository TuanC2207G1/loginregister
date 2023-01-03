package dao;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    static Connection connection = ConnectionMysql.getConnection();

    public List<Account> getAll() {
        List<Account> accountList = new ArrayList<>();
        String sql = "Select * from users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                accountList.add(getAccount(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }

    public Account checkLogin(String email, String password) {
        String sql = "select * from users where email=? and password =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getAccount(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerAccount(Account account) {
        String sql = "Insert Into shopdata.users (email,password,first_name,last_name,phonenumber,address,role_id, user_status) values (?,?,?,?,?,?,DEFAULT, DEFAULT)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getPass());
            preparedStatement.setString(3, account.getFirstName());
            preparedStatement.setString(4, account.getLastName());
            preparedStatement.setString(5, account.getPhoneNumber());
            preparedStatement.setString(6, account.getAddress());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteAccount(int user_id) {
        String sql = "delete from users where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean editAccount(int user_id) {
        return false;
    }

    private static Account getAccount(ResultSet resultSet) throws SQLException {
        int id_Db = resultSet.getInt("user_id");
        String email_Db = resultSet.getString("email");
        String password_Db = resultSet.getString("password");
        String firstName_Db = resultSet.getString("first_name");
        String lastName_Db = resultSet.getString("last_name");
        String phoneNumber_Db = resultSet.getString("phonenumber");
        String address_Db = resultSet.getString("address");
        int roleId_Db = resultSet.getInt("role_id");
        int userStatus_Db = resultSet.getInt("user_status");
        return new Account(id_Db, email_Db, password_Db, firstName_Db, lastName_Db, phoneNumber_Db, address_Db, roleId_Db, userStatus_Db);
    }
}
