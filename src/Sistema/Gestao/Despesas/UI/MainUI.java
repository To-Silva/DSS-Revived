/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Gestao.Despesas.UI;

import Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores.SSenhorio;
import Sistema.Gestao.Despesas.LN.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andre
 */
public class MainUI {
    Facade Facade;
    
    public void MainUI()
    {
        Facade = new Facade();
    }
    
    private void AdicionarDespesaMorador(BufferedReader bf) throws IOException
    {
    
    }
    
    private void ValidarDespesaMorador(BufferedReader bf) throws IOException
    {
    
    }
    
    private void RemoverDespesaMorador(BufferedReader bf) throws IOException
    {
    
    }
    
    private void PagarDespesaMorador(BufferedReader bf) throws IOException
    {
    
    }
    
    private void PagarDívidaMorador(BufferedReader bf) throws IOException
    {
    
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
            MoradorMainMenu(bf);
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
}
