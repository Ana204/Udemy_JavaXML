package model.NivelamentoPOO1;

public class Pessoa implements Habilidade {
    
    private String nome;
    private String telefone;
    private String email;


    
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


    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String falarIdiomas() {
        return "Meu nome é: " + getNome() + " e sei falar minha ligua nativa!";
    }

    

}
