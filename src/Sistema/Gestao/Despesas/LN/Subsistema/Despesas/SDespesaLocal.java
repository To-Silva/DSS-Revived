package Sistema.Gestao.Despesas.LN.Subsistema.Despesas;

import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SMorador;

public class SDespesaLocal extends ADespesa {
	private SDespesaLocal DespesaOriginal;
	private SDespesaLocal[] DespesasAlteradas; 

	public void ativa(){
            super.mudaParaAtiva();
	}
        
	public void suspende(){
            super.mudaParaSuspensa();
	}        

	public boolean paraRemover() {

	}
	public boolean porValidar() {

	}
	public void remove() {

	}
	public void valida(SMorador) {

	}
	public void votoRemocao(SMorador) {

	}

	public buscaInformacoes() {
		
	}
}