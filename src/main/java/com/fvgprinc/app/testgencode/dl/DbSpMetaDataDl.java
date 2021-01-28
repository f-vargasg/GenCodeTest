/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fvgprinc.app.testgencode.dl;

import com.fvgprinc.app.testgencode.be.DbArgsMetaBe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author garfi
 */
public class DbSpMetaDataDl {

    public ArrayList<DbArgsMetaBe> loadParameters(String pOwner, String pPackageName,
            String pMethodName) throws SQLException {
        ArrayList<DbArgsMetaBe> res = new ArrayList<>();
        String query
                = "SELECT a.owner, a.position, a.package_name, a.object_name as method ,a.argument_name, \n"
                + "a.data_type, a.in_out\n"
                + "FROM all_arguments a\n"
                + "WHERE  a.object_name = upper(?) AND \n"
                + "a.package_name = upper(?)\n"
                + "and a.owner = upper(?)\n"
                + "ORDER BY A.package_name, A.OBJECT_NAME, A.POSITION";
        Connection conn = Conexion.getInstance().getConn();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pMethodName);
            stmt.setString(2, pPackageName);
            stmt.setString(3, pOwner);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DbArgsMetaBe argsMeta = new DbArgsMetaBe(rs.getString("owner"),
                        rs.getInt("position"),
                        rs.getString("package_name"),
                        rs.getString("method"),
                        rs.getString("argument_name"),
                        rs.getString("data_type"),
                        rs.getString("in_out"));
                res.add(argsMeta);
            }
        }
        return res;
    }


/* 
    private void loadResultMetaData() {

    }*/
}
