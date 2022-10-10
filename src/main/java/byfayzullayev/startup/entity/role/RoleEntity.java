package byfayzullayev.startup.entity.role;

import byfayzullayev.startup.entity.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoleEntity extends BaseEntity {

    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleEntity")
    private Set<UserRole> userRoles = new HashSet<>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public RoleEntity() {
    }

    public RoleEntity(String roleName, Set<UserRole> userRoles) {
        this.roleName = roleName;
        this.userRoles = userRoles;
    }
}