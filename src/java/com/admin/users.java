/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.admin;

/**
 *
 * @author Hriday Dubey
 */
import java.util.Date;

public class users{

	public long userindex;
	public String username;
	public String firstname;
	public String lastname;
        public String region;
	public String emailid;
	public String usertype;
	public String currentpassword;

	public long getUserIndex() {
        return userindex;
    }

    public void setUserIndex(long userindex) {
        this.userindex = userindex;
    }

	public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getCurrenetPassword() {
        return currentpassword;
    }

    public void setCurrenetPassword(String currentpassword) {
        this.currentpassword = currentpassword;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
