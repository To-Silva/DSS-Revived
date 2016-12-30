package Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos;


import java.time.LocalDateTime;

public class SPagamento {
	private LocalDateTime Data;
	private float valor;
	private String[] nomes;
	private LocalDateTime DataPagamento;

	public boolean atualizaPagamento() {
            this.DataPagamento=LocalDateTime.now();
            return true;
	}
        
        public boolean buscaPago(){
            return DataPagamento!=null;
        }
}
