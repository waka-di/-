package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;
import com.diworksdev.account.util.PasswordUtil;

public class Regist_completeDAO {

    private DateUtil dateUtil = new DateUtil();

    private String sql = "INSERT INTO account_data(family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public int createUser(String familyName, String lastName, String familyNameKana, String lastNameKana, 
                          String mail, String password, int gender, String postalCode, String prefecture, 
                          String address_1, String address_2, int authority) throws SQLException {
        int result = 0;
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, familyName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, familyNameKana); 
            preparedStatement.setString(4, lastNameKana);   
            preparedStatement.setString(5, mail);
            preparedStatement.setString(6, PasswordUtil.hash(password));
            preparedStatement.setInt(7, gender);
            preparedStatement.setString(8, postalCode);
            preparedStatement.setString(9, prefecture);
            preparedStatement.setString(10, address_1);
            preparedStatement.setString(11, address_2);
            preparedStatement.setInt(12, authority);
            preparedStatement.setInt(13, 0); // delete_flag
            preparedStatement.setString(14, dateUtil.getDate()); // registered_time
            preparedStatement.setString(15, dateUtil.getDate()); // update_time

            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}