package Sistema.Gestao.Despesas.LN.Subsistema.Utilizadores;

public abstract class AConta {
    private String username;
    private String password;
        
    public AConta(String Username,String Password)
    {
            username=Username;
            password=Password;
    }
}