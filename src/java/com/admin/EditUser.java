/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.admin;

/**
 *
 * @author Hriday Dubey
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.admin.users; 
import com.dao.DataConnect;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@SessionScoped


public class EditUser {

 
    DataConnect ds;

public List<users> getUsereList() throws SQLException{



		//get database connection
		Connection con = ds.getConnection();

		if(con==null)
			throw new SQLException("Can't get database connection");

		PreparedStatement ps
			= con.prepareStatement(
			   ""
//                                   + "select username, firstname, lastname, region, emailid, usertype, currentpassword from Users a inner join password b on a.userindex=b.userindex"
                        );

		//get customer data from database
		ResultSet result =  ps.executeQuery();

		List<users> list = new ArrayList<users>();

		while(result.next()){
			users user = new users();
			user.setUsername(result.getString("username"));
			user.setFirstName(result.getString("firstname"));
			user.setLastName(result.getString("lastname"));
                        user.setRegion(result.getString("region"));
                        user.setEmailid(result.getString("emailid"));
                        user.setUsertype(result.getString("usertype"));
                        user.setCurrenetPassword(result.getString("currentpassword"));

			//store all data into a List
			list.add(user);
                        System.out.println(list);
		}
               
            con.close();

		return list;
	}
public static void main(String[] args) throws SQLException {
        EditUser n = new EditUser();
        n.getUsereList();

    }

}
