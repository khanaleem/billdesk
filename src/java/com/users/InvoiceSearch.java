/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.dao.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@RequestScoped
@ApplicationScoped

public class InvoiceSearch {

    private List<InvoiceSearch> filtered;

    public List<InvoiceSearch> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<InvoiceSearch> filtered) {
        this.filtered = filtered;
    }

    public LinkedList<InvoiceSearchBeans> getInvData(String region, String role) {

        LinkedList<InvoiceSearchBeans> emplist = new LinkedList<InvoiceSearchBeans>();
        try {
            boolean found = false;
            String STR = null;
            Connection con = DataConnect.getConnection();
            if (role.equals("u") || role.equals("m")) {
                STR = "Searchinward '" + region.trim() + "'";
            } else if (role.equals("s") || role.equals("a")) {
                STR = "Searchinward 'a'";
            }

            PreparedStatement ps = con.prepareStatement(STR);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                InvoiceSearchBeans e = new InvoiceSearchBeans();
                e.setReceiptID(rs.getInt(1));
                e.setInvoiceNumber(rs.getString(2));
                e.setVenderName(rs.getString(3));
                e.setPONumber(rs.getString(4));
                e.setReceivingDate(rs.getDate(5));
                e.setDDSNo(rs.getString(6));
                e.setCourierName(rs.getString(7) + e.getDDSNo());
                e.setSenderName(rs.getString(8));
                e.setSenderNo(rs.getString(9));
                e.setAPNo(rs.getString(10));
                e.setRegion(rs.getString(11));
                e.setAmount(rs.getString(12));
                emplist.add(e);
                found = true;
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

}
