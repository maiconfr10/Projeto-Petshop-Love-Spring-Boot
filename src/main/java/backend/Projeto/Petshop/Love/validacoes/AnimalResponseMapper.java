package backend.Projeto.Petshop.Love.validacoes;

import org.springframework.stereotype.Component;

import backend.Projeto.Petshop.Love.animal.Animal;


@Component
public class AnimalResponseMapper {

    public AnimalResponseDTO toDTO(Animal animal) {
        return new AnimalResponseDTO(
            animal.getIdAnimal(),
            animal.getCliente().getIdCliente(),
            animal.getNomeAnimal(),
            animal.getEspecie(),
            animal.getRaca(),
            animal.getIdade()
        );
    }
}



