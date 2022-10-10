package byfayzullayev.startup.entity.role;

import byfayzullayev.startup.entity.base.BaseEntity;
import byfayzullayev.startup.entity.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private RoleEntity roleEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserRole() {
    }

    public UserRole(Long userRoleId, UserEntity userEntity, RoleEntity roleEntity) {
        this.userRoleId = userRoleId;
        this.userEntity = userEntity;
        this.roleEntity = roleEntity;
    }
}
