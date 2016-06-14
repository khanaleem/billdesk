/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

/**
 *
 * @author Hriday Dubey
 */
 
import java.util.Date; 
 
public class InvoiceSearchBeans {   
    
   private long ReceiptID;
    private String InvoiceNumber;
    private String VenderName;
    private String PONumber;    
    private Date ReceivingDate;
    private String CourierName;
    private String DDSNo;
    private String SenderName;
    private String SenderNo;
    private String APNo;
    private String region;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    

    public String getPONumber() {
        return PONumber;
    }

    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }
    

    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public String getVenderName() {
        return VenderName;
    }

    public void setVenderName(String VenderName) {
        this.VenderName = VenderName;
    }
   
    public Date getReceivingDate() {
        return ReceivingDate;
    }

    public void setReceivingDate(Date ReceivingDate) {
        this.ReceivingDate = ReceivingDate;
    }

    public String getCourierName() {
        return CourierName;
    }

    public void setCourierName(String CourierName) {
        this.CourierName = CourierName;
    }

    public String getDDSNo() {
        if(DDSNo==null){
        DDSNo="";
        return DDSNo;
        }else{
        return DDSNo;
        }
        
    }

    public void setDDSNo(String DDSNo) {
        this.DDSNo = DDSNo;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
    }

    public String getSenderNo() {
        return SenderNo;
    }

    public void setSenderNo(String SenderNo) {
        this.SenderNo = SenderNo;
    }

    
    
    public String getAPNo() {
        return APNo;
    }

    public void setAPNo(String APNo) {
        this.APNo = APNo;
    }
    
     
}