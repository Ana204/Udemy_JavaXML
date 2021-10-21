package app.novo.clientevip.Controller;

import app.novo.clientevip.model.Cliente;

public class ClienteController {

    public  static  boolean validarDadosDoCliente(Cliente cliente, String email, String senha){

        boolean retorno = ((cliente.getEmail().equals(email)) && (cliente.getSenha().equals(senha)));

        return  retorno;
    }

    public static Cliente getClienteTeste(){

        Cliente teste = new Cliente();

        teste.setPrimeiroNome("Ana");
        teste.setSobrenome("Gomes");
        teste.setEmail("ana@teste.com");
        teste.setSenha("1234");
        teste.setPessoaFisica(true);

        return teste;
    }
}
