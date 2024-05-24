package br.com.springsecurity.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.springsecurity.entities.Role;
import br.com.springsecurity.entities.User;
import br.com.springsecurity.repository.RoleRepository;
import br.com.springsecurity.repository.UserRepository;
import jakarta.transaction.Transactional;


@Configuration
public class AdminUserConfig implements CommandLineRunner{

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    

    public AdminUserConfig(RoleRepository roleRepository, UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
            user -> {
                System.out.println("usuário admin já existe");
            },
            () -> {
                var user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRoles(Set.of(roleAdmin));
                userRepository.save(user);
                
            }
        );
    }
    
}
