package com.diworksdev.account.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;
public class regist_completeDAO {

    private DateUtil dateUtil = new DateUtil();

    private String sql = "INSERT INTO account_data "
            + "(family_name, last_name, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, delete_flag, registered_time, update_time) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void createUser(
            String familyName,
            String lastName,
            String mail,
            String password,
            String gender,
            String postalCode,
            String prefecture,
            String address_1,
            String address_2,
            String authority
    ) throws SQLException {

        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, familyName);
            ps.setString(2, lastName);
            ps.setString(3, mail);
            ps.setString(4, password);
            ps.setString(5, gender);
            ps.setString(6, postalCode);
            ps.setString(7, prefecture);
            ps.setString(8, address_1);
            ps.setString(9, address_2);
            ps.setString(10, authority);
            ps.setInt(11, 0); // delete_flag 初期値0
            ps.setString(12, dateUtil.getDate()); // 登録日時
            ps.setString(13, dateUtil.getDate()); // 更新日時
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}