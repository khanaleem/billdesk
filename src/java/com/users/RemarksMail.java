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
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
@ApplicationScoped
public class RemarksMail {

    private long ReceiptID;
    private String InvoiceNo;
    private String VenderName;
    private String CompanyName;
    private long InvoiceAmount;
    private String Remarks;
    private String EmailID;
    private String DDSNO;
    private String CName;
    private String region;
    String Cnumber;

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

    public void mailRemarks(String DDS, String CNO) {

        if (CNO.equals("")) {

            String premessage = "<p><span style=\"color: #3366ff;\">Dear User,</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">We have received the submitted invoice against the<strong>&nbsp;DDS&nbsp;No.: " + DDS + ".</strong> However, there is some problem with the submitted invoice. Please refer Remarks:</span></p>";

            String postmessage = "<p><br /><strong>NOTE:-</strong>&nbsp;<span style=\"background-color: #ffff00;\">This is a auto generated mail. For more information, please reach out to your respective DMS team or helpdesk@ebex.esselgroup.com.</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">Regards,</span><br /><span style=\"color: #3366ff;\">Bill Desk Team</span></p>";

            String message1 = "<table style=\"height: 22px; border-color: black; background-color: darkblue;\" width=\"1217\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><strong><span style=\"color: #ffffff;\">Receipt ID</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><strong><span style=\"color: #ffffff;\">Invoice No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><strong><span style=\"color: #ffffff;\">Vendor Name</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><strong><span style=\"color: #ffffff;\">DDS No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"566\"><strong><span style=\"color: #ffffff;\">Remarks</span></strong></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>";
            String message = message1;
            try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Remarksmailbydds '" + DDS + "'");
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    ReceiptID = rs.getInt(1);
                    InvoiceNo = rs.getString(2);
                    String VendorName = rs.getString(3);
                    DDS = rs.getString(9);
                    Remarks = rs.getString(8);
                    EmailID = rs.getString(12);

                    message = message + "<table style=\"height: 22px; border-top-color: black; background-color: #FFE4E1;\" width=\"1217\">\n"
                            + "<tbody>\n"
                            + "<tr>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><span style=\"color: #000000;\">" + ReceiptID + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><span style=\"color: #000000;\">" + InvoiceNo + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><span style=\"color: #000000;\">" + VendorName + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><span style=\"color: #000000;\">" + DDS + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"566\"><span style=\"color: #DC143C;\">" + Remarks + "</span></td>\n"
                            + "</tr>\n"
                            + "</tbody>\n"
                            + "</table>";
                }

                if (Remarks != null) {
                    new SendEmailOffice365().sendEmail(EmailID, "Problem in Invoice against the Courier No./DDS No.: " + DDS + "", premessage + message + postmessage);
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

        } else {

            String premessage1 = "<p><span style=\"color: #3366ff;\">Dear User,</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">We have received the submitted invoice against the<strong> Courier&nbsp;No.: " + CNO + ".</strong> However, there is some problem with the submitted invoice. Please refer Remarks:</span></p>";

            String postmessage1 = "<p><br /><strong>NOTE:-</strong>&nbsp;<span style=\"background-color: #ffff00;\">This is a auto generated mail. For more information, please reach out to your respective DMS team or helpdesk@ebex.esselgroup.com.</span></p>\n"
                    + "<p><span style=\"color: #3366ff;\">Regards,</span><br /><span style=\"color: #3366ff;\">Bill Desk Team</span></p>";

            String message2 = "<table style=\"height: 22px; border-color: black; background-color: darkblue;\" width=\"1217\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><strong><span style=\"color: #ffffff;\">Receipt ID</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><strong><span style=\"color: #ffffff;\">Invoice No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><strong><span style=\"color: #ffffff;\">Vendor Name</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><strong><span style=\"color: #ffffff;\">Courier No.</span></strong></td>\n"
                    + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"566\"><strong><span style=\"color: #ffffff;\">Remarks</span></strong></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>";
            String messagec = message2;
            try {
                Connection con = DataConnect.getConnection();
                PreparedStatement ps = con.prepareStatement("Remarksmailbycouriernumber '" + CNO + "'");
                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    ReceiptID = rs.getInt(1);
                    InvoiceNo = rs.getString(2);
                    String VendorName = rs.getString(3);
                    CNO = rs.getString(11);
                    Remarks = rs.getString(8);
                    EmailID = rs.getString(12);

                    messagec = messagec + "<table style=\"height: 22px; border-top-color: black; background-color: #FFE4E1;\" width=\"1217\">\n"
                            + "<tbody>\n"
                            + "<tr>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"100\"><span style=\"color: #000000;\">" + ReceiptID + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"246\"><span style=\"color: #000000;\">" + InvoiceNo + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"340\"><span style=\"color: #000000;\">" + VendorName + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"131\"><span style=\"color: #000000;\">" + CNO + "</span></td>\n"
                            + "<td style=\"text-align: center;\" rowspan=\"3\" width=\"566\"><span style=\"color: #DC143C;\">" + Remarks + "</span></td>\n"
                            + "</tr>\n"
                            + "</tbody>\n"
                            + "</table>";
                }

                if (Remarks != null) {
                    new SendEmailOffice365().sendEmail(EmailID, "Problem in Invoice against the Courier No.: " + DDS + "", premessage1 + messagec + postmessage1);
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

}
