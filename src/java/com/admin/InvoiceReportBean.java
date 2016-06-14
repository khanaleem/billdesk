/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import java.util.Date;
import com.admin.InvoiceReport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@SessionScoped
public class InvoiceReportBean {
    private String ReceiptID;
   private String InvoiceNo;
   private String venderName;
   private String InvoiceAmount;
   private String Region;
   private String PoCategory;
   private String ComName;
   private Date ReciDate;
   private String APNo; 

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
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(String InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getPoCategory() {
        return PoCategory;
    }

    public void setPoCategory(String PoCategory) {
        this.PoCategory = PoCategory;
    }

    public String getComName() {
        return ComName;
    }

    public void setComName(String ComName) {
        this.ComName = ComName;
    }

    public Date getReciDate() {
        return ReciDate;
    }

    public void setReciDate(Date ReciDate) {
        this.ReciDate = ReciDate;
    }

    public String getAPNo() {
        return APNo;
    }

    public void setAPNo(String APNo) {
        this.APNo = APNo;
    }
   
    public ArrayList<InvoiceReportBean> getMessages() {
        return InvoiceReport.getInvoiceReport();
    }
}
