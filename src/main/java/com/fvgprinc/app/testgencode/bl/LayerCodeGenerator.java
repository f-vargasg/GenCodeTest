/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.bl;

/**
 *
 * @author garfi
 */
interface LayerCodeGenerator {
   
   public String cnvtParamtDbType2LangParamType(String pDbType);
   
   public String cnvTypeOracle2Java(String oracleType);
    
   public void genEntityCode();
   
   public void genDataLayerCode();
   
   public void genBusinessLogicCode();
}
