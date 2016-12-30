/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Gestao.Despesas.UI;

import Sistema.Gestao.Despesas.LN.Facade;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SSenhorio;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.ADespesa;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.EstadoDespesa;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.SDespesaGeral;
import Sistema.Gestao.Despesas.LN.Subsistema.Despesas.SDespesaLocal;
import Sistema.Gestao.Despesas.LN.Subsistema.Pagamentos.SPagamento;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.AConta;
import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SMorador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Andre
 */
public class MainUI {
    Facade Facade;
    AConta moradorAtual;
    
    public void MainUI()
    {
        Facade = new Facade();
    }

    private void AdicionarDespesaSenhorio(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        System.out.println("Dê uma decrição da Despesa");
        String Nome=Menu.readString(bf);
        if (Nome.equals("@quit"))
        {
            System.out.println("Atribua um valor à Despesa");
            float Valor=Menu.readPosFloat(bf);
            if (Valor!=-1) 
            {
                StringBuilder sb=new StringBuilder();
                sb.append("Escolha os moradores envolvidos na despesa separados por vírgulas");
                List<SMorador> Lista=Facade.buscaListaMoradores();
                int i=1;
                for(SMorador Morador : Lista) 
                {
                    sb.append(i).append(" - ").append(Morador.buscaNome());
                    i++;
                }
                System.out.println(sb.toString());
                int indexes[]=Menu.readCSVInts(bf);
                if (indexes!=null) 
                {
                    Map<String,SPagamento> pagamentos = new HashMap<>(indexes.length);
                    for(int index : indexes) 
                    {
                        SPagamento pagamento 
                                = new SPagamento(LocalDateTime.now().plusDays(30),
                                                 Valor/indexes.length);
                        pagamentos.put(Lista.get(index-1).buscaNome(),pagamento);
                    }
                    ADespesa despesa=new SDespesaGeral(LocalDateTime.now(),
                                                       false,
                                                       Nome,
                                                       EstadoDespesa.DespesaSuspensa,
                                                       pagamentos);
                    Facade.adicionaDespesa(despesa);
                }
            }
        }
    }
    
    private void AdicionarDespesaMorador(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        System.out.println("Dê uma decrição da Despesa");
        String Nome=Menu.readString(bf);
        if (Nome.equals("@quit"))
        {
            System.out.println("Atribua um valor à Despesa");
            float Valor=Menu.readPosFloat(bf);
            if (Valor!=-1) 
            {
                StringBuilder sb=new StringBuilder();
                sb.append("Escolha os moradores envolvidos na despesa separados por vírgulas");
                List<SMorador> Lista=Facade.buscaListaMoradores();
                int i=1;
                for(SMorador Morador : Lista) 
                {
                    sb.append(i).append(" - ").append(Morador.buscaNome());
                    i++;
                }
                System.out.println(sb.toString());
                int indexes[]=Menu.readCSVInts(bf);
                if (indexes!=null) 
                {
                    Map<String,SPagamento> pagamentos = new HashMap<>(indexes.length);
                    for(int index : indexes) 
                    {
                        SPagamento pagamento 
                                = new SPagamento(LocalDateTime.now().plusDays(30),
                                                 Valor/indexes.length);
                        pagamentos.put(Lista.get(index-1).buscaNome(),pagamento);
                    }
                    ADespesa despesa=new SDespesaLocal(LocalDateTime.now(),
                                                       false,
                                                       Nome,
                                                       EstadoDespesa.DespesaSuspensa,
                                                       pagamentos);
                    Facade.adicionaDespesa(despesa);
                }
            }
        }
    }
    
    private void ValidarDespesaMorador(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        StringBuilder sb=new StringBuilder();
        sb.append("Escolha a despesa em que está envolvido que pretende validar");
        List<ADespesa> Lista=Facade.buscaListaDespesasSuspensas();
        int i=1;
        for(ADespesa despesa : Lista) 
        {
            sb.append(i).append(" - ").append(despesa.buscaDescricao());
        }
        System.out.println(sb.toString());
        int index=Menu.readPosInt(bf);
        if (index!=-1) 
        {
            SDespesaLocal despesa=(SDespesaLocal) Lista.get(index);
            if(despesa.buscaVotosValidar().get(((SMorador)moradorAtual).buscaNome())) 
            {
                System.out.println("Despesa já está validada");
            }
            else 
            {
                despesa.valida((SMorador)moradorAtual);
                Facade.alteraDespesa(despesa);
            }                
        }
    }

    private void RemoverDespesaMorador(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        StringBuilder sb=new StringBuilder();
        sb.append("Escolha a despesa em que está envolvido que pretende remover");
        List<ADespesa> Lista=Facade.buscaListaDespesasSuspensas();
        int i=1;
        for(ADespesa despesa : Lista) 
        {
            sb.append(i).append(" - ").append(despesa.buscaDescricao());
        }
        System.out.println(sb.toString());
        int index=Menu.readPosInt(bf);
        if (index!=-1) 
        {
            SDespesaLocal despesa=(SDespesaLocal) Lista.get(index);
            if(despesa.buscaVotosRemover().get(((SMorador)moradorAtual).buscaNome())) 
            {
                System.out.println("Já votou esta Despesa para remover");
            }
            else 
            {
                despesa.votoRemocao((SMorador)moradorAtual);
                Facade.alteraDespesa(despesa);
            }                
        }    
    }
    
    private void RemoverDespesaSenhorio(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        StringBuilder sb=new StringBuilder();
        sb.append("Escolha a despesa em que está envolvido que pretende remover");
        List<ADespesa> Lista=Facade.buscaListaDespesasGeraisAtivas();
        int i=1;
        for(ADespesa despesa : Lista) 
        {
            sb.append(i).append(" - ").append(despesa.buscaDescricao());
        }
        System.out.println(sb.toString());
        int index=Menu.readPosInt(bf);
        if (index!=-1) 
        {
            SDespesaLocal despesa=(SDespesaLocal) Lista.get(index);
            if(despesa.haPagamento()) 
            {
                System.out.println("Já não é possível remover esta Despesa");
            }
            else 
            {
                Facade.removeDespesa(despesa);
            }                
        }    
    }
    
    private void PagarDespesaMorador(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        StringBuilder sb=new StringBuilder();
        sb.append("Escolha a despesa em que está envolvido que pretende pagar");
        List<ADespesa> Lista=Facade.buscaListaDespesasAtivas();
        int i=1;
        for(ADespesa despesa : Lista) 
        {
            sb.append(i).append(" - ").append(despesa.buscaDescricao());
        }
        System.out.println(sb.toString());
        int index=Menu.readPosInt(bf);
        if (index!=-1) 
        {
            SDespesaLocal despesa=(SDespesaLocal) Lista.get(index);
            if(despesa.buscaVotosRemover().get(((SMorador)moradorAtual).buscaNome())) 
            {
                System.out.println("Já votou esta Despesa para remover");
            }
            else 
            {
                despesa.votoRemocao((SMorador)moradorAtual);
                Facade.alteraDespesa(despesa);
            }                
        }
    }
    
    private void PagarDívidaMorador(BufferedReader bf) throws IOException
    {
        System.out.println("--@quit a qualquer altura para sair--");
        StringBuilder sb=new StringBuilder();
        sb.append("Escolha a dívida que pretende pagar");
        List<SPagamento> Lista=Facade.buscaListaDividas();
        int i=1;
        for(SPagamento divida : Lista) 
        {
            sb.append(i).append(" - ").append(divida.toString());
        }
        System.out.println(sb.toString());
        int index=Menu.readPosInt(bf);
        if (index!=-1) 
        {
            SPagamento divida=Lista.get(index);
            Facade.arquivaDivida(divida);                
        }

    }
    
    private void AlterarMorador(BufferedReader bf) throws IOException
    {
    
    }
    
    private void ConsultarDividas(BufferedReader bf) throws IOException
    {
    
    }

    private void ConsultarPagamentosMorador(BufferedReader bf) throws IOException
    {
    
    }

    private void ConsultarSenhorio(BufferedReader bf) throws IOException
    {
    
    }
    
    private void ConsultarDespesasMorador(BufferedReader bf) throws IOException
    {
    
    }

    
    private void MoradorMainMenu(BufferedReader bf) throws IOException
    {
        StringBuilder sb= new StringBuilder();
        sb.append("0 - Sair\n");
        sb.append("1 - Adicionar Despesa\n");
        sb.append("2 - Validar Despesa\n");
        sb.append("3 - Votar Remover Despesa\n");
        sb.append("4 - Pagar Despesa\n");
        sb.append("5 - Pagar Dívida\n");
        sb.append("6 - Alterar Informações de Morador\n");
        sb.append("7 - Consultar Dividas");
        sb.append("8 - Consultar Pagamentos");
        sb.append("9 - Consultar informações do Senhorio");
        sb.append("10 - Consultar Despesas");
        Menu m= new Menu(sb,bf);
        m.addChoice((InputProcedure)this::AdicionarDespesaMorador);
        m.addChoice((InputProcedure)this::ValidarDespesaMorador);
        m.addChoice((InputProcedure)this::RemoverDespesaMorador);
        m.addChoice((InputProcedure)this::PagarDespesaMorador);
        m.addChoice((InputProcedure)this::PagarDívidaMorador);
        m.addChoice((InputProcedure)this::AlterarMorador);
        m.addChoice((InputProcedure)this::ConsultarDividas);
        m.addChoice((InputProcedure)this::ConsultarPagamentosMorador);
        m.addChoice((InputProcedure)this::ConsultarSenhorio);
        m.addChoice((InputProcedure)this::ConsultarDespesasMorador);
        m.run();
    }
    
    private void LoginUser(BufferedReader bf) throws IOException
    {
        String Utilizador;
        String Password;
        boolean LoginValido;
        System.out.println("Digite o seu username");
        Utilizador=Menu.readString(bf);
        LoginValido=Facade.existeUtilizador(Utilizador);
        if (!LoginValido) 
        {
            System.out.println("Utilizador não existe");
        }
        System.out.println("Digite a sua password");
        Password=Menu.readString(bf);
        LoginValido=Facade.validaLogin(Utilizador,Password);
        if (!LoginValido) 
        {
            System.out.println("Password inválida");
        }
        else 
        {
            moradorAtual = Facade.buscaMoradorAtual();
            if(moradorAtual !=null && moradorAtual instanceof SMorador)
            {
                MoradorMainMenu(bf);
            }
            else if (moradorAtual!=null) 
            {
                SenhorioMainMenu(bf);
            }
        }
    }
    
    private void RegistarSenhorio(BufferedReader bf) throws IOException 
    {
        String Utilizador;
        String Password;
        String Nome;
        String Endereco;
        boolean RegistoValido;
        System.out.println("Digite o username que pretende");
        Utilizador=Menu.readString(bf);
        System.out.println("Digite a password que pretende");
        Password=Menu.readString(bf);
        System.out.println("Digite o seu nome");
        Nome=Menu.readString(bf);
        System.out.println("Digite a sua morada");
        Endereco=Menu.readString(bf);        
        Facade.atualizaSenhorio(new SSenhorio(Utilizador,Password,Nome,Endereco));
        System.out.println("Registo efetuado com sucesso");
    }
    
    public void runMainMenu() 
    {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        SSenhorio Senhorio=Facade.buscaSenhorio();
        sb.append("0 - Sair\n");
        sb.append("1 - Login\n");
        if(Senhorio==null)
        {
            sb.append("2 - Registar Senhorio");
        }
        Menu m= new Menu(sb,bf);
        m.addChoice((InputProcedure)this::LoginUser);
        if(Senhorio==null)
        {
            m.addChoice((InputProcedure)this::RegistarSenhorio);
        }
        try 
        {
            m.run();
        }
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Cria e corre o menu principal.
     */
    public static void main(String[] args)
    {
        MainUI ui=new MainUI();
        ui.runMainMenu();
    }

    private void SenhorioMainMenu(BufferedReader bf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
