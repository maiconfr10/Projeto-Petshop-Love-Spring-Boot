package backend.Projeto.Petshop.Love.validacoes;

import org.springframework.stereotype.Component;
import backend.Projeto.Petshop.Love.cliente.ClienteEntitie;

@Component
public class ClienteMapper {

    public ClienteEntitie toEntity(ClienteDTO dto) {

        ClienteEntitie cli = new ClienteEntitie();

        cli.setNomeCliente(dto.getNomeCliente());
        cli.setTeleCliente(dto.getTeleCliente());
        cli.setEmailCliente(dto.getEmailCliente());

        return cli;
    }
}
