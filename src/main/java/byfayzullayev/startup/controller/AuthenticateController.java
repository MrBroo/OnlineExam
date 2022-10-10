package byfayzullayev.startup.controller;

import byfayzullayev.startup.config.JwtUtil;
import byfayzullayev.startup.entity.jwt.JwtRequest;
import byfayzullayev.startup.entity.jwt.JwtResponse;
import byfayzullayev.startup.entity.user.UserEntity;
import byfayzullayev.startup.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS" + e.getMessage());
        }
    }

    @GetMapping("/current")
    public UserEntity getCurrentUser(Principal principal) {
        return ((UserEntity)userDetailsService.loadUserByUsername(principal.getName()));
    }
}
