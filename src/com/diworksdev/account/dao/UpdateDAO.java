package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.account.dto.ListDTO;
import com.diworksdev.account.util.DBConnector;

public class UpdateDAO {

    // 更新処理
    public int updateAccount(int id, String familyName, String lastName,
            String familyNameKana, String lastNameKana,
            String mail, String password, int gender,
            String postalCode, String prefecture,
            String address1, String address2,
            int authority) throws SQLException {

        int result = 0;
        String sql;

        if(password != null) {
            // パスワードも更新する場合
            sql = "UPDATE account_data SET family_name=?, last_name=?, family_name_kana=?, last_name_kana=?, mail=?, password=?, gender=?, postal_code=?, prefecture=?, address_1=?, address_2=?, authority=? WHERE id=?";
        } else {
            // パスワードはそのまま
            sql = "UPDATE account_data SET family_name=?, last_name=?, family_name_kana=?, last_name_kana=?, mail=?, gender=?, postal_code=?, prefecture=?, address_1=?, address_2=?, authority=? WHERE id=?";
        }
        
        try (Connection con = new DBConnector().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, familyName);
            ps.setString(2, lastName);
            ps.setString(3, familyNameKana);
            ps.setString(4, lastNameKana);
            ps.setString(5, mail);
            int index = 6;

            if(password != null) {
                ps.setString(6, password);
                index = 7;
            }
            ps.setInt(index++, gender);
            ps.setString(index++, postalCode);
            ps.setString(index++, prefecture);
            ps.setString(index++, address1);
            ps.setString(index++, address2);
            ps.setInt(index++, authority);
            ps.setInt(index++, id);

            result = ps.executeUpdate();
        }

        return result;
    }

    // ID指定でアカウント取得
    public ListDTO getAccountById(int id) throws SQLException {
        ListDTO dto = null;
        String sql = "SELECT * FROM account_data WHERE id = ?";

        try (Connection con = new DBConnector().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dto = new ListDTO();
                    dto.setId(rs.getInt("id"));
                    dto.setFamilyName(rs.getString("family_name"));
                    dto.setLastName(rs.getString("last_name"));
                    dto.setFamilyNameKana(rs.getString("family_name_kana"));
                    dto.setLastNameKana(rs.getString("last_name_kana"));
                    dto.setMail(rs.getString("mail"));
                    dto.setPassword(rs.getString("password"));
                    dto.setGender(rs.getInt("gender"));

                    dto.setPostalCode(rs.getString("postal_code"));
                    dto.setPrefecture(rs.getString("prefecture"));
                    dto.setAddress_1(rs.getString("address_1"));
                    dto.setAddress_2(rs.getString("address_2"));
                    dto.setAuthority(rs.getInt("authority"));
                }
            }
        }
        return dto;
    }
}