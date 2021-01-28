/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.bl;

import com.fvgprinc.app.testgencode.be.DbArgsMetaBe;
import com.fvgprinc.app.testgencode.dl.DbSpMetaDataDl;
import com.fvgprinc.app.testgencode.utils.StringUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garfi
 */
public class JavaCodeGenertor extends PckLayerGenerator {

    public JavaCodeGenertor(String owner, String packageName, String methodName, String entityName) {
        super(owner, packageName, methodName, entityName);
        buildLstArgs();
    }

    @Override
    public void genEntityCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void genDataLayerCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void genBusinessLogicCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildLstLstDbMetaData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buildLstArgs() {
        DbSpMetaDataDl spMetaDataDl = new DbSpMetaDataDl();
        try {
            this.lstArgs = spMetaDataDl.loadParameters(this.getOwner(), this.getPackageName(),
                    this.getMethodName());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(JavaCodeGenertor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String varNameJavaStyle(String pstr) {
        String res;
        res = pstr.toLowerCase();
        res = StringUtils.InitAllCaps(res);
        res = res.replace("_", "");
        res = res.substring(0, 1).toLowerCase()+res.substring(1);

        return res;
    }

    public String routineNameJavaStyle() {
        String res;
        res = varNameJavaStyle(this.getMethodName());

        return res;
    }

    private String CnvTypeOracle2Java(String oracleType) {
        String res = "";
        if (oracleType.compareTo("VARCHAR") == 0 ||
            oracleType.compareTo("VARCHAR2") == 0) {
            res = "String";
        }

        if (oracleType.compareTo("NUMBER") == 0) {
            res = "BigDecimal";
        }

        if (oracleType.compareTo("DATE") == 0) {
            res = "Date";
        }

        return res;
    }

    public String javaStpParameters() {
        String res = "";
        String scrap;

        for (DbArgsMetaBe dam : this.lstArgs) {
            scrap = CnvTypeOracle2Java(dam.getDataType());
            res += (scrap + " ");
            scrap = varNameJavaStyle(dam.getArgName());
            res += (scrap + ";");
        }
        return res;
    }

    public String invokeCallStr() {
        String res = "";

        res = this.getPackageName() + "."
                + this.getMethodName();

        return res;
    }

    public String initStmtParams() {
        String res = null;
        String varStr = null;
        String typeStr = null;
        int ind = 1;

        for (DbArgsMetaBe dam : this.lstArgs) {
            varStr = varNameJavaStyle(dam.getArgName());
            typeStr = CnvTypeOracle2Java(dam.getDataType());
            res += "stm.set" + typeStr + "(" + Integer.toString(ind) + ", " + varStr + ");";
            ++ind;
        }
        return res;
    }

}
