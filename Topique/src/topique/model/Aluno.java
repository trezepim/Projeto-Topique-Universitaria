package topique.model;

public class Aluno extends Pessoa {

    private String nomeFacul;
    private String matricula;

    public Aluno(String nome, String cpf, int idade, String nomeFacul, String matricula) {
        super(nome, cpf, idade);
        this.nomeFacul = nomeFacul;
        this.matricula = matricula;
    }

    public String getNomeFacul() {
        return nomeFacul;
    }

    public String getMatricula() {
        return matricula;
    }
}
