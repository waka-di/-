package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;

public class Delete_completeDAO {
    public int deleteAccount(int id) throws SQLException {
        int result = 0;
        String sql = "UPDATE account_data SET delete_flag = 1, update_time = now() WHERE id = ?";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        }
        return result;
    }
}
