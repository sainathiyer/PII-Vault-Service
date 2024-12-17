package com.piivault.service.auth;

import com.piivault.domain.User;
import org.springframework.stereotype.Service;


public interface AuthService {
    //void createAdminAccount();
    User getUserByUsername(String username);
}
