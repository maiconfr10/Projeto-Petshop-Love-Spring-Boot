package backend.Projeto.Petshop.Love.validacoes;

public class AnimalResponseDTO {

    private Long idAnimal;
    private Long idCliente;
    private String nomeAnimal;
    private String especie;
    private String raca;
    private String idade;

    public AnimalResponseDTO(Long idAnimal, Long idCliente, String nomeAnimal, String especie, String raca, String idade) {
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    // getters
    public Long getIdAnimal() { return idAnimal; }
    public Long getIdCliente() { return idCliente; }
    public String getNomeAnimal() { return nomeAnimal; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public String getIdade() { return idade; }
}

