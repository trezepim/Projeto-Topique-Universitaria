package topique.model;

public class Aluno extends Pessoa {

    private String matricula;
    private String senha;

    public Aluno(String nome, String cpf, int idade, String matricula, String senha) {
        super(nome, cpf, idade);
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }
}
