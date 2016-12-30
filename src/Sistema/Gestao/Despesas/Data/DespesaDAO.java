package Sistema.Gestao.Despesas.Data;

import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.ADespesa;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.SDespesaLocal;
import Sistema.Gestao.Despesas.SQL.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DespesaDAO implements Map<String,ADespesa[]> {

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

    public ADespesa put(String nome, ADespesa value) {
        try { 
            Connection con = null;
            con = Connector.connect();    
            /**
            * Atualizar tabela Despesa.
            */
            PreparedStatement ps = con.prepareStatement("INSERT INTO Despesa (Data,bOcasional,EstadoDespesa,bLocal)\n" 
                                                        +"VALUES (?,?,?,?)\n"
                                                        +"ON DUPLICATE KEY UPDATE EstadoDespesa=VALUES(EstadoDespesa)");
            ps.setString(1, (value.buscaData()).toString());
            ps.setBoolean(2, value.buscaOcasional());
            ps.setString(3, value.buscaEstado().toString());
            ps.setBoolean(4, value.buscaLocal());
            ps.executeUpdate();       
            
            if (value instanceof SDespesaLocal) {          
                    /**
                    * Atualizar tabela MoradorDespesa.
                    */

                    PreparedStatement ps2 = con.prepareStatement("INSERT INTO MoradorDespesa (Nome,Despesa,votoRemover,votoValidar)\n" 
                                                                +"VALUES (?,?,?,?)\n");
                    ps2.setString(1, nome);
                    ps2.setString(2, value.buscaData().toString());
                    ps2.setBoolean(3, false);
                    ps2.setBoolean(4, false);
                    ps2.executeUpdate();
            } 
            /**
            * Atualizar tabela MoradorDespesaPagamento.
            */            
            PreparedStatement ps3 = con.prepareStatement("INSERT INTO Pagamento (Data,Valor,DataPagamento,Nome)\n" 
                                                        +"VALUES (?,?,?,?)\n");
            ps3.setString(1, value.buscaPagamento(nome).toString());
            ps3.setFloat(2, value.buscaPagamento(nome).buscaValor());
            ps3.setString(3, value.buscaPagamento(nome).buscaDataPagamento().toString());
            ps3.setString(4, value.buscaPagamento(nome).buscaNome());
            ps3.executeUpdate();    
            
            /**
            * Atualizar tabela MoradorDespesaPagamento.
            */            
            PreparedStatement ps4 = con.prepareStatement("INSERT INTO MoradorDespesaPagamento (Nome,Despesa,Pagamento)\n" 
                                                        +"VALUES (?,?,?)\n");
            ps4.setString(1, nome);
            ps4.setString(2, value.buscaData().toString());
            ps4.setString(3, value.buscaPagamento(nome).buscaData().toString());
            ps4.executeUpdate();                 
            
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           Connect.close(con);
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
