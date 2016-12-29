package Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores;


import java.time.LocalDateTime;

public class SMorador extends AConta{
	private LocalDateTime dataDeResidencia;
	private String nome;

	public String buscaNome() {
		return this.nome;
	}
}