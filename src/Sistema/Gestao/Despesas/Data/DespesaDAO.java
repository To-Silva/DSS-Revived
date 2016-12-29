package Sistema.Gestao.Despesas.Data;

import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.ADespesa;
import Sistema.Gestao.Despesas.SQL.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DespesaDAO implements Map<String,ADespesa> {

    @Override
    public int size() 
    {
        int size = -1;
        Connection con = null;
        try 
        {
            con = Connector.connect();
            PreparedStatement ps = con.prepareStatement("select count(Data) from Despesa");
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
    public ADespesa get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ADespesa put(String key, ADespesa value) {
         Connection con = null;
        try {
            
            con = Connector.connect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Despesa (Data,bOcasional,EstadoDespesa,bLocal)\n" 
                                                        +"VALUES (?,?,?,?)\n"
                                                        +"ON DUPLICATE KEY UPDATE EstadoDespesa=VALUES(EstadoDespesa)");
            ps.setString(1, (value.buscaData()).toString());
            ps.setBoolean(2, value.buscaOcasional());
            ps.setString(3, value.buscaEstado().toString());
            ps.setBoolean(4, value.buscaLocal());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connector.close(con);
        }
        return value;
    }

    @Override
    public ADespesa remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends ADespesa> m) {
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
    public Collection<ADespesa> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, ADespesa>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}