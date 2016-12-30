package Sistema.Gestao.Despesas.LN.Subsistema.Despesas;

import Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos.SPagamento;
import java.time.LocalDateTime;
import java.util.Map;

public class SDespesaGeral extends ADespesa 
{

    public SDespesaGeral(LocalDateTime now,
                         boolean b,
                         String Nome,
                         EstadoDespesa estadoDespesa,
                         Map<String, SPagamento> pagamentos) 
    {
        super(now, b, Nome, estadoDespesa, pagamentos);
    }
}