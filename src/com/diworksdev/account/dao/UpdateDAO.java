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
            int postalCode, String prefecture,
            String address1, String address2,
            int authority) throws SQLException {

        int result = 0;

        String sql = "UPDATE account_data SET family_name=?, last_name=?, family_name_kana=?, last_name_kana=?, mail=?, password=?, gender=?, postal_code=?, prefecture=?, address_1=?, address_2=?, authority=? WHERE id=?";

        try (Connection con = new DBConnector().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, familyName);
            ps.setString(2, lastName);
            ps.setString(3, familyNameKana);
            ps.setString(4, lastNameKana);
            ps.setString(5, mail);
            ps.setString(6, password);
            ps.setInt(7, gender);
            ps.setInt(8, postalCode);
            ps.setString(9, prefecture);
            ps.setString(10, address1);
            ps.setString(11, address2);
            ps.setInt(12, authority);
            ps.setInt(13, id);

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

                    dto.setPostalCode(rs.getInt("postal_code"));
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