package backend.Projeto.Petshop.Love.dto.servico;
import java.util.List;
import backend.Projeto.Petshop.Love.servico.Servico;

public class ServicoListDTO {

	private List<Servico> servicos;
    private Double valorTotal;

    public ServicoListDTO(List<Servico> servicos, Double valorTotal) {
        this.servicos = servicos;
        this.valorTotal = valorTotal;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
}