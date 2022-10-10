package byfayzullayev.startup.entity.user;

import byfayzullayev.startup.entity.authority.Authority;
import byfayzullayev.startup.entity.base.BaseEntity;
import byfayzullayev.startup.entity.role.RoleEntity;
import byfayzullayev.startup.entity.role.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity extends BaseEntity implements UserDetails {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private boolean enabled = true;


    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserRole> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
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
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new Authority(role.getRoleEntity().getRoleName())));


        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String username, String email, String password, Set<UserRole> roles, boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }
}
