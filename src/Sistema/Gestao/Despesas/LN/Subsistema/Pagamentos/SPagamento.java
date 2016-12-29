package Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos;


import java.time.LocalDateTime;

public class SPagamento {
	private LocalDateTime dataDePagamento;
	private float valor;
	private String[] nomes;
	private boolean pago=false;

	public boolean atualizaPagamento() {
            this.pago=true;
            return true;
	}
        
        public boolean buscaPago(){
            return pago;
        }
}
