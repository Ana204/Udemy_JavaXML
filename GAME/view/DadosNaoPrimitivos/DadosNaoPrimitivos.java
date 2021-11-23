package view.DadosNaoPrimitivos;

public class DadosNaoPrimitivos {
    
    public static void main(String[] args) {
        
        //Não primitivos são dados que consistem em métodos, ou sejá são representados atraves de um obejto 
        //exemplos: Short, Long, Float, Double, String 

        String nomeCidade = "SãoPaulo";

        int tamanho = nomeCidade.length();

        System.out.println("Cidade São Paulo contém: " + tamanho + " cracteres");

        //usando o metodo para minuscula
        System.out.println("Cidade: " + nomeCidade.toLowerCase());

        //usando o método para maiuscula
        System.out.println("Cidade: " + nomeCidade.toUpperCase());
    }
}
  