package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.ListDTO;
import com.diworksdev.account.util.DBConnector;
	
	public class ListDAO {
		public List<ListDTO> getAccountList() {
		    List<ListDTO> accountList = new ArrayList<>();
		    String sql = "SELECT * FROM account_data ORDER BY id DESC";

		    try (Connection con = DBConnector.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql);
		         ResultSet rs = ps.executeQuery()) {

		        while (rs.next()) {
		            ListDTO dto = new ListDTO();
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
		            dto.setDeleteFlg(rs.getInt("delete_flag"));
		            dto.setInsertDate(rs.getTimestamp("registered_time"));
		            dto.setUpdateDate(rs.getTimestamp("update_time"));
		            accountList.add(dto);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return accountList;
		}
		 public List<ListDTO> searchAccounts(
		            String familyName, String lastName,
		            String familyNameKana, String lastNameKana,
		            String mail, String gender, String authority) {

		        List<ListDTO> accountList = new ArrayList<>();
		        StringBuilder sql = new StringBuilder("SELECT * FROM account_data WHERE 1=1");
		        
		        if (familyName != null && !familyName.isEmpty()) {
		            sql.append(" AND family_name LIKE ?");
		        }
		        if (lastName != null && !lastName.isEmpty()) {
		            sql.append(" AND last_name LIKE ?");
		        }
		        if (familyNameKana != null && !familyNameKana.isEmpty()) {
		            sql.append(" AND family_name_kana LIKE ?");
		        }
		        if (lastNameKana != null && !lastNameKana.isEmpty()) {
		            sql.append(" AND last_name_kana LIKE ?");
		        }
		        if (mail != null && !mail.isEmpty()) {
		            sql.append(" AND mail LIKE ?");
		        }
		        if (gender != null && !gender.isEmpty()) {
		            sql.append(" AND gender = ?");
		        }
		        if (authority != null && !authority.isEmpty()) {
		            sql.append(" AND authority = ?");
		        }

		        sql.append(" ORDER BY id DESC");

		        try (Connection con = DBConnector.getConnection();
		             PreparedStatement ps = con.prepareStatement(sql.toString())) {

		            int index = 1;
		            if (familyName != null && !familyName.isEmpty()) ps.setString(index++, "%" + familyName + "%");
		            if (lastName != null && !lastName.isEmpty()) ps.setString(index++, "%" + lastName + "%");
		            if (familyNameKana != null && !familyNameKana.isEmpty()) ps.setString(index++, "%" + familyNameKana + "%");
		            if (lastNameKana != null && !lastNameKana.isEmpty()) ps.setString(index++, "%" + lastNameKana + "%");
		            if (mail != null && !mail.isEmpty()) ps.setString(index++, "%" + mail + "%");
		            if (gender != null && !gender.isEmpty()) ps.setInt(index++, Integer.parseInt(gender));
		            if (authority != null && !authority.isEmpty()) ps.setInt(index++, Integer.parseInt(authority));

		            try (ResultSet rs = ps.executeQuery()) {
		            	while (rs.next()) {
		                ListDTO dto = new ListDTO();
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
			                dto.setDeleteFlg(rs.getInt("delete_flag"));
			                dto.setInsertDate(rs.getTimestamp("registered_time"));
			                dto.setUpdateDate(rs.getTimestamp("update_time"));
			                accountList.add(dto);
			            }
		            }
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return accountList;
	    }
}