package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.account.dto.ListDTO;
import com.diworksdev.account.util.DBConnector; 

public class LoginDAO {

    public ListDTO select(String mail, String password) throws SQLException {
        ListDTO dto = null;

        Connection con = DBConnector.getConnection();

        String sql = "SELECT * FROM account_data WHERE mail = ? AND password = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mail);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dto = new ListDTO();
                    dto.setMail(rs.getString("mail"));
                    dto.setPassword(rs.getString("password"));
                    dto.setAuthority(rs.getInt("authority"));
                    
                }
            }
        } finally {
            con.close();
        }

        return dto;
    }
}