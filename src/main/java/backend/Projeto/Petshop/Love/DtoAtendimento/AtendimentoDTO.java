package backend.Projeto.Petshop.Love.DtoAtendimento;

public class AtendimentoDTO {

    private String data;
    private Long idAnimal;
    private String observacoes;

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
