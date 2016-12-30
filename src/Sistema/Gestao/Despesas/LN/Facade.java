package Sistema.Gestao.Despesas.LN;

import Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos.SPagamento;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.AConta;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SSenhorio;
import Sistema.Gestao.Despesas.Data.DespesaDAO;
import Sistema.Gestao.Despesas.Data.DividasDAO;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.ADespesa;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SMorador;
import Sistema.Gestao.Despesas.Data.MoradorDAO;
import SubsistemaDeUtilizadores.*;
import Subsistema_de_Despesas.*;
import java.util.Set;

public class Facade {

	private MoradorDAO moradores;
	private SSenhorio senhorio;
	private DespesaDAO despesas;
	private DividasDAO dividasDAO;
	private AConta moradorAtual;

	/**
	 * 
	 * @param Morador
	 */
	public void adicionaMorador(SMorador morador) {
            moradores.put(morador.buscaNome(),morador);
	}

	/**
	 * 
	 * @param Despesa
	 */
	public void adicionaDespesa(ADespesa despesa) {
            Set<String> nomes=despesa.buscaMoradores();
            for (String s : nomes) {
                despesas.put(s,despesa);
            }
	}

	/**
	 * 
	 * @param Despesa
	 * @param DespesaAlterada
	 */
	public void alteraDespesaGeral(ADespesa despesa, ADespesa despesaAlterada) {
            Set<String> nomes=moradores.keySet();
            for (String s : nomes) {
                despesas.put(s,despesaAlterada);
            }
	}

	/**
	 * 
	 * @param Despesa
	 */
	public void arquivaDespesa(ADespesa despesa) {
            Set<String> nomes=moradores.keySet();
            despesa.arquiva();
            for (String s : nomes) {
                despesas.put(s, despesa);
            }
	}

	/**
	 * 
	 * @param Divida
	 */
	public void arquivaDivida(SPagamento divida) {
            divida.atualizaPagamento();
	}

	/**
	 * 
	 * @param Morador
	 */
	public void atualizaMorador(SMorador Morador) {
            
	}

	/**
	 * 
	 * @param Senhorio
	 */
	public void atualizaSenhorio(SSenhorio Senhorio) {
		// TODO - implement Facade.atualizaSenhorio
		throw new UnsupportedOperationException();
	}

	public ADespesa buscaDespesa() {
		// TODO - implement Facade.buscaDespesa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Nome
	 */
	public ADespesa buscaDespesaOcasional(String Nome) {
            
            throw new UnsupportedOperationException();
	}

	public ADespesa[] buscaListaDespesas() {
		// TODO - implement Facade.buscaListaDespesas
		throw new UnsupportedOperationException();
	}

	public ADespesa[] buscaListaDespesasAtivas() {
		// TODO - implement Facade.buscaListaDespesasAtivas
		throw new UnsupportedOperationException();
	}

	public ADespesa[] buscaListaDespesasGerais() {
		// TODO - implement Facade.buscaListaDespesasGerais
		throw new UnsupportedOperationException();
	}

	public ADespesa[] buscaListaDespesasGeraisAtivas() {
		// TODO - implement Facade.buscaListaDespesasGeraisAtivas
		throw new UnsupportedOperationException();
	}

	public ADespesa[] buscaListaDespesasSuspensas() {
		// TODO - implement Facade.buscaListaDespesasSuspensas
		throw new UnsupportedOperationException();
	}

	public SPagamento[] buscaListaDividas() {
		// TODO - implement Facade.buscaListaDividas
		throw new UnsupportedOperationException();
	}

	public SMorador[] buscaListaMoradores() {
		// TODO - implement Facade.buscaListaMoradores
		throw new UnsupportedOperationException();
	}

	public SPagamento[] buscaListaPagamentos() {
		// TODO - implement Facade.buscaListaPagamentos
		throw new UnsupportedOperationException();
	}

	public SSenhorio buscaSenhorio() {
		// TODO - implement Facade.buscaSenhorio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Utilizador
	 */
	public boolean existeUtilizador(String Utilizador) {
		// TODO - implement Facade.existeUtilizador
		throw new UnsupportedOperationException();
	}

	public SPagamento[] listaPagamentosDespesasGerais() {
		// TODO - implement Facade.listaPagamentosDespesasGerais
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MoradorPagamento
	 * @param Pagamento
	 */
	public void registaDivida(String MoradorPagamento, SPagamento Pagamento) {
		// TODO - implement Facade.registaD�vida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Despesa
	 */
	public void removeDespesa(ADespesa Despesa) {
		// TODO - implement Facade.removeDespesa
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Morador
	 */
	public void removeMorador(SMorador Morador) {
		// TODO - implement Facade.removeMorador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Utilizador
	 * @param Password
	 */
	public boolean validaLogin(String Utilizador, String Password) {
		// TODO - implement Facade.validaLogin
		throw new UnsupportedOperationException();
	}

}