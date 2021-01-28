/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author garfi
 */
public class Conexion {
        private Connection conn = null;
    private boolean openConn = false;
    private int numOpenConns = 0;
    private int cantInvGetConn = 0;

    /**
     * Get the value of cantInvGetConn
     *
     * @return the value of cantInvGetConn
     */
    public int getCantInvGetConn() {
        return cantInvGetConn;
    }


    /**
     * Get the value of numOpenConns
     *
     * @return the value of numOpenConns
     */
    public int getNumOpenConns() {
        return numOpenConns;
    }


    public Connection getConn() {
        ++this.cantInvGetConn;
        return conn;
    }
    
    private  Conexion() {
        try {
            String jdbcDriverStr = "oracle.jdbc.driver.OracleDriver";
           // Class.forName("org.mariadb.jdbc.Driver");
           Class.forName(jdbcDriverStr);
           // conn =  DriverManager.getConnection("jdbc:mariadb://10.25.1.80:3306/dbTest1", "fvargas", "valerie5250");
           //String urlDb = "jdbc:oracle:thin:@(Pruebas3)";
           String urlDb = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS=(PROTOCOL=TCP)(HOST=10.25.1.85)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=orclcdb)))";
           conn =  DriverManager.getConnection(urlDb, "mytest", "oracle");
           this.openConn = true;
           ++this.numOpenConns;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean isOpenConn() {
        return openConn;
    }
    
    private static class ConexionClassHolder
    {
       static final Conexion SINGLE_INSTANCE = new Conexion();
    }
    
    public static Conexion getInstance()
    {
        return ConexionClassHolder.SINGLE_INSTANCE;
    }
    
    /*
    private Connection getConexion() {
            
        try {
           Class.forName("org.mariadb.jdbc.Driver");
           conn =  DriverManager.getConnection("jdbc:mariadb://10.25.1.80:3306/dbTest1", "fvargas", "valerie5250");
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return conn;
    }
*/    
}
