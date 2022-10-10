package byfayzullayev.startup.service.impl;


import byfayzullayev.startup.Repository.RoleRepository;
import byfayzullayev.startup.Repository.UserRepository;
import byfayzullayev.startup.entity.role.UserRole;
import byfayzullayev.startup.entity.user.UserEntity;
import byfayzullayev.startup.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository  roleRepository;

    public UserServiceImplements(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity, Set<UserRole> userRoles) {
        UserEntity localUser = userRepository.findByUsername(userEntity.getUsername());
        if (localUser != null) {
            System.out.println("User is already there");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRoleEntity());
            }
            userEntity.getRoles().addAll(userRoles);
            localUser = userRepository.save(userEntity);
        }
        return localUser;
    }

    @Override
    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username);
    }
}