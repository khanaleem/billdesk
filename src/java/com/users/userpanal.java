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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Hriday Dubey
 */
@ManagedBean
@ViewScoped
public class userpanal implements Serializable{

    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    Date FReciDate=new Date(System.currentTimeMillis() - (7 * DAY_IN_MS));
    Date TReciDate= new Date();
    
    
     
    private String CheckVender;
    private String region;     
    private Date currentDate = new Date();

     
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

    public Date getFReciDate() {
        return FReciDate;
    }

    public void setFReciDate(Date FReciDate) {
        this.FReciDate = FReciDate;
    }

    public Date getTReciDate() {
        return TReciDate;
    }

    public void setTReciDate(Date TReciDate) {
        this.TReciDate = TReciDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
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
    
    
    public void Search(Date F , Date T) {
        FReciDate=F;
        TReciDate=T;
    }
    
     
    public  LinkedList<userpanal> getInvData(String user)
    {     Region(user);    
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String FR=format.format(FReciDate);
        String TR=format.format(TReciDate);
        LinkedList<userpanal> emplist=new LinkedList<userpanal>();
        try
        {    boolean found = false;        
            Connection con=DataConnect.getConnection();
            Statement st=con.createStatement();                            
            ResultSet rs=st.executeQuery("select * from invoicereceivingdetail where ReceivingDate BETWEEN '"+FR+"' AND '"+TR+"' ORDER BY ReceiptID ");
            while(rs.next())
            {
                userpanal e=new userpanal();
                e.setReceiptID(rs.getInt(1));
                e.setInvoiceNumber(rs.getString(2));
                e.setVenderName(rs.getString(3));
                e.setPONumber(rs.getString(4));
                e.setReceivingDate(rs.getDate(5));
                e.setDDSNo(rs.getString(6));
                e.setCourierName(rs.getString(7)+e.getDDSNo());
                e.setSenderName(rs.getString(8));
                e.setSenderNo(rs.getString(9));
                e.setAPNo(rs.getString(10));
                emplist.add(e);
                found = true;
            }
           rs.close();
            st.close();
            con.close();
            if (found) {
                return emplist;
            } else {
                return null; // no entires found
            }
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception..."+ex.getMessage());
            return (null);
        }
        
    }


     public String Region(String uName) {
        if (uName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            ResultSet rs = null;
            try {
                con = DataConnect.getConnection();
                if (con != null) {
                    String sql = "select * from Users a inner join password b on a.userindex=b.userindex where username = '" + uName + "'";
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    rs.next();
                    region = rs.getString("region");
                    System.out.print(region.trim());

                }
                rs.close();
           
            con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        return region;
    }
     
     
     public static void main(String[] args) {
         long DAY_IN_MS = 1000 * 60 * 60 * 24;

        Date c7=new Date(System.currentTimeMillis() - (7 * DAY_IN_MS));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
       String cs=format.format(c7);  
             System.out.println(c7);   
    }

}

