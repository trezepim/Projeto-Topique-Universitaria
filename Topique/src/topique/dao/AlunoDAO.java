package topique.dao;

import topique.model.Aluno;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunoDAO {

    private static final String ARQUIVO = "alunos.txt";

    // Gravar aluno
    public void salvar(Aluno aluno) {
        try (FileWriter arquivo = new FileWriter(ARQUIVO, false); PrintWriter saida = new PrintWriter(arquivo)) {

            saida.println(
                    aluno.getNome() + ";"
                    + aluno.getCpf() + ";"
                    + aluno.getIdade() + ";"
                    + aluno.getNomeFacul() + ";"
                    + aluno.getMatricula()
            );

        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    // Ler alunos
    public ArrayList<Aluno> listarTodos() {
        ArrayList<Aluno> alunos = new ArrayList<>();

        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return alunos;
        }

        try (Scanner sc = new Scanner(arquivo)) {

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                String[] dados = linha.split(";");

                Aluno aluno = new Aluno(
                        dados[0],
                        dados[1],
                        Integer.parseInt(dados[2]),
                        dados[3],
                        dados[4]
                );

                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler alunos: " + e.getMessage());
        }

        return alunos;
    }

}
