package ufrpe;

import java.time.LocalDate;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		//Cria uma instância do repositório de usuários
		//Isso pode ser alterado com o getInstance(), mas preciso entender melhor
        RepositorioDeUsuario repositorio = new RepositorioDeUsuario();

        //Adiciona usuários ao repositório
        /*
        Usuario usuario1 = new Usuario("John Jones", LocalDate.of(1990, 1, 1), "john@example.com", "johnJones", "password123");
        Usuario usuario2 = new Usuario("John Luccas", LocalDate.of(1985, 5, 15), "jane@example.com", "john_1517", "letmein");

        repositorio.adicionarUsuario(usuario1);
        repositorio.adicionarUsuario(usuario2);
        */
        
        //Busca usuários do arquivo
        /*
        List<Usuario> usuariosEncontrados = repositorio.buscarPorUsername("john");

        for (Usuario usuario : usuariosEncontrados) {
            System.out.println("Usuário encontrado: " + usuario.getNome());
        }
        */
        
        //Altera:
        //Nome de usuário
        /*
        repositorio.alterarNomeUsuario("john_doe", "JOHN DOE 2 O GRANDE");
        */
        //Data de nascimento
        /*
        repositorio.alterarDataNascimentoUsuario("john_doe", LocalDate.of(2004, 4, 21));
        */
        //Email
        /*
        repositorio.alterarEmailUsuario("john_doe", "teste.teste@teste.com");
        */
        //Username
        /*
        repositorio.alterarUsernameUsuario("john_doe", "john_doe_2_o_grande");
        */
        
        //Deletar
        repositorio.deletarUsuario("jane_smith");

	}//main

}
