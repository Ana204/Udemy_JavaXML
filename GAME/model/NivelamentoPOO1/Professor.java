package model.NivelamentoPOO1;

public class Professor extends Pessoa{
    
    private String titulo;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    @Override
    public String toString() {
        return getTitulo();
    }

    @Override
    public String falarIdiomas() {
        return "Meu nome é: " + getNome() + " e eu sei falar espanhol.";
    }

    
}
