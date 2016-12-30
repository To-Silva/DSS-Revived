package Sistema.Gestao.Despesas.LN.Subsistema.Despesas;

import Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos.SPagamento;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class SDespesaGeral extends ADespesa 
{

    public SDespesaGeral(LocalDateTime now,
                         boolean b,
                         String Nome,
                         EstadoDespesa estadoDespesa,
                         Map<String, List<SPagamento>> pagamentos) 
    {
        super(now, b, Nome, estadoDespesa, pagamentos);
    }
}