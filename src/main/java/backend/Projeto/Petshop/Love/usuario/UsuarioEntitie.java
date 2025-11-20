package backend.Projeto.Petshop.Love.usuario;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "usuario")
public class UsuarioEntitie   implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfis = new ArrayList<>();

    public UsuarioEntitie() {}

    public UsuarioEntitie(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdUsuario() { return idUsuario; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getNome() { return nome; }
    public List<Perfil> getPerfis() { return perfis; }

    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
   public void setNome(String nome) { this.nome = nome; }


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return perfis;
   }

   @Override
   public String getPassword() {
       return senha;
   }

   @Override
   public String getUsername() {
       return email;
   }

   @Override
   public boolean isAccountNonExpired() {
       return true;
   }

   @Override
   public boolean isAccountNonLocked() {
       return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
       return true;
   }

   @Override
   public boolean isEnabled() {
       return true;
   }
}





