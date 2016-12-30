package Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores;


import java.time.LocalDateTime;

public class SMorador extends AConta
{
    private LocalDateTime dataDeResidencia;
    private String nome;

    public SMorador(String Username,
                    String Password,
                    LocalDateTime DataDeResidencia,
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
    
    public LocalDateTime buscaDataDeResidencia (){
        return this.dataDeResidencia;
    }
}