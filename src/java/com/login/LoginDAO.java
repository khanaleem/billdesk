package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.DataConnect;

public class LoginDAO {

    private static String dbusername;
    private static String dbpassword;

    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            con = DataConnect.getConnection(); 
            if (con != null) {
                String sql = "UserLogin '" + user + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                dbusername = rs.getString("username");
                dbpassword = rs.getString("currentpassword");                
                con.close();
            }
 
            if (user.trim().equals(dbusername.trim()) && password.trim().equals(dbpassword.trim())) {
                return true;
            }

            
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
                 
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
            }
        return false;
    }

     
}
