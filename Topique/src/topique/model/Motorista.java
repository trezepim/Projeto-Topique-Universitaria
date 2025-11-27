package topique.model;

public class Motorista extends Pessoa {

    private String cnh;
    private String modeloVan;
    private String placaVan;
    private int quantAssentos;

    public Motorista(String nome, String cpf, int idade, String cnh, String modeloVan, String placaVan, int quantAssentos) {
        super(nome, cpf, idade);
        this.cnh = cnh;
        this.modeloVan = modeloVan;
        this.placaVan = placaVan;
        this.quantAssentos = quantAssentos;
    }

    public Motorista() {
    }

    public String getCnh() {
        return cnh;
    }

    public String getModeloVan() {
        return modeloVan;
    }

    public String getPlacaVan() {
        return placaVan;
    }

    public int getQuantAssentos() {
        return quantAssentos;
    }

    @Override
    public String saudacao() {
        return "Olá motorista!";
    }
}
