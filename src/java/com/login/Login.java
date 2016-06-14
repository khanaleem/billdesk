package com.login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String user;
    private String dbrole;
    private String Password;
    private String Oldpassword;
    private boolean loggedIn;
    private String Region;

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getDbrole() {
        return dbrole;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getOldpassword() {
        return Oldpassword;
    }

    public void setOldpassword(String Oldpassword) {
        this.Oldpassword = Oldpassword;
    }

    //validate login
    public String validateUsernamePassword() {
        dbRole(user.trim());
        boolean valid = LoginDAO.validate(user.trim(), pwd.trim());
        if (valid) {
            if (dbrole.equals("u") || dbrole.equals("m") || dbrole.equals("s")) {
                loggedIn = true;
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                session.setAttribute("Region", Region);
                session.setAttribute("Password", Password);
                session.setAttribute("Oldpassword", Oldpassword);
                session.setAttribute("dbrole", dbrole);
                return "/user/Welcome.jsf?faces-redirect=true";

            } else {
                loggedIn = true;
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                session.setAttribute("Region", Region);
                session.setAttribute("Password", Password);
                session.setAttribute("Oldpassword", Oldpassword);
                session.setAttribute("dbrole", dbrole);
                return "/admin/welcome.jsf?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    ":login-form:password",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Please enter correct username and Password",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    public void dbRole(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "UserLogin '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    Password = rs.getString("currentpassword");
                    Oldpassword = rs.getString("oldpassword");
                    Region = rs.getString("Region");
                    dbrole = rs.getString("usertype");
                    rs.close();
                    con.close();

                }

            } catch (SQLException sqle) {
                sqle.getErrorCode();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
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
        }
    }

    //logout event, invalidate session
    public String logout() {
        loggedIn = false;
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        FacesMessage msg1 = new FacesMessage("Loged Out successfully", "INFO MSG");
        msg1.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg1);
        return "/login.jsf?faces-redirect=true";
    }

    
    public static void main(String[] args) {
        Login n=new Login();
        n.dbRole("dee");
    }
    
}
