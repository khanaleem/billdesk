/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.dao.DataConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@ViewScoped
public class Inwardedit implements Serializable {

    String ReceiptID;

    boolean save;
    String DelMethod;
    String DDSNo = null;
    String PageNo = null;
    Date DDDate;
    String CourierName = null;
    String CourierNo = null;
    Date CourierDate;
    String SenderName = null;
    String SenderEmail = null;
    String SenderMo = null;
    String SenderEK = null;
    String DocType = null;
    String InvoiceType = null;
    String ComName = null;
    String InvoiceNo;
    String NoOfInvoice = null;
    Date InvoiceDate;
    String venderName;
    String PoCategory = null;
    String NonPoCategory = null;
    String PONo;
    String billAmount = null;
    String Costcenter = null;
    String CostcenterNo = null;
    String Remarks = null;

    String INVD;
    String INVNO;
    String VNAD;
    String CNAD;
    String STSBC;
    String AI;
    String IVMPO;
    String NPOCWPC;
    String NPONEVC;
    String NPOASIN;
    String PONOA;
    String POR2K;
    String POVSIN;
    String PANNO;
    String STTIN;

    private String CheckVender;
    private String region;
    private Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(String ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getINVD() {
        return INVD;
    }

    public String getINVNO() {
        return INVNO;
    }

    public String getVNAD() {
        return VNAD;
    }

    public String getCNAD() {
        return CNAD;
    }

    public String getSTSBC() {
        return STSBC;
    }

    public String getAI() {
        return AI;
    }

    public String getIVMPO() {
        return IVMPO;
    }

    public String getNPOCWPC() {
        return NPOCWPC;
    }

    public String getNPONEVC() {
        return NPONEVC;
    }

    public String getNPOASIN() {
        return NPOASIN;
    }

    public String getPONOA() {
        return PONOA;
    }

    public String getPOR2K() {
        return POR2K;
    }

    public String getPOVSIN() {
        return POVSIN;
    }

    public String getPANNO() {
        return PANNO;
    }

    public String getSTTIN() {
        return STTIN;
    }

    public void setINVD(String INVD) {
        this.INVD = INVD;
    }

    public void setINVNO(String INVNO) {
        this.INVNO = INVNO;
    }

    public void setVNAD(String VNAD) {
        this.VNAD = VNAD;
    }

    public void setCNAD(String CNAD) {
        this.CNAD = CNAD;
    }

    public void setSTSBC(String STSBC) {
        this.STSBC = STSBC;
    }

    public void setAI(String AI) {
        this.AI = AI;
    }

    public void setIVMPO(String IVMPO) {
        this.IVMPO = IVMPO;
    }

    public void setNPOCWPC(String NPOCWPC) {
        this.NPOCWPC = NPOCWPC;
    }

    public void setNPONEVC(String NPONEVC) {
        this.NPONEVC = NPONEVC;
    }

    public void setNPOASIN(String NPOASIN) {
        this.NPOASIN = NPOASIN;
    }

    public void setPONOA(String PONOA) {
        this.PONOA = PONOA;
    }

    public void setPOR2K(String POR2K) {
        this.POR2K = POR2K;
    }

    public void setPOVSIN(String POVSIN) {
        this.POVSIN = POVSIN;
    }

    public void setPANNO(String PANNO) {
        this.PANNO = PANNO;
    }

    public void setSTTIN(String STTIN) {
        this.STTIN = STTIN;
    }

    public Date getDDDate() {
        return DDDate;
    }

    public void setDDDate(Date DDDate) {
        this.DDDate = DDDate;
    }

    public Date getCourierDate() {
        return CourierDate;
    }

    public void setCourierDate(Date CourierDate) {
        this.CourierDate = CourierDate;
    }

    public String getSenderMo() {
        return SenderMo;
    }

    public void setSenderMo(String SenderMo) {
        this.SenderMo = SenderMo;
    }

    public String getSenderEK() {
        return SenderEK;
    }

    public void setSenderEK(String SenderEK) {
        this.SenderEK = SenderEK;
    }

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String DocType) {
        this.DocType = DocType;
    }

    public String getCostcenterNo() {
        return CostcenterNo;
    }

    public void setCostcenterNo(String CostcenterNo) {
        this.CostcenterNo = CostcenterNo;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getNoOfInvoice() {
        return NoOfInvoice;
    }

    public void setNoOfInvoice(String NoOfInvoice) {
        this.NoOfInvoice = NoOfInvoice;
    }

    public String getComName() {

        return ComName;
    }

    public void setComName(String ComName) {
        this.ComName = ComName;
    }

    public String getCourierName() {
        return CourierName;
    }

    public void setCourierName(String CourierName) {
        this.CourierName = CourierName;
    }

    public String getCourierNo() {
        return CourierNo;
    }

    public void setCourierNo(String CourierNo) {
        this.CourierNo = CourierNo;
    }

    public String getDDSNo() {
        return DDSNo;
    }

    public void setDDSNo(String DDSNo) {
        this.DDSNo = DDSNo;
    }

    public String getDelMethod() {
        return DelMethod;
    }

    public void setDelMethod(String DelMethod) {
        this.DelMethod = DelMethod;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getPONo() {
        return PONo;
    }

    public void setPONo(String PONo) {
        this.PONo = PONo;
    }

    public String getPoCategory() {
        return PoCategory;
    }

    public void setPoCategory(String PoCategory) {
        this.PoCategory = PoCategory;
    }

    public String getNonPoCategory() {
        return NonPoCategory;
    }

    public void setNonPoCategory(String NonPoCategory) {
        this.NonPoCategory = NonPoCategory;
    }

    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String PageNo) {
        this.PageNo = PageNo;
    }

    public String getSenderEmail() {
        return SenderEmail;
    }

    public void setSenderEmail(String SenderEmail) {
        this.SenderEmail = SenderEmail;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getCostcenter() {
        return Costcenter;
    }

    public void setCostcenter(String Costcenter) {
        this.Costcenter = Costcenter;
    }

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String InvoiceType) {
        this.InvoiceType = InvoiceType;
    }

    public String getCheckVender() {

        return CheckVender;
    }

    public void setCheckVender(String CheckVender) {

        this.CheckVender = CheckVender;
    }

    public void save() {
        boolean i = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String IDate = format.format(InvoiceDate);
        if (DDDate == null) {

            DDDate = new Date();

        }
        if (CourierDate == null) {

            CourierDate = new Date();

        }
        String DDate = format.format(DDDate);
        String CDate = format.format(CourierDate);

        if (DelMethod.equals("Drop Box")) {

            CourierName = null;
            CourierNo = null;
            CDate = null;

        }
        if (DelMethod.equals("Courier")) {

            DDSNo = null;
            PageNo = null;
            DDate = null;

        }
        if (PoCategory.equals("PO")) {

            CostcenterNo = null;
            Costcenter = null;
            NonPoCategory = null;
            NPOCWPC = null;
            NPONEVC = null;
            NPOASIN = null;

        }
        if (PoCategory.equals("Non PO")) {

            PONo = null;
            IVMPO = null;
            PONOA = null;
            POR2K = null;
            POVSIN = null;
        }

        PreparedStatement ps;
        Connection con;
        try {
            con = DataConnect.getConnection();
            if (InvoiceNo != null) {
                String sql = "inwardupdate ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
                ps = con.prepareStatement(sql);
                ps.setString(1, InvoiceNo.toUpperCase());
                ps.setString(2, venderName.toUpperCase());
                ps.setString(3, IDate);
                ps.setString(4, billAmount);
                ps.setString(5, PoCategory);
                ps.setString(6, PONo);
                ps.setString(7, ComName);
                ps.setString(8, PageNo);
                ps.setString(9, DelMethod);
                ps.setString(10, DDSNo);
                ps.setString(11, CourierName);
                ps.setString(12, CourierNo);
                ps.setString(13, SenderName);
                ps.setString(14, SenderMo);
                ps.setString(15, SenderEmail);
                ps.setString(16, NoOfInvoice);
                ps.setString(17, Costcenter);
                ps.setString(18, InvoiceType);
                ps.setString(19, region);
                ps.setString(20, DDate);
                ps.setString(21, CDate);
                ps.setString(22, SenderEK);
                ps.setString(23, CostcenterNo);
                ps.setString(24, DocType);
                ps.setString(25, Remarks);
                ps.setString(26, INVD);
                ps.setString(27, INVNO);
                ps.setString(28, VNAD);
                ps.setString(29, CNAD);
                ps.setString(30, STSBC);
                ps.setString(31, AI);
                ps.setString(32, IVMPO);
                ps.setString(33, NPOCWPC);
                ps.setString(34, NPONEVC);
                ps.setString(35, NPOASIN);
                ps.setString(36, PONOA);
                ps.setString(37, POR2K);
                ps.setString(38, POVSIN);
                ps.setString(39, PANNO);
                ps.setString(40, STTIN);
                ps.setString(41, NonPoCategory);
                ps.setString(42, ReceiptID);
                i = ps.execute();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        if (i) {

            FacesMessage msg = new FacesMessage("Error in Updating Inward", "Try again");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {

            FacesMessage msg = new FacesMessage("Updated Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }
    }

    public void editData(String region, String RID,String role) {

        try {

            Connection con = DataConnect.getConnection();
            String smt;
            if(role.equals("s")||role.equals("a")){
                smt="InwardEdit 'a' ,'" + RID + "'";
            }else{
               smt="InwardEdit '" + region.trim() + "' ,'" + RID + "'";
            } 
            PreparedStatement ps = con.prepareStatement(smt);
            ResultSet rs;
            rs = ps.executeQuery();
            rs.next();
            InvoiceNo = rs.getString(2);
            venderName = rs.getString(12);
            InvoiceDate = rs.getDate(3);
            billAmount = rs.getString(4);
            PoCategory = rs.getString(14);
            PONo = rs.getString(16);
            ComName = rs.getString(13);
            PageNo = rs.getString(17);
            DelMethod = rs.getString(18);
            DDSNo = rs.getString("DDSNo");
            CourierName = rs.getString("CourierName");
            CourierNo = rs.getString("CourierNumber");
            SenderName = rs.getString("name");
            SenderMo = rs.getString("Mobileno");
            SenderEmail = rs.getString("emailid");
            NoOfInvoice = rs.getString(5);
            Costcenter = rs.getString(6);
            InvoiceType = rs.getString(7);
            DDDate = rs.getDate(22);
            CourierDate = rs.getDate(21);
            SenderEK = rs.getString("ekbhas");
            CostcenterNo = rs.getString(9);
            DocType = rs.getString(10);
            Remarks = rs.getString(8);
            NonPoCategory = rs.getString(15);
            INVD = rs.getString(29);
            INVNO = rs.getString(30);
            VNAD = rs.getString(31);
            CNAD = rs.getString(32);
            STSBC = rs.getString(33);
            AI = rs.getString(34);
            IVMPO = rs.getString(35);
            NPOCWPC = rs.getString(36);
            NPONEVC = rs.getString(37);
            NPOASIN = rs.getString(38);
            PONOA = rs.getString(39);
            POR2K = rs.getString(40);
            POVSIN = rs.getString(41);
            PANNO = rs.getString(42);
            STTIN = rs.getString(43);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());

        }
        if (InvoiceNo!=null) { 

            FacesMessage msg = new FacesMessage("Searched Successfully", "Searched Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {
            FacesMessage msg1 = new FacesMessage("ReceiptID {"+RID+" ) is Not found", "Search again");
            msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }

    }

    public String CheckInvoice(String InvoiceNo, String vendor) {

        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "checkinward '" + vendor + "','" + InvoiceNo + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                CheckVender = rs.getString("invoicenumber");

                rs.close();
                con.close();
            }

        } catch (SQLException sqle) {
            sqle.getErrorCode();
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

        return CheckVender;
    }

    public List<String> completeName(String query) {

        List<String> filteredName = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("getname '" + query + "'");
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString(1);
                list.add(email);
            }
            for (int i = 0; i < list.size(); i++) {
                String skin = list.get(i);
                if (skin.toLowerCase().startsWith(query) || skin.toUpperCase().startsWith(query)) {
                    filteredName.add(skin);
                }
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return filteredName;

    }

    public List<String> completeEmail(String query) {

        List<String> filteredEmail = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("getemail '" + query + "'");
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                list.add(email);
            }
            for (int i = 0; i < list.size(); i++) {
                String skin = list.get(i);
                if (skin.toLowerCase().startsWith(query) || skin.toUpperCase().startsWith(query)) {
                    filteredEmail.add(skin);
                }
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return filteredEmail;

    }

    public List<String> completeVendor(String query) {

        List<String> filteredVendor = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("getvendor '" + query + "'");
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString(1);
                list.add(email);
            }
            for (int i = 0; i < list.size(); i++) {
                String skin = list.get(i);
                if (skin.toLowerCase().startsWith(query) || skin.toUpperCase().startsWith(query)) {
                    filteredVendor.add(skin);
                }
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return filteredVendor;

    }

}
