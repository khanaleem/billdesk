/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

/**
 *
 * @author Hriday Dubey
 */

import com.admin.InvoiceReportBean;
import com.dao.DataConnect;
import java.sql.*;
import java.util.ArrayList;
 
public class InvoiceReport {
    
public static ArrayList<InvoiceReportBean> getInvoiceReport() {
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(""
//                    + "select * from invoicereport ORDER BY ReceiptID"
                    + "");
            ArrayList<InvoiceReportBean> al = new ArrayList<InvoiceReportBean>();
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                InvoiceReportBean e = new InvoiceReportBean();
                e.setReceiptID(rs.getString(1));
                e.setInvoiceNo(rs.getString(2));
                e.setVenderName(rs.getString(3));
                e.setInvoiceAmount(rs.getString(4));
                e.setRegion(rs.getString(5));
                e.setPoCategory(rs.getString(6));
                e.setComName(rs.getString(7));
                e.setReciDate(rs.getDate(8));
                e.setAPNo(rs.getString(9));
                al.add(e);
                found = true;
            }
            rs.close();
             
            con.close();
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
        } catch (Exception e) {
            System.out.println("Error In getCustomer() -->" + e.getMessage());
            return (null);
        }
    }
}
