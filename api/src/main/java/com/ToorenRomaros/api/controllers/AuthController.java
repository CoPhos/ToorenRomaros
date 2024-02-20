package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.config.SecurityConfig;
import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.InvalidRefreshTokenException;
import com.ToorenRomaros.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/v1")
public class AuthController {
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    public AuthController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/auth/token")
    ResponseEntity<Map<String, Object>> signIn(@RequestBody @Valid SignInDto signInDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("Ok", userService.signin(signInDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/auth/token")
    public ResponseEntity<Void> signOut(@RequestParam String refreshToken) {
        userService.removeRefreshToken(refreshToken);
        return accepted().build();
    }

    @GetMapping("/admin")
    ResponseEntity<Map<String, Object>> admin() {
        Map<String, Object> response = new HashMap<>();
        response.put("ok", "admin0");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/auth/forgot-password")
    ResponseEntity<String> sendPasswordResetEmail(@RequestBody @Valid RecoverPasswordDto recoverPasswordDto) throws MessagingException {
        userService.sendResetPasswordEmail(recoverPasswordDto.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Email sended");
    }

    @PatchMapping("/auth/reset-password")
    ResponseEntity<String> resetPassword(@RequestBody @Valid RecoverPasswordDto recoverPasswordDto) {
        userService.resetPassword(recoverPasswordDto.getToken(), recoverPasswordDto.getNewPassword());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Password updated sucessfully");
    }

    @PostMapping("/users")
    public ResponseEntity<UserSignedInDto> signUp(@RequestBody @Valid CreateUserDto createUserDto) {
        return status(HttpStatus.CREATED).body(userService.createUser(createUserDto).get());
    }

    @PostMapping("/auth/token/refresh")
    ResponseEntity<UserSignedInDto> getAccessToken(@RequestBody @Valid RefreshTokenDto refreshTokenDto) {
        log.info(refreshTokenDto.getRefreshToken());
        return ok(userService.getAccessToken(refreshTokenDto).orElseThrow(InvalidRefreshTokenException::new));
    }
}
