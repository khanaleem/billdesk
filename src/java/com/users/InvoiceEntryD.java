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
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@ViewScoped
public class InvoiceEntryD implements Serializable {

    boolean save;
    Date ReciDate = new Date();
    String DelMethod; 
    String DDSNo = null;
    String PageNo = null;
    Date DDDate = new Date();
    String CourierName = null;
    String CourierNo = null;
    Date CourierDate = new Date();
    String SenderName = null;
    String SenderEmail = null;
    String SenderMo = null;
    String SenderEK = null;
    String DocType = null;
    String InvoiceType = null;
    String ComName = null;
    String InvoiceNo;
    String NoOfInvoice = "1";
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
    private boolean skip;
    private Date currentDate = new Date();

    public String getINVD() {
        if (INVD == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }

    }

    public String getINVNO() {

        if (INVNO == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getVNAD() {

        if (VNAD == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getCNAD() {

        if (CNAD == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getSTSBC() {

        if (STSBC == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getAI() {

        if (AI == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getIVMPO() {

        if (IVMPO == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getNPOCWPC() {

        if (NPOCWPC == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getNPONEVC() {

        if (NPONEVC == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getNPOASIN() {

        if (NPOASIN == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getPONOA() {

        if (PONOA == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getPOR2K() {

        if (POR2K == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getPOVSIN() {

        if (POVSIN == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getPANNO() {

        if (PANNO == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
    }

    public String getSTTIN() {

        if (STTIN == "true") {
            return "\u2714";
        } else {
            return "\u2716";
        }
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

    public Date getCurrentDate() {

        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
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

    public Date getReciDate() {
        return ReciDate;
    }

    public void setReciDate(Date ReciDate) {
        this.ReciDate = ReciDate;
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
     
    public String saven(String region) {
        int i = 0;
         
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String IDate = format.format(InvoiceDate);
        String DDate = format.format(DDDate);
        String CDate = format.format(CourierDate);
        
       
        
        if (DelMethod.equals("Drop Box")) {
            
            CourierName=null;
            CourierNo=null;
            CDate=null;
            
        }
        if (DelMethod.equals("Courier")) {
            
            DDSNo=null;
            PageNo=null;
            DDate=null;
            
        }
        if (PoCategory.equals("PO")) {
            
            CostcenterNo=null;
            Costcenter=null;
            NonPoCategory=null;
            
        }
        if (PoCategory.equals("Non PO")) {
            
            PONo=null;
            
        }
        if (InvoiceNo != null) {
            CheckInvoice(InvoiceNo.toUpperCase(), venderName.toUpperCase());
            if (InvoiceNo.toUpperCase().equals(CheckVender)) {

                FacesMessage msg1 = new FacesMessage("The Invoice No : " + InvoiceNo + " is Already exist against Vendor Name : " + venderName + "", "Please Contact to vendor");
                msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, msg1);
                return "/user/Bill Entry.jsf";

            } else {

                PreparedStatement ps = null;
                Connection con = null;
                try {
                    con = DataConnect.getConnection();
                    if (con != null) {
                        String sql = "exec insertinvoiceentry ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
                        i = ps.executeUpdate();
                          con.close();
                    }
 
          
                } catch (Exception e) {
                    System.out.println(e);
                }finally {
            
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
        if (i > 0) {
            FacesMessage msg = new FacesMessage("Successfully Added invoice", "Enter New Invoice");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/user/Bill Entry.jsf";
        } else {
            FacesMessage msg = new FacesMessage("Error in Adding invoice!", "Try again");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/user/Bill Entry.jsf";
        }
    }

    

    public void reset() {

        RequestContext.getCurrentInstance().reset("enter");
        if (save) {
            save=false;
            DDSNo = null;
            PageNo = null;
            CourierName = null;
            CourierNo = null;
            SenderName = null;
            SenderEmail = null;
            InvoiceNo=null;
            venderName=null;
            PONo=null;
            SenderMo = null;
            SenderEK = null;
            DocType = null;
            InvoiceType = null;
            ComName = null; 
            PoCategory = null;
            billAmount = null;
            Costcenter = null;
            CostcenterNo = null;
            Remarks = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully  Submitted"));
        } else {
            FacesMessage msg = new FacesMessage("Please add a Invoice ");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public ArrayList<Ventry> getentryData(String region) {
         
        ArrayList<Ventry> emplist = new ArrayList<Ventry>();
        try {
            boolean found = false;
             Connection con = DataConnect.getConnection();
            PreparedStatement  ps=con.prepareStatement("getentrylist '" + DDSNo + "', '" + CourierNo + "'");
            ResultSet rs;
            rs = ps.executeQuery();  
            while (rs.next()) {
                Ventry e = new Ventry();
                e.setReceipID(rs.getString(1));
                e.setInvoiceNo(rs.getString(2));
                e.setVenderName(rs.getString(3));
                e.setInvoiceDate(rs.getDate(4));
                e.setBillAmount(rs.getString(5));
                e.setCostcenter(rs.getString(7));
                e.setCostcenterNo(rs.getString(8));
                e.setInvoiceType(rs.getString(9));
                e.setDocType(rs.getString(10));
                e.setPONo(rs.getString(12));
                e.setRemarks(rs.getString(13));
                e.setINVD(rs.getString(16));
                e.setINVNO(rs.getString(17));
                e.setVNAD(rs.getString(18));
                e.setAI(rs.getString(21));
                e.setPANNO(rs.getString(29));
                emplist.add(e);
                found = true;
                save = found;
            }
            rs.close();            
            ps.close();
            con.close();
            if (found) {
                return emplist;
            } else {
                return null; // no entires found
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
            return (null);
        }

    }

     public String CheckInvoice(String InvoiceNo, String vendor) {

        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs ;
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
        }finally {
            
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
    
     public List<String> completeCourier(String query) {
           
                List<String> filteredCourier = new ArrayList<String>();
                List<String> list = new ArrayList<String>();
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("getcourier '" + query + "'");
            ResultSet rs;
            rs = ps.executeQuery(); 
            
            while (rs.next()) {                 
                String email=rs.getString(1);
                list.add(email);
            }
            for (int i = 0; i < list.size(); i++) {
                String skin = list.get(i);
                if (skin.toLowerCase().startsWith(query)||skin.toUpperCase().startsWith(query)) {
                    filteredCourier.add(skin);
                }
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception..." + ex.getMessage());
        }
        return filteredCourier;

    }
    
     

}
