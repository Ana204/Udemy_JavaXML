package view.Nivelamento01;

import model.NivelamentoPOO1.Estudante;
import model.NivelamentoPOO1.Pessoa;
import model.NivelamentoPOO1.Professor;

public class Nivelamento {
     
    public static void main(String[] args) {
        
        Pessoa obj = new Pessoa();

        obj.setNome("Ana");
        obj.setTelefone("9999999");
        obj.setEmail("Ana@hotmail.com");

        System.out.println("Pessoa");
        System.out.println("Nome: " + obj.getNome());
        System.out.println("Telefone: " + obj.getTelefone());
        System.out.println("Email: " + obj.getEmail());
        System.out.println(obj.falarIdiomas());

        System.out.println("\n\n" + "Professor");

        Professor professor = new Professor();

        professor.setNome("Danilo");
        professor.setEmail("danilo@gmail.com");
        professor.setTelefone("88888888");
        professor.setTitulo("Professor de Redes");

        System.out.println("Nome: " + professor.getNome());
        System.out.println("Telefone: " + professor.getTelefone());
        System.out.println("Email: " + professor.getEmail());
        System.out.println("Titulo: " + professor.getTitulo());
        System.out.println("ToString: " + professor.toString());
        System.out.print(professor.falarIdiomas());

        System.out.println("\n\n" + "Estudante");

        Estudante estudante = new Estudante();

        estudante.setNome("Ferreira");
        estudante.setEmail("Ferreira@gomes.com");
        estudante.setTelefone("7777777");
        estudante.setCurso("Desenvolvimento de sistemas");
        estudante.setRA(9999990);

        System.out.println("Nome: " + estudante.getNome());
        System.out.println("Telefone: " + estudante.getTelefone());
        System.out.println("Email: " + estudante.getEmail());
        System.out.println("Curso: " + estudante.getCurso());
        System.out.println("RA: " + estudante.getRA());
        System.out.println("ToString: " + estudante.toString());
        System.out.println(estudante.falarIdiomas());
    }
}
