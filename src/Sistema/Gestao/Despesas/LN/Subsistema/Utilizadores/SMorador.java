package Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores;


import java.sql.Timestamp;

public class SMorador extends AConta
{
    private Timestamp dataDeResidencia;
    private String nome;

    public SMorador(String Username,
                    String Password,
                    Timestamp DataDeResidencia,
                    String Nome)
    {
        super(Username, Password);
        dataDeResidencia=DataDeResidencia;
        nome=Nome;
    }

    public String buscaNome() 
    {
    	return this.nome;
    }
    
    public Timestamp buscaDataDeResidencia (){
        return this.dataDeResidencia;
    }
}