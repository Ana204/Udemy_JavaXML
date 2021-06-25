package aula.nivelamentointerface;

public class Cliente implements ICrud{

    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void incluir() {
        
    }

    @Override
    public void alterar() {

    }

    @Override
    public void deletar() {

    }

    @Override
    public void listar() {

    }
}
