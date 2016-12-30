package Sistema.Gestao.Despesas.LN.Subsistema.Despesas;

import Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos.SPagamento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ADespesa {
	private LocalDateTime dataDespesa;
	private boolean ocasional;
	private String descricao;
	private EstadoDespesa estado;
	private Map<String,SPagamento> pagamentos;

        public void arquiva(){
            this.estado=EstadoDespesa.DespesaArquivada;
        }
        
        protected void mudaParaAtiva(){
            this.estado=EstadoDespesa.DespesaAtiva;
        }
        
        protected void mudaParaSuspensa(){
            this.estado=EstadoDespesa.DespesaSuspensa;
        }            
        
	public abstract buscaInformacoes () {

	}

	public SPagamento buscaPagamento (String moradorDespesa) {
            return pagamentos.get(moradorDespesa);
	}

	public boolean haPagamento (){
            return pagamentos.values().stream().anyMatch((p) -> (p.buscaPago()));
	}

	public boolean estaArquivada(){
            return this.estado==EstadoDespesa.DespesaArquivada;
	}

	public boolean estaAtiva(){
		return this.estado==EstadoDespesa.DespesaAtiva;
	}

	public boolean estaSuspensa() {
		return this.estado==EstadoDespesa.DespesaSuspensa;
	}

	public Set<String> buscaMoradores() {
            return pagamentos.keySet();
	}

	public LocalDateTime buscaData(){
            return this.dataDespesa;
	}
        
        public String buscaDescricao() {
            return this.descricao;
        }
        
        public boolean buscaOcasional(){
            return this.ocasional;
        }
        
        public boolean buscaLocal(){
            return this.ocasional;
        }
        
        public EstadoDespesa buscaEstado() {
            return this.estado;
        }
}