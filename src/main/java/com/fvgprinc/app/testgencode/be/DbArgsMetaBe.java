/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.be;

/**
 *
 * @author garfi
 */
public class DbArgsMetaBe {

    private String owner;
    private int position;
    private String packageName;
    private String method;
    private String argName;
    private String dataType;
    private String inOut;
    private boolean defaultValue;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    

    public DbArgsMetaBe(String owner, int position, String packageName, String method, String argName, String dataType,
                      String inOut, boolean defaultValue) {
        this.owner = owner;
        this.position = position;
        this.packageName = packageName;
        this.method = method;
        this.argName = argName;
        this.dataType = dataType;
        this.inOut = inOut;
        this.defaultValue = defaultValue;
    }









}
