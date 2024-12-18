package com.piivault.service.auth;

import com.piivault.dto.SignupRequest;
import com.piivault.dto.UserDto;

public interface AuthService {

    UserDto signupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
