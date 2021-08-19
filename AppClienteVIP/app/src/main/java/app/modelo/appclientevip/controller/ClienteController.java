package app.modelo.appclientevip.controller;

import app.modelo.appclientevip.model.Cliente;

public class ClienteController {

    public static boolean validarDadosDoCliente(Cliente cliente, String email, String senha) {

        boolean retorno = ((cliente.getEmail().equals(email)) && (cliente.getSenha().equals(senha)));

        return retorno;

    }

    public static Cliente getClienteTeste() {

        Cliente teste = new Cliente();

        teste.setPrimeiroNome("Ana");
        teste.setSobrenome("Gomes");
        teste.setEmail("Anagomes@gmail.com");
        teste.setSenha("1234");
        teste.setPessoaFisica(true);

        return teste;
    }
}
