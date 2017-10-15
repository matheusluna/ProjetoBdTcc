/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Tcc;
import java.sql.SQLException;

/**
 *
 * @author Reginaldo
 */
public interface TccDaoIF {
    
    public void inserir(Tcc tcc)throws SQLException;
    
}
