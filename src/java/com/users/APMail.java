/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author Hriday Dubey
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.dao.DataConnect;
import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
@ApplicationScoped
@ViewScoped
public class APMail {

    private long ReceiptID;
    private String InvoiceNo;
    private String VenderName;
    private String CompanyName;
    private long InvoiceAmount;
    private String APNo = null;
    private String Remarks;
    private String EmailID;
    private String ChekAP;
    private String DDSNO;
    private String CName;
    private String region;

    public String getDDSNO() {
        return DDSNO;
    }

    public void setDDSNO(String DDSNO) {
        this.DDSNO = DDSNO;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
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

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
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

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String EmailID) {
        this.EmailID = EmailID;
    }

    public void mailAP(String DDS, String CNO) {

        if (CNO.equals("")) {

            String premessage = "<p><span style=\"color: #3366ff;\">Dear User,</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">We have received the submitted invoice against the<strong> DDS No.: " + DDS + ".</strong> Please find the AP details of submitted invoice down below:</span></p>";

            String postmessage = "<p><br /><strong>NOTE:-</strong> <span style=\"background-color: #ffff00;\">This is a auto generated mail. For more information, please reach out to helpdesk@ebex.esselgroup.com or your respective DMS team.</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">Regards,</span><br /><span style=\"color: #3366ff;\">Bill Desk Team</span></p>";

            String message1 = "<table style=\"height: 22px; border-color: black; background-color: darkblue;\" width=\"1117\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><strong><span style=\"color: #ffffff;\">Receipt ID</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><strong><span style=\"color: #ffffff;\">Invoice No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><strong><span style=\"color: #ffffff;\">Vendor Name</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><strong><span style=\"color: #ffffff;\">DDS No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><strong><span style=\"color: #ffffff;\">AP No.</span></strong></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>";
            String message = message1;
            try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("APmailbydds '" + DDS + "'");
                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    ReceiptID = rs.getInt(1);
                    InvoiceNo = rs.getString(2);
                    String VendorName = rs.getString(3);
                    DDS = rs.getString(9);
                    APNo = rs.getString(6);
                    EmailID = rs.getString(12);
                    String sql = "Mailstatus " + ReceiptID;
                    PreparedStatement ps1;
                    ps1 = con.prepareStatement(sql);
                    ps1.execute();
                    message = message + "<table style=\"height: 22px; border-top-color: black; background-color: #FFE4E1;\" width=\"1117\">\n"
                            + "<tbody>\n"
                            + "<tr>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><span style=\"color: #000000;\">" + ReceiptID + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><span style=\"color: #000000;\">" + InvoiceNo + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><span style=\"color: #000000;\">" + VendorName + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><span style=\"color: #000000;\">" + DDS + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><span style=\"color: #DC143C;\">" + APNo + "</span></td>\n"
                            + "</tr>\n"
                            + "</tbody>\n"
                            + "</table>";
                     ps1.close();
                }

                if (EmailID != null) {
                    new SendEmailOffice365().sendEmail(EmailID, "AP Number Generated against the DDS No.: " + DDS + "", premessage + message + postmessage);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AP has been mail Successfully"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Disputed Invoice is not available "));
                }
                rs.close();
                ps.close();
               
                con.close();

            } catch (SQLException ex) {
                System.out.println("SQL Exception..." + ex.getMessage());
            }

        } else {

            String premessage1 = "<p><span style=\"color: #3366ff;\">Dear User,</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">We have received the submitted invoice against the<strong>&nbsp;Courier No.: " + CNO + ".</strong> Please find the AP details of submitted invoice down below:</span></p>";

            String postmessage1 = "<p><br /><strong>NOTE:-</strong> <span style=\"background-color: #ffff00;\">This is a auto generated mail. For more information, please reach out to helpdesk@ebex.esselgroup.com or your respective DMS team.</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">Regards,</span><br /><span style=\"color: #3366ff;\">Bill Desk Team</span></p>";

            String message2 = "<table style=\"height: 22px; border-color: black; background-color: darkblue;\" width=\"1117\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><strong><span style=\"color: #ffffff;\">Receipt ID</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><strong><span style=\"color: #ffffff;\">Invoice No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><strong><span style=\"color: #ffffff;\">Vendor Name</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><strong><span style=\"color: #ffffff;\">Courier No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><strong><span style=\"color: #ffffff;\">Remarks</span></strong></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>";
            String messagec = message2;
            try {
                Connection con = DataConnect.getConnection();
            PreparedStatement  ps=con.prepareStatement("APmailbyCourier '" + CNO + "'");
            ResultSet rs;
            rs = ps.executeQuery();  
                while (rs.next()) {
                    ReceiptID = rs.getInt(1);
                    InvoiceNo = rs.getString(2);
                    String VendorName = rs.getString(3);
                    CNO = rs.getString(11);
                    APNo = rs.getString(6);
                    EmailID = rs.getString(12);
                    String sql = "Mailstatus " + ReceiptID;
                    PreparedStatement ps1 ;
                    ps1 = con.prepareStatement(sql);
                    ps1.execute();
                    messagec = messagec + "<table style=\"height: 22px; border-top-color: black; background-color: #FFE4E1;\" width=\"1117\">\n"
                            + "<tbody>\n"
                            + "<tr>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><span style=\"color: #000000;\">" + ReceiptID + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><span style=\"color: #000000;\">" + InvoiceNo + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><span style=\"color: #000000;\">" + VendorName + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><span style=\"color: #000000;\">" + CNO + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><span style=\"color: #DC143C;\">" + APNo + "</span></td>\n"
                            + "</tr>\n"
                            + "</tbody>\n"
                            + "</table>";
                     ps1.close();
                }

                if (EmailID != null) {
                    new SendEmailOffice365().sendEmail(EmailID, "AP Number Generated against the Courier No.: " + CNO + "", premessage1 + messagec + postmessage1);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remarks has been mail Successfully"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Disputed Invoice is not available "));
                }
                rs.close();
                ps.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println("SQL Exception..." + ex.getMessage());
            }

        }

    }

    public void mailRAP(String Receipt) {

        String premessage = "<p><span style=\"color: #3366ff;\">Dear User,</span></p>\n"
                + "<p><span style=\"color: #3366ff;\">We have received the submitted invoice against the<strong> ReceiptID.: " + Receipt + ".</strong> Please find the AP details of submitted invoice down below:</span></p>";

        String postmessage = "<p><br /><strong>NOTE:-</strong> <span style=\"background-color: #ffff00;\">This is a auto generated mail. For more information, please reach out to helpdesk@ebex.esselgroup.com or your respective DMS team.</span></p>\n"
                + "<p><span style=\"color: #3366ff;\">Regards,</span><br /><span style=\"color: #3366ff;\">Bill Desk Team</span></p>";

        String message1 = "<table style=\"height: 22px; border-color: black; background-color: darkblue;\" width=\"1117\">\n"
                + "<tbody>\n"
                + "<tr>\n"
                + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><strong><span style=\"color: #ffffff;\">Receipt ID</span></strong></td>\n"
                + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><strong><span style=\"color: #ffffff;\">Invoice No.</span></strong></td>\n"
                + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><strong><span style=\"color: #ffffff;\">Vendor Name</span></strong></td>\n"
                + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><strong><span style=\"color: #ffffff;\">DDS No.</span></strong></td>\n"
                + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><strong><span style=\"color: #ffffff;\">AP No.</span></strong></td>\n"
                + "</tr>\n"
                + "</tbody>\n"
                + "</table>";
        String message = message1;
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement  ps=con.prepareStatement("APmailbyReceiptID '" + Receipt + "'");
            ResultSet rs;
            rs = ps.executeQuery();   

            while (rs.next()) {
                ReceiptID = rs.getInt(1);
                InvoiceNo = rs.getString(2);
                String VendorName = rs.getString(3);
                APNo = rs.getString(6);
                EmailID = rs.getString(12);
                String sql = "Mailstatus " + ReceiptID;
                PreparedStatement ps1;
                ps1 = con.prepareStatement(sql);
                ps1.execute();
                message = message + "<table style=\"height: 22px; border-top-color: black; background-color: #FFE4E1;\" width=\"1117\">\n"
                        + "<tbody>\n"
                        + "<tr>\n"
                        + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><span style=\"color: #000000;\">" + ReceiptID + "</span></td>\n"
                        + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><span style=\"color: #000000;\">" + InvoiceNo + "</span></td>\n"
                        + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><span style=\"color: #000000;\">" + VendorName + "</span></td>\n"
                        + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"166\"><span style=\"color: #DC143C;\">" + APNo + "</span></td>\n"
                        + "</tr>\n"
                        + "</tbody>\n"
                        + "</table>";
                ps1.close();
            }

            if (EmailID != null) {
                new SendEmailOffice365().sendEmail(EmailID, "AP Number Generated against the ReceiptID.: " + Receipt + "", premessage + message + postmessage);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AP has been mail Successfully"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Disputed Invoice is not available "));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }

    }    

}
