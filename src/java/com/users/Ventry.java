/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;
 
import java.io.Serializable; 
import java.util.Date;   
/**
 *
 * @author Hriday Dubey
 */ 
public class Ventry implements Serializable {

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
    String NoOfInvoice = null;
    Date InvoiceDate = new Date();
    String venderName;
    String PoCategory = null;
    String PONo;
    String billAmount = null;
    String Costcenter = null;
    String CostcenterNo = null;
    String Remarks = null; 
    String ReceipID = null; 
    

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

    public String getReceipID() {
        return ReceipID;
    }

    public void setReceipID(String ReceipID) {
        this.ReceipID = ReceipID;
    }


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

     
 
   
}
