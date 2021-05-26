/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.retoprimefaces;

import javax.ejb.Local;

/**
 *
 * @author Andrei MR
 */

@Local
public interface InterfacePF {
    
    public boolean guardarUsuario (String usuario) throws Exception;
}
