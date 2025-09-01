package com.diworksdev.account.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;

public class regist_completeDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
    private String sql = "INSERT INTO account_data(family_name, last_name, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void createUser(String familyName,String lastName,String mail,String password,int gender,int postalCode,String prefecture,String address_1,String address_2,int authority) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familyName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, gender);
            preparedStatement.setInt(6, postalCode);
            preparedStatement.setString(7, prefecture);
            preparedStatement.setString(8, address_1);
            preparedStatement.setString(9, address_2);
            preparedStatement.setInt(10, authority);
            preparedStatement.setInt(11, 0); // delete_flag 初期値0
            preparedStatement.setString(12, dateUtil.getDate()); // 登録日時
            preparedStatement.setString(13, dateUtil.getDate()); // 更新日時
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            connection.close();
        }
    }
}