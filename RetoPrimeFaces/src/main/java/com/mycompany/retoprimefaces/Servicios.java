/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.retoprimefaces;

/**
 *
 * @author Andrei MR
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Servicios implements InterfacePF {

    @Override
    public boolean guardarUsuario(String usuario) {
        
        boolean guardado = false;
       String connectionUrl = "jdbc:sqlserver://186.176.127.226:53322;databaseName=ejemplopf;user=sa;password=sa";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            int qry = stmt.executeUpdate("INSERT INTO dbo.usuarios VALUES ('" + usuario + "')");
            if (qry == 1) {//Si ha sido guardado 
                guardado = true; 
            } 
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return guardado;
    }

    
    
    
}
