package com.diworksdev.account.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;

public class UpdateDAO {
    public int updateAccount(String familyName, String lastName, String familyNameKana, String lastNameKana,
                             String mail, String password, int gender, String postalCode, String prefecture,
                             String address_1, String address_2, int authority, int id) throws SQLException {
        Connection con = null;
        int result = 0;
        try {
            con = new DBConnector().getConnection();
            String sql = "UPDATE account_data SET family_name=?, last_name=?, family_name_kana=?, last_name_kana=?, " +
                         "mail=?, password=?, gender=?, postal_code=?, prefecture=?, address_1=?, address_2=?, authority=? " +
                         "WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, familyName);
            ps.setString(2, lastName);
            ps.setString(3, familyNameKana);
            ps.setString(4, lastNameKana);
            ps.setString(5, mail);
            ps.setString(6, password);  // ←登録時と同様に暗号化処理をかけるならここで対応
            ps.setInt(7, gender);
            ps.setString(8, postalCode);
            ps.setString(9, prefecture);
            ps.setString(10, address_1);
            ps.setString(11, address_2);
            ps.setInt(12, authority);
            ps.setInt(13, id);
            result = ps.executeUpdate();
        } finally {
            if (con != null) con.close();
        }
        return result;
    }
}