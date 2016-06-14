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
import java.util.LinkedList;
import java.util.List;
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
public class InsertAPBeans {

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
    private List<InsertAPBeans> filteredAP;

    public List<InsertAPBeans> getFilteredAP() {
        return filteredAP;
    }

    public void setFilteredAP(List<InsertAPBeans> filteredAP) {
        this.filteredAP = filteredAP;
    }

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

    public LinkedList<InsertAPBeans> getAPData(String region) {
       
        LinkedList<InsertAPBeans> aplist = new LinkedList<InsertAPBeans>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("apentry '" + region.trim() + "'");
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                InsertAPBeans ap = new InsertAPBeans();
                ap.setReceiptID(rs.getInt(1));
                ap.setInvoiceNo(rs.getString(2));
                ap.setVenderName(rs.getString(3));
                ap.setCompanyName(rs.getString(4));
                ap.setInvoiceAmount(rs.getInt(5));
                ap.setAPNo(rs.getString(6));
                ap.setRemarks(rs.getString(8));
                ap.setDDSNO(rs.getString(9));
                ap.setCName(rs.getString(10));
                ap.setEmailID(rs.getString(12));
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

    public void RowEdit(long ID) {
        int i = 0;
        if (ChekAP(APNo) != null) {

            FacesMessage msg2 = new FacesMessage("AP Number Already Exist !", "Please Enter the correct AP");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2);

        } else {

            PreparedStatement ps;
            Connection con;
            try {
                con = DataConnect.getConnection();
                if (APNo != null) {
                    String sql = "Updateap '" + APNo + "' ," + ID;
                    ps = con.prepareStatement(sql);
                    i = ps.executeUpdate();
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            if (i > 0) {
                FacesMessage msg = new FacesMessage("Successfully Added AP", "Email will configure soon");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } else {
                FacesMessage msg = new FacesMessage("Error in AP !", "Try again");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, msg);

            }

        }

    }

    public void onRowEdit(long ID, String EmailID, String InNo, String VenN) {
        boolean i = false;
        if (ChekAP(APNo) != null) {

            FacesMessage msg2 = new FacesMessage("AP Number Already Exist !", "Please Enter the correct AP");
            msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg2);

        } else {

            PreparedStatement ps;
            Connection con;
            try {
                con = DataConnect.getConnection();
                if (APNo != null) {
                    String sql = "Updateap '" + APNo + "' ," + ID;
                    ps = con.prepareStatement(sql);
                    i = ps.execute();
                    String message = "<p>Dear User,</p>\n"
                            + "<p>We have received and processed the submitted invoice in Workflow. <br /> The Invoice Receipt ID is <strong>" + ReceiptID + "</strong> ,Invoice Number is <strong>" + InNo + "</strong>,Vendor Name is <strong>" + VenN + "</strong> and the AP number is <strong>" + APNo + "</strong><br /> For further communication or more information in future, please keep DDS No./Receipt ID/AP No handy.<br /> <br /> <span style=\"color: #003366;\">Regards</span>,<br /> <span style=\"color: #003366;\">Ebex BillDesk Team </span></p>\n"
                            + "<p><br /> <strong>Note</strong>:<span style=\"background-color: #ffff00;\"> Please do not reply to this message via e-mail. This address is automated, unattended, and cannot help with questions or requests</span></p><br/>";
                    if (!EmailID.equals("MAIL@MAIL.COM")) {
                        new SendEmailOffice365().sendEmail(EmailID, "AP Number Generated ", message);
                    }

                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
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

    public String SenderEmail(long ID) {

        PreparedStatement ps;
        Connection con;
        ResultSet rs;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "getsenderemail '" + ID + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                EmailID = rs.getString("EmailID");
                System.out.print(EmailID);
                rs.close();
                ps.close();
                con.close();
            }

        } catch (SQLException sqle) {
            sqle.getErrorCode();
        }

        return EmailID;
    }

    public String ChekAP(String AP) {

        PreparedStatement ps;
        Connection con;
        ResultSet rs;
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
        }

        return ChekAP;
    }

}
