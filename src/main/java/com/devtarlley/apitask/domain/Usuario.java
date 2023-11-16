package com.devtarlley.apitask.domain;

import com.devtarlley.apitask.enumerated.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUsuario;

    private String nome;

    private String password;

    private String email;

    private UserRole roles;

    private boolean isContaNaoExpirada;

    private boolean isAtivo;
    private boolean isCredenciaisNaoExpirada;
    private boolean iscontaNaoBloqueada;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(this.roles == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isContaNaoExpirada;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.iscontaNaoBloqueada;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredenciaisNaoExpirada;
    }

    @Override
    public boolean isEnabled() {
        return this.isAtivo;
    }


}
