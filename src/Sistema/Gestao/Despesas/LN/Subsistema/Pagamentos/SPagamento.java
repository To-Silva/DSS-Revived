package Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos;


import java.time.LocalDateTime;

public class SPagamento 
{
	private LocalDateTime Data;
	private float valor;
	private String nome;
	private LocalDateTime DataPagamento;

    public SPagamento(LocalDateTime Data, float Valor) 
    {
        this.Data=Data;
        valor=Valor;
        nome=null;
        DataPagamento=null;
    }

    public boolean atualizaPagamento() 
    {
        this.DataPagamento=LocalDateTime.now();
        return true;
    }
        
        public boolean buscaPago(){
            return DataPagamento!=null;
        }
        
        public float buscaValor(){
            return this.valor;
        }
        
        public LocalDateTime buscaData(){
            return this.Data;
        }
        
        public LocalDateTime buscaDataPagamento(){
            return this.DataPagamento;
        }        
        
        public String buscaNome (){
            return this.nome;
        }
    
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append(Data.toString()).append(": Valor a pagar := ")
                                  .append(valor);
        if (DataPagamento!=null) 
        {
            sb.append(". Paga por:").append(nome).append(" em ").append(DataPagamento.toString());
        }
        return sb.toString();
    }
}
