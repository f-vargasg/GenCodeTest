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

    public static final String ENTITY_VAR = "<$entVar>";
    public static final String FLDNAME_1UPPER = "<$fldName1Upper>";
    public static final String FLDNAME_VAR = "<$fldName>";
    public static final String TYPEGET_VAR = "<$typeGet>";
    public static final String JAVATYPE = "<$javaType>";
    public static final String ZLOWERFLD = "<$lowerFld>";
    public static final String STM_FILLENTITY = ENTITY_VAR + ".set" + FLDNAME_1UPPER + "(rs.get" + TYPEGET_VAR + "(\"" + FLDNAME_VAR + "\"));";
    public static final String STM_ATTRENTITY = JAVATYPE + " " + ZLOWERFLD + ";";

    public JavaCodeGenertor(String owner, String packageName, String methodName, String entityName) {
        super(owner, packageName, methodName, entityName);
        buildLstArgs();
    }
    
    @Override
    public String cnvtParamtDbType2LangParamType(String pDbType) {
        String res;
        if (pDbType.compareTo("CHAR") == 0
                || pDbType.compareTo("VARCHAR2") == 0) {
            res = "String";
        } else if (pDbType.compareTo("NUMBER") == 0) {
            res = "String";
        } else if (pDbType.compareTo("DATE") == 0) {
            res = "Date";
        } else {
            res = StringUtils.EMPTYSTR;
        }
        return res;
    }

    @Override
    public void genEntityCode() {

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
        res = res.substring(0, 1).toLowerCase() + res.substring(1);

        return res;
    }

    public String routineNameJavaStyle() {
        String res;
        res = varNameJavaStyle(this.getMethodName());

        return res;
    }

    

    @Override
    public String cnvTypeOracle2Java(String oracleType) {
        String res = StringUtils.EMPTYSTR;
        if (oracleType.compareTo("VARCHAR") == 0
                || oracleType.compareTo("VARCHAR2") == 0) {
            res = "String";
        } else if (oracleType.compareTo("NUMBER") == 0) {
            res = "BigDecimal";
        } else  if (oracleType.compareTo("DATE") == 0) {
            res = "Date";
        }

        return res;
    }

    public String javaStpParameters() {
        String res = "";
        String scrap;

        for (DbArgsMetaBe dam : this.lstArgs) {
            scrap = cnvTypeOracle2Java(dam.getDataType());
            res += (scrap + " ");
            scrap = varNameJavaStyle(dam.getArgName());
            res += (scrap + ";");
        }
        return res;
    }

    public String invokeCallStr() {
        String res = StringUtils.EMPTYSTR;

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
            typeStr = cnvTypeOracle2Java(dam.getDataType());
            res += "stm.set" + typeStr + "(" + Integer.toString(ind) + ", " + varStr + ");";
            ++ind;
        }
        return res;
    }

}
