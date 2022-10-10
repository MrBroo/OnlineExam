package byfayzullayev.startup.service;

import byfayzullayev.startup.entity.role.RoleEntity;
import byfayzullayev.startup.entity.role.UserRole;
import byfayzullayev.startup.entity.user.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserService {

    public UserEntity saveUser(UserEntity userEntity, Set<UserRole> userRoles);
    public UserEntity getUser(String username);
}