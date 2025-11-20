package backend.Projeto.Petshop.Love.validacoes;

import org.springframework.stereotype.Component;

import backend.Projeto.Petshop.Love.animal.Animal;
import backend.Projeto.Petshop.Love.cliente.ClienteEntitie;

@Component
public class AnimalMapper {

    public Animal toEntity(AnimalDTO dto) {
        Animal animal = new Animal();

        animal.setNomeAnimal(dto.getNomeAnimal());
        animal.setEspecie(dto.getEspecie());
        animal.setRaca(dto.getRaca());
        animal.setIdade(dto.getIdade());

        ClienteEntitie cliente = new ClienteEntitie();
        cliente.setIdCliente(dto.getIdCliente());
        animal.setCliente(cliente);

        return animal;
    }
}
