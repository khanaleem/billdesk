/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@RequestScoped
@ApplicationScoped

public class APACK {

    private String DDSNO = null;
    private String CourierNO = null;
    private String EmailID;
    private String MObileNo;
    private String Ekbhas;
    private String MailStatus;
    private long ReceiptID;
    private String InvoiceNo;
    private String VenderName;
    private long InvoiceAmount;
    private String APNo = null;

    private String ChekAP;
    String DDS;
    String CR;
    String Searchtype;
    String Search;

    public String getSearchtype() {
        return Searchtype;
    }

    public void setSearchtype(String Searchtype) {
        this.Searchtype = Searchtype;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getCourierNO() {
        return CourierNO;
    }

    public void setCourierNO(String CourierNO) {
        this.CourierNO = CourierNO;
    }

    public String getDDSNO() {
        return DDSNO;
    }

    public void setDDSNO(String DDSNO) {
        this.DDSNO = DDSNO;
    }

    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getVenderName() {
        return VenderName;
    }

    public void setVenderName(String VenderName) {
        this.VenderName = VenderName;
    }

    public long getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(long InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }

    public String getAPNo() {
        return APNo;
    }

    public void setAPNo(String APNo) {
        this.APNo = APNo;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String EmailID) {
        this.EmailID = EmailID;
    }

    public String getMObileNo() {
        return MObileNo;
    }

    public void setMObileNo(String MObileNo) {
        this.MObileNo = MObileNo;
    }

    public String getEkbhas() {
        return Ekbhas;
    }

    public void setEkbhas(String Ekbhas) {
        this.Ekbhas = Ekbhas;
    }

    public String getMailStatus() {
        return MailStatus;
    }

    public void setMailStatus(String MailStatus) {
        this.MailStatus = MailStatus;
    }

    public LinkedList<APACK> getSearchedList(String region, String Searchtype, String Search) {

        LinkedList<APACK> SearchedList = new LinkedList<APACK>();
        try {
            Connection con = DataConnect.getConnection();
            if (Searchtype.equals("DDS")) {
                PreparedStatement ps = con.prepareStatement("DDS '" + Search.trim() + "'");
                ResultSet rs;
                rs = ps.executeQuery();
                DDS = Search;
                while (rs.next()) {
                    APACK ap = new APACK();
                    ap.setDDSNO(rs.getString(1));
                    ap.setEmailID(rs.getString(2));
                    SearchedList.add(ap);
                }
                rs.close();
                ps.close();
                con.close();
            } else if (Searchtype.equals("Courier")) {
                PreparedStatement ps = con.prepareStatement("courier '" + Search.trim() + "'");
                ResultSet rs;
                rs = ps.executeQuery();
                CR = Search;
                while (rs.next()) {
                    APACK ap = new APACK();
                    ap.setCourierNO(rs.getString(1));
                    ap.setEmailID(rs.getString(2));
                    SearchedList.add(ap);
                }
                rs.close();
                ps.close();
                con.close();

            } else if (Searchtype.equals("DS")) {

                PreparedStatement ps = con.prepareStatement("DDS '" + region.trim() + "'");
                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    APACK ap = new APACK();
                    ap.setDDSNO(rs.getString(1));
                    ap.setEmailID(rs.getString(2));
                    SearchedList.add(ap);
                }
                rs.close();
                ps.close();
                con.close();
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return SearchedList;
    }

    public LinkedList<APACK> getCrList(String region) {

        LinkedList<APACK> Crlist = new LinkedList<APACK>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("courier '" + region.trim() + "'");
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                APACK ap = new APACK();
                ap.setCourierNO(rs.getString(1));
                ap.setEmailID(rs.getString(2));
                Crlist.add(ap);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return Crlist;
    }

    public LinkedList<APACK> getAPListDDS(String DDS) {
        LinkedList<APACK> aplist = new LinkedList<APACK>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("DDSAP '" + DDS.trim() + "'");
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                APACK ap = new APACK();
                ap.setReceiptID(rs.getInt(1));
                ap.setInvoiceNo(rs.getString(2));
                ap.setVenderName(rs.getString(3));
                ap.setInvoiceAmount(rs.getInt(5));
                ap.setAPNo(rs.getString(6));
                aplist.add(ap);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return aplist;
    }

    public LinkedList<APACK> getAPListCR() {

        LinkedList<APACK> aplist = new LinkedList<APACK>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("courierap '" + CR.trim() + "'");
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                APACK ap = new APACK();
                ap.setReceiptID(rs.getInt(1));
                ap.setInvoiceNo(rs.getString(2));
                ap.setVenderName(rs.getString(3));
                ap.setInvoiceAmount(rs.getInt(5));
                ap.setAPNo(rs.getString(6));
                aplist.add(ap);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return aplist;
    }

    public void onRowEdit(long ID) {
        boolean i = false;
        if (ChekAP(APNo) != null) {

            FacesMessage msg2 = new FacesMessage("AP Number Already Exist !", "Please Enter the correct AP");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2);

        } else {

            PreparedStatement ps = null;
            Connection con = null;
            try {
                con = DataConnect.getConnection();
                if (APNo != null) {
                    String sql = "Updateap '" + APNo + "'," + ID;
                    ps = con.prepareStatement(sql);
                    i = ps.execute();

                }

                con.close();
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

            if (i) {

                FacesMessage msg = new FacesMessage("Error in AP !", "Try again");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } else {
                FacesMessage msg = new FacesMessage("Successfully Added AP", "Email will configure soon");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            }

        }

    }

    public String ChekAP(String AP) {

        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "Checkap '" + AP + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                ChekAP = rs.getString("ReceiptID");
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

        return ChekAP;
    }

}
