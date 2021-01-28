/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.bl;

import com.fvgprinc.app.testgencode.be.DbArgsMetaBe;
import com.fvgprinc.app.testgencode.be.DbFldsMeta;
import java.util.ArrayList;

/**
 *
 * @author garfi
 */
public abstract class PckLayerGenerator implements LayerCodeGenerator {

   private String owner;
   
   private String packageName;
   
   private String methodName;
    
    private String entityCode;

    private String dataLayerCode;

    private String businesLogicCode;

    ArrayList<DbArgsMetaBe> lstArgs;
    
    ArrayList<DbFldsMeta> lstDbMetaData;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
   

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getDataLayerCode() {
        return dataLayerCode;
    }

    public void setDataLayerCode(String dataLayerCode) {
        this.dataLayerCode = dataLayerCode;
    }

    public String getBusinesLogicCode() {
        return businesLogicCode;
    }

    public void setBusinesLogicCode(String businesLogicCode) {
        this.businesLogicCode = businesLogicCode;
    }

    public ArrayList<DbFldsMeta> getLstDbMetaData() {
        return lstDbMetaData;
    }

    public void setLstDbMetaData(ArrayList<DbFldsMeta> lstDbMetaData) {
        this.lstDbMetaData = lstDbMetaData;
    }

    public ArrayList<DbArgsMetaBe> getLstArgs() {
        return lstArgs;
    }

    public void setLstArgs(ArrayList<DbArgsMetaBe> lstArgs) {
        this.lstArgs = lstArgs;
    }
    

    public PckLayerGenerator(String owner, String packageName, String methodName, 
                             String entityName)  {
        this.owner = owner;
        this.packageName = packageName;
        this.methodName = methodName;
        this.entityCode = entityName;
    }
    
    public abstract void buildLstArgs();
    

    /*
        Construye dependiendo del lenguaje la lista de campos retornados
        por el paquete
    */
    public abstract void buildLstLstDbMetaData();

    

}
