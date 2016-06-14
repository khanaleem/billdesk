/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users;

import com.dao.DataConnect;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class UserChart implements Serializable {

    private PieChartModel pieModel1;

    long DishInfra;
    long DishTV;
    long Cyquator;
    long SitiCable;
    long Ebex;
    long ZEEL;
    long ZLL;
    long ZMCL;
    long LEEL;

    public long getDishInfra() {
        return DishInfra;
    }

    public void setDishInfra(long DishInfra) {
        this.DishInfra = DishInfra;
    }

    public long getDishTV() {
        return DishTV;
    }

    public void setDishTV(long DishTV) {
        this.DishTV = DishTV;
    }

    public long getCyquator() {
        return Cyquator;
    }

    public void setCyquator(long Cyquator) {
        this.Cyquator = Cyquator;
    }

    public long getSitiCable() {
        return SitiCable;
    }

    public void setSitiCable(long SitiCable) {
        this.SitiCable = SitiCable;
    }

    public long getEbex() {
        return Ebex;
    }

    public void setEbex(long Ebex) {
        this.Ebex = Ebex;
    }

    public long getZEEL() {
        return ZEEL;
    }

    public void setZEEL(long ZEEL) {
        this.ZEEL = ZEEL;
    }

    public long getZLL() {
        return ZLL;
    }

    public void setZLL(long ZLL) {
        this.ZLL = ZLL;
    }

    public long getZMCL() {
        return ZMCL;
    }

    public void setZMCL(long ZMCL) {
        this.ZMCL = ZMCL;
    }

    public long getLEEL() {
        return LEEL;
    }

    public void setLEEL(long LEEL) {
        this.LEEL = LEEL;
    }
    
    private final Date currentDate = new Date();
    String ChekCompany;
    String region;

    LineChartModel animatedModel1;
    private BarChartModel animatedModel2;

    @PostConstruct

    public void init() {
        createPieModels();
        createAnimatedModels1();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    private void createPieModels() {
        createPieModel1();
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        CompanyCountgraph();
        pieModel1.set("DishTV", DishTV);
        pieModel1.set("DishInfra", DishInfra);
        pieModel1.set("Cyquator", Cyquator);
        pieModel1.set("Ebex", Ebex);
        pieModel1.set("LEEL", LEEL);
        pieModel1.set("SitiCable", SitiCable);
        pieModel1.set("ZLL", ZLL);
        pieModel1.set("ZEEL", ZEEL);
        pieModel1.set("ZMCL", ZMCL);
        pieModel1.setTitle("Total Inward Count By Company");
        pieModel1.setShowDataLabels(true); 
        pieModel1.setLegendPosition("E");
    }

    public void CompanyCountgraph() {

        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                if (ChekCompany("Dish TV") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Dish TV'");
                    rs = ps.executeQuery();
                    rs.next();
                    DishTV = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Dish Infra") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Dish Infra'");
                    rs = ps.executeQuery();
                    rs.next();
                    DishInfra = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("cyquator") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'cyquator'");
                    rs = ps.executeQuery();
                    rs.next();
                    Cyquator = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Ebex") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Ebex'");
                    rs = ps.executeQuery();
                    rs.next();
                    Ebex = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("LEEL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'LEEL'");
                    rs = ps.executeQuery();
                    rs.next();
                    LEEL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("Siti Cable") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'Siti Cable'");
                    rs = ps.executeQuery();
                    rs.next();
                    SitiCable = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZLL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZLL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZLL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZEEL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZEEL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZEEL = rs.getLong(2);
                    ChekCompany = null;
                }
                if (ChekCompany("ZMCL") != null) {
                    ps = con.prepareStatement("CheckCompanyCountgraph 'ZMCL'");
                    rs = ps.executeQuery();
                    rs.next();
                    ZMCL = rs.getLong(2);
                    ChekCompany = null;
                }
              con.close();
            }
            
        } catch (SQLException sqle) {
            sqle.getErrorCode();
        }finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
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

    public LineChartModel createAnimatedModels(String reg) {
        region=reg;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String CDate = format.format(currentDate);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        String cDate = format.format(cal.getTime());
        animatedModel1 = initLinearModel(); 
        animatedModel1.setAnimate(true);
        animatedModel1.setZoom(true);
        animatedModel1.setLegendPosition("w");
        animatedModel1.getAxis(AxisType.Y).setLabel("Count");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-40);
        axis.setMin(cDate);
        axis.setMax(CDate);
        axis.setTickFormat("%b %#d, %y");
        animatedModel1.getAxes().put(AxisType.X, axis);
        return animatedModel1;
    }
    
    private void createAnimatedModels1() {
         
         
        animatedModel2 = initBarModel(); 
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0); 
    }
    
     private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel(); 
        ChartSeries AP = new ChartSeries();
        AP.setLabel("AP");
        ChartSeries Inward = new ChartSeries();
        Inward.setLabel("Inward");
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DataConnect.getConnection();
            String sql = "exec regionalinwardGraph ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AP.set(rs.getString(1), rs.getLong(3));
                Inward.set(rs.getString(1), rs.getLong(2));
            }
            model.addSeries(AP);
            model.addSeries(Inward);
            con.close();

        } catch (SQLException sqle) {
            sqle.getErrorCode();
        }finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
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
         
  
         
        return model;
    }


    public LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries AP = new LineChartSeries();
        AP.setLabel("AP");
        LineChartSeries Inward = new LineChartSeries();
        Inward.setLabel("Inward");
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DataConnect.getConnection();
            String sql = "exec apgraph '" + region + "' ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AP.set(rs.getString(1), rs.getLong(3));
                Inward.set(rs.getString(1), rs.getLong(2));
            }
            model.addSeries(AP);
            model.addSeries(Inward);
            con.close();

        } catch (SQLException sqle) {
            sqle.getErrorCode();
        }finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
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

        return model;
    }
    
   
    public String ChekCompany(String Company) {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "CheckCompanyCountgraph '" + Company + "'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rs.next();
                ChekCompany = rs.getString(1);
                con.close();
            }

            
        } catch (SQLException sqle) {
            sqle.getErrorCode();
        }finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        /* ignored */
                    }
                }
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

        return ChekCompany;
    }

    
    
     
     
}
