/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Gestao.Despesas.Data;

import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.AConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Sistema.Gestao.Despesas.SQL.Connector;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SMorador;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SSenhorio;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        catch (SQLException e) 
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
        Connection con = null;
        try { 
            con = Connector.connect();    
            /**
            * Atualizar tabela Morador.
            */
            PreparedStatement ps = con.prepareStatement("INSERT INTO Morador (Nome,Data)\n" 
                                                        +"VALUES (?,?)\n");
            ps.setString(1, value.buscaNome());
            ps.setString(2, value.buscaDataDeResidencia().toString());
            ps.executeUpdate();       
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                value=null;
            }
        }       
        return value;
    }

    @Override
    public SMorador remove(Object o) {
         String nome=(String)o;
         Connection con = null;
        try { 
            con = Connector.connect();    
            /**
            * Atualizar tabela Morador.
            */
            PreparedStatement ps = con.prepareStatement("Update Morador (Nome,Data,Removido)\n"
                                                       +"SET Removido=?\n"
                                                       +"Where Nome=?\n");
            ps.setBoolean(1,true);
            ps.setString(2, nome);
            ps.executeUpdate();       
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        return null;
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
        int i=0;
        Set<String> res = null;
        String nome = null;
            Connection con = null;
            try 
            {
                con = Connector.connect();
                PreparedStatement ps = con.prepareStatement("select Nome from morador");
                ResultSet rs = ps.executeQuery();
                while(rs.next()) 
                {
                    nome = rs.getString(1);
                    res.add(nome);
                }
            } 
            catch (SQLException e) 
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
        return res;
    }

    @Override
    public Collection<SMorador> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, SMorador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SSenhorio buscaSenhorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizaSenhorio(SSenhorio Senhorio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AConta Login(String Utilizador, String Password) {
        int i=0;
        AConta res = null;
        Connection con = null;
        String Morador=null;
        String Senhorio=null;
        try 
        {
            con = Connector.connect();
            PreparedStatement ps = con.prepareStatement("select Morador,Senhorio from conta where Username=? and Password=?");
            ps.setString(0, Utilizador);
            ps.setString(1, Password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) 
                {
                    Morador = rs.getString(1);
                    Senhorio = rs.getString(2);
                }
            } 
            if Morador!=null || Senhorio !=null)
            {
                if (Morador!=null)
                {
                    PreparedStatement ps2 = con.prepareStatement("select Data,Removido from Morador where Nome=?")
                    ps2.setString(1,Morador);
                    ResultSet rs2= ps.executeQuery();
                    
                }
            }
        }
        catch (SQLException e) 
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
        return res;
    }
}
