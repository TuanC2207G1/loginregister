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

    public  Account findById(int id) {
        String sql = "select * from users where user_id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            int user_id=resultSet.getInt("user_id");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String phonenumber = resultSet.getString("phonenumber");
            String address = resultSet.getString("address");
            int role_id=resultSet.getInt("role_id");
            int user_status=resultSet.getInt("user_status");
            return new Account(user_id,email, password, first_name, last_name, phonenumber, address,role_id,user_status);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean edit(Account account) {
        String sql = "update users set email=?, password=?, first_name=? ,last_name=?,phonenumber=?,address=? where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getEmail());
            preparedStatement.setString(2, account.getPass());
            preparedStatement.setString(3, account.getFirstName());
            preparedStatement.setString(4, account.getLastName());
            preparedStatement.setString(5, account.getPhoneNumber());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setInt(7, account.getId());
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void changeStatus(int user_status,int id) {
        String sql = "update users set user_status=? where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (user_status == 1) {
                preparedStatement.setInt(1, 0);
            } else {
                preparedStatement.setInt(1, 1);
            }
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
