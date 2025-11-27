package topique.dao;

import topique.model.Aluno;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunoDAO {

    private static String ARQUIVO = "alunos.txt";
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        try (FileWriter arquivo = new FileWriter(ARQUIVO, true); PrintWriter saida = new PrintWriter(arquivo)) {

            saida.println(
                    aluno.getNome() + ";"
                    + aluno.getCpf() + ";"
                    + aluno.getIdade() + ";"
                    + aluno.getMatricula() + ";"
                    + aluno.getSenha()
            );

        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    public ArrayList<Aluno> leArquivo() {
        alunos.clear();

        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return alunos;
        }

        try (Scanner sc = new Scanner(arquivo)) {

            while (sc.hasNextLine()) {
                String[] dados = sc.nextLine().split(";");

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

    public boolean cpfExiste(String cpf) {
        for (Aluno a : alunos) {
            if (a.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean soNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public Aluno buscarPorCpf(String cpf) {
        for (Aluno a : alunos) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }
        }
        return null;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
