package ufrpe;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class RepositorioDeUsuario {

	//Método de adicionar
	public void adicionarUsuario(Usuario usuario){
		
		//Falta a verificação se há usuários com o mesmo username
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt", true));
			// Adiciona informações do usuário ao arquivo
            writer.write(usuario.getNome() + ";" +
                         usuario.getDataNascimento() + ";" +
                         usuario.getEmail() + ";" +
                         usuario.getUsername() + ";" +
                         usuario.getSenha());
            writer.newLine(); // Adiciona uma nova linha para o próximo usuário
            writer.close(); //Faz com que as coisas sejam gravadas corretamente
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//Método de busca
    public List<Usuario> buscarPorUsername(String parteDoUsername) {
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                //Divide a linha usando ";" como delimitador
                String[] partes = linha.split(";");
                if (partes.length == 5) { //Certifica-se de que há informações suficientes
                    //Cria um novo objeto Usuario com base nos dados lidos do arquivo
                    Usuario usuario = new Usuario(partes[0], LocalDate.parse(partes[1]), partes[2], partes[3], partes[4]);

                    //Adiciona o usuário à lista se qualquer parte do username corresponder
                    if (usuario.getUsername().contains(parteDoUsername)) {
                        usuariosEncontrados.add(usuario);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuariosEncontrados;
    }
    
    //Método de alterar: Nome 
    public void alterarNomeUsuario(String username, String novoNome) {
        try {
            List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 5 && partes[3].equals(username)) {
                        //Modifica o nome
                        linhas.add(novoNome + ";" +
                                  partes[1] + ";" +
                                  partes[2] + ";" +
                                  partes[3] + ";" +
                                  partes[4]);
                    } else {
                        linhas.add(linha);
                    }
                }
            }
            //Escreve as linhas modificadas de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //Método de alterar: Data de nascimentp
    public void alterarDataNascimentoUsuario(String username, LocalDate novaDataNascimento) {
        try {
            List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 5 && partes[3].equals(username)) {
                        //Modifica a data de nascimento
                        linhas.add(partes[0] + ";" +
                                  novaDataNascimento + ";" +
                                  partes[2] + ";" +
                                  partes[3] + ";" +
                                  partes[4]);
                    } else {
                        linhas.add(linha);
                    }
                }
            }
            //Escreve as linhas modificadas de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //Método de alterar: Email
    public void alterarEmailUsuario(String username, String novoEmail) {
        try {
            List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 5 && partes[3].equals(username)) {
                        //Modifica o email
                        linhas.add(partes[0] + ";" +
                                  partes[1] + ";" +
                                  novoEmail + ";" +
                                  partes[3] + ";" +
                                  partes[4]);
                    } else {
                        linhas.add(linha);
                    }
                }
            }
            //Escreve as linhas modificadas de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //Método de alterar: Username
    public void alterarUsernameUsuario(String username, String novoUsername) {
        try {
            List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 5 && partes[3].equals(username)) {
                        //Modifica o username
                        linhas.add(partes[0] + ";" +
                                  partes[1] + ";" +
                                  partes[2] + ";" +
                                  novoUsername + ";" +
                                  partes[4]);
                    } else {
                        linhas.add(linha);
                    }
                }
            }
            //Escreve as linhas modificadas de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Método para deletar usuário
    public void deletarUsuario(String username) {
        try {
            List<String> linhas = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 5 && partes[3].equals(username)) {
                        //Adiciona nada, efetivamente deletanto o usuário
                    } else {
                        linhas.add(linha);
                    }
                }
            }
            //Escreve as linhas modificadas de volta no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))) {
                for (String linha : linhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}//class

