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
import javax.faces.bean.ApplicationScoped;  
@ManagedBean
@RequestScoped
@ApplicationScoped
public class DisputedInvoice {
    
    private String ReceiptID=null;
    private String InvoiceNo;
    private String VenderName;
    private String Remarks; 
    boolean INVD;
    boolean INVNO;
    boolean VNAD;
    boolean CNAD;
    boolean STSBC;
    boolean AI;
    boolean IVMPO;
    boolean NPOCWPC;
    boolean NPONEVC;
    boolean NPOASIN;
    boolean PONOA;
    boolean POR2K;
    boolean POVSIN;
    boolean PANNO;
    boolean STTIN;

    private List<DisputedInvoice> filteredck;

    public List<DisputedInvoice> getFilteredck() {
        return filteredck;
    }

    public void setFilteredAP(List<DisputedInvoice> filteredck) {
        this.filteredck = filteredck;
    }

    public String getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(String ReceiptID) {
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

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

     

    public String getINVD() {
        if (INVD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
        
    }
     


    public void setINVD(boolean INVD) {
        this.INVD = INVD;
    }

    public String getINVNO() {
     
        if (INVNO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setINVNO(boolean INVNO) {
        this.INVNO = INVNO;
    }

    public String getVNAD() {
         
        if (VNAD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setVNAD(boolean VNAD) {
        this.VNAD = VNAD;
    }

    public String getCNAD() {
          
        if (CNAD==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setCNAD(boolean CNAD) {
        this.CNAD = CNAD;
    }

    public String getSTSBC() {
         
        if (STSBC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setSTSBC(boolean STSBC) {
        this.STSBC = STSBC;
    }

    public String getAI() {
         
        if (AI==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setAI(boolean AI) {
        this.AI = AI;
    }

    public String getIVMPO() {
      
        if (IVMPO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setIVMPO(boolean IVMPO) {
        this.IVMPO = IVMPO;
    }

    public String getNPOCWPC() {
        
        if (NPOCWPC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPOCWPC(boolean NPOCWPC) {
        this.NPOCWPC = NPOCWPC;
    }

    public String getNPONEVC() {
         
        if (NPONEVC==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPONEVC(boolean NPONEVC) {
        this.NPONEVC = NPONEVC;
    }

    public String getNPOASIN() {
     
        if (NPOASIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setNPOASIN(boolean NPOASIN) {
        this.NPOASIN = NPOASIN;
    }

    public String getPONOA() {
         
        if (PONOA==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPONOA(boolean PONOA) {
        this.PONOA = PONOA;
    }

    public String getPOR2K() {
         
        if (POR2K==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPOR2K(boolean POR2K) {
        this.POR2K = POR2K;
    }

    public String getPOVSIN() {
         
        if (POVSIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPOVSIN(boolean POVSIN) {
        this.POVSIN = POVSIN;
    }

    public String getPANNO() {
         
        if (PANNO==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setPANNO(boolean PANNO) {
        this.PANNO = PANNO;
    }

    public String getSTTIN() {
         
        if (STTIN==true){
            return "\u2714";
        }else{
            return "\u2717";
        }
    }

    public void setSTTIN(boolean STTIN) {
        this.STTIN = STTIN;
    }

    public List<DisputedInvoice> getckData(String region) {
      
        List<DisputedInvoice> aplist = new LinkedList<DisputedInvoice>();
        try {
             Connection con = DataConnect.getConnection();
            PreparedStatement  ps=con.prepareStatement("inwardcheck '" + region.trim() + "'");
            ResultSet rs;
            rs = ps.executeQuery(); 
            while (rs.next()) {
                DisputedInvoice ap = new DisputedInvoice();
                ap.setReceiptID(rs.getString(1));
                ap.setInvoiceNo(rs.getString(2));
                ap.setVenderName(rs.getString(3));                
                ap.setINVD(rs.getBoolean(4));
                ap.setINVNO(rs.getBoolean(5));
                ap.setVNAD(rs.getBoolean(6));
                ap.setCNAD(rs.getBoolean(7));
                ap.setSTSBC(rs.getBoolean(8));
                ap.setAI(rs.getBoolean(9));
                ap.setIVMPO(rs.getBoolean(10));
                ap.setNPOCWPC(rs.getBoolean(11));
                ap.setNPONEVC(rs.getBoolean(12));
                ap.setNPOASIN(rs.getBoolean(13));
                ap.setPONOA(rs.getBoolean(14));
                ap.setPOR2K(rs.getBoolean(15));
                ap.setPOVSIN(rs.getBoolean(16));
                ap.setPANNO(rs.getBoolean(17));
                ap.setSTTIN(rs.getBoolean(18));
                ap.setRemarks(rs.getString(19));
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

  

}
