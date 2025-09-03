package com.diworksdev.account.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static String hash(String password) {
		 if (password == null || password.isEmpty()) {
	            return null;
	        }
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");//ハッシュ化
	            byte[] bytes = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : bytes) {
	                sb.append(String.format("%02x", b & 0xff));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}