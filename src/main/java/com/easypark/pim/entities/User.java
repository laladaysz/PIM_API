package com.easypark.pim.entities;

import com.easypark.pim.dtos.user.UserCreateDTO;
import com.easypark.pim.entities.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "Usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    private String nome;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(UserCreateDTO dados, String senha) {
        this.nome = dados.nome();
        this.login = dados.login();
        this.senha = senha;
        this.role = UserRole.ROLE_DEFAULT;
    }

    // Controle de acessos
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN")
                , new SimpleGrantedAuthority("ROLE_DEFAULT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_DEFAULT"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
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