package backend.Projeto.Petshop.Love.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@Valid @RequestBody UsuarioDTO dto) {
        UsuarioEntitie novo = service.cadastrar(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(novo));
    }
}

