package byfayzullayev.startup.controller;
import byfayzullayev.startup.entity.role.RoleEntity;
import byfayzullayev.startup.entity.role.UserRole;
import byfayzullayev.startup.entity.user.UserEntity;
import byfayzullayev.startup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("api/onlineExam/user")
public class UserController {
    private final UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {

        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        Set<UserRole> userRoles = userEntity.getRoles();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1L);
        roleEntity.setRoleName("ROLE_USER");

        UserRole userRole = new UserRole();
        userRole.setRoleEntity(roleEntity);
        userRole.setUserEntity(userEntity);
        userRoles.add(userRole);
        return userService.saveUser(userEntity, userRoles);
    }

    @GetMapping("/{username}")
    public UserEntity getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }
}