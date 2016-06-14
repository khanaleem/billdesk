/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dao.DataConnect;
import com.users.SendEmailOffice365;
import java.sql.ResultSet;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean(name = "user")
@RequestScoped
public class User {

    private String username;
    private String region;
    private String Role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void add() {
        String dbuser = null;
        String dbemail = null;
        int i = 0;
        if (firstName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    try {
                        PreparedStatement ps1 = con.prepareStatement("UserLogin '" + username + "'");
                        ResultSet rs = ps1.executeQuery();
                        rs.next();
                        dbuser = rs.getString("username");
                        dbemail=rs.getString("emailid");
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    if (dbuser == null && dbemail==null) {
                        String sql = "exec insertuser ?,?,?,?,?,?,?";
                        ps = con.prepareStatement(sql);
                        username = username.trim();
                        ps.setString(1, username.trim());
                        ps.setString(2, firstName.trim());
                        ps.setString(3, lastName.trim());
                        ps.setString(4, region.trim());
                        ps.setString(5, email.trim());
                        ps.setString(6, Role.trim());
                        ps.setString(7, password.trim());
                        i = ps.executeUpdate();
                        con.close();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    e.getLocalizedMessage();
                }
            }
        }
        if (i > 0) {
            String Message = "<p><span style=\"color: #003366;\">Hello "+firstName+"</span>,</p>\n" +
"<p>Welcome to the billdesk , your account for billdesk has been created and the&nbsp;credentials are below</p>\n" +
"<p>USER ID :&nbsp;<span style=\"color: #800000;\"><strong>"+username+" </strong></span></p>\n" +
"<p>PASSWORD:&nbsp;<span style=\"color: #800000;\"><strong>"+password+"</strong></span></p>\n" +
"<p>URL:&nbsp;<span style=\"color: #003366;\">billdesk.esselgroup.com</span></p>\n" +
"<p>For more information please contact to billdesk team</p>\n" +
"<p><strong>NOTE:-</strong>&nbsp;<span style=\"color: #000000; background-color: #ffff00;\"> This is an automatically generated email, please do not reply.</span></p>\n" +
"<p>Regards,<br />Bill Desk Team <br />Direct: 91-120-4975916 Ekbhas: 125916</p>";
            new SendEmailOffice365().sendEmail(email, "Welcome to the Bill Desk", Message);

            FacesMessage msg = new FacesMessage("Successfully Added User", "The username is  :-" + username + "");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {
            FacesMessage msg1 = new FacesMessage("Username and Email ID already Exist", "Enter Another Username");
            msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }

    }

}
