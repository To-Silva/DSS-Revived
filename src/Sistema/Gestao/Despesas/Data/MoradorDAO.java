/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Gestao.Despesas.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Sistema.Gestao.Despesas.SQL.Connector;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SMorador;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author Andre
 */
public class MoradorDAO implements Map<String,SMorador> 
{

    @Override
    public int size() 
    {
        int size = -1;
        Connection con = null;
        try 
        {
            con = Connector.connect();
            PreparedStatement ps = con.prepareStatement("select count(Nome) from morador");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) 
            {
                size = rs.getInt(1);
            }
        } 
        catch (SQLException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                con.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SMorador get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SMorador put(String key, SMorador value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SMorador remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends SMorador> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<SMorador> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, SMorador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
