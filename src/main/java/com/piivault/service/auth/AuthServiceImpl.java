package com.piivault.service.auth;

import com.piivault.domain.User;
import com.piivault.enums.UserRole;
import com.piivault.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        Optional<User> optionalUser =userRepository.findByUserRole(UserRole.ADMIN);
        if(!optionalUser.isPresent()) {
            User user = new User();
            user.setEmail("admin@dtcc.com");
            user.setUsername("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("Admin Account created Successfully");
        } else {
            System.out.println("Admin Account already Exists");
        }
    }

}
