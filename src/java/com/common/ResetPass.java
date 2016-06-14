/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;
  
import java.sql.Connection;
import java.sql.PreparedStatement; 
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext; 

import com.dao.DataConnect;
import java.sql.SQLException;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@RequestScoped
public class ResetPass {

    private String olpassword;
    private String newpassword;  
    
    public String getOlpassword() {
        return olpassword;
    }

    public void setOlpassword(String olpassword) {
        this.olpassword = olpassword;
    }

    public String getNewPassword() {
        return newpassword;
    }

    public void setNewPassword(String newpassword) {
        this.newpassword = newpassword;
    }

     

    public void reste(String user,String Role,String Pass,String oldPass) {
         
        int i = 0;
        if (olpassword.equals(Pass.trim())&&!olpassword.equals(newpassword.trim())&&!newpassword.equals(oldPass.trim())) {
            PreparedStatement ps = null;
            Connection con = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "exec changePassword ?,?,?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user.trim());
                    ps.setString(2, olpassword.trim());
                    ps.setString(3, newpassword.trim());
                     i = ps.executeUpdate();
               con.close();
                } 
           
            } catch (Exception e) {
                System.out.println(e);
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
            
        }  if (i > 0 && Role.trim().equals("a")) {
           
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");
                        FacesContext.getCurrentInstance().addMessage(null, msg2); 
        } else if (i > 0 && Role.trim().equals("u")) {
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");           
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
            
            
        }else if (i > 0 && Role.trim().equals("m")) {
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");           
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
            
            
        }else if (i > 0 && Role.trim().equals("s")) {
            FacesMessage msg2 = new FacesMessage("Your password has changed", "INFO MSG");           
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
            
            
        }
        else if (i == 0 &&!olpassword.equals(Pass.trim())) {
            FacesMessage msg2 = new FacesMessage("Your current password is wrong!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }
        else if (i == 0 && olpassword.equals(newpassword.trim())) {
            FacesMessage msg2 = new FacesMessage("new password shouldn't be the current password!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }else if (i == 0 && newpassword.equals(oldPass.trim())) {
            FacesMessage msg2 = new FacesMessage("new password shouldn't be the old password!", "ERROR MSG");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2); 
        }
         else {
            FacesMessage msg1 = new FacesMessage("Your current password is wrong!", "ERROR MSG");
            msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg1); 
        }

    }

     
}
