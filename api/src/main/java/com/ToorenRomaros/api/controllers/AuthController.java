package com.ToorenRomaros.api.controllers;

import com.ToorenRomaros.api.dto.user.*;
import com.ToorenRomaros.api.exeptions.Error;
import com.ToorenRomaros.api.exeptions.InvalidRefreshTokenException;
import com.ToorenRomaros.api.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/v1")
@Tag(name = "User", description = "Contains Authentication and Password Reset Operations.")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;

    }
    @Operation(
            summary = "User Authentication",
            description = "This endpoint handles user authentication operation, allowing users to sign in and obtain an access token.",
            tags = { "User", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UserSignedInDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "singInDto", description = "SignIn object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SignInDto.class)))
    })
    @PostMapping("/auth/token")
    ResponseEntity<Map<String, Object>> signIn(@RequestBody @Valid SignInDto signInDto) throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("Ok", userService.signin(signInDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Logout and Remove Refresh Token",
            description = "This endpoint facilitates user logout by removing the associated refresh token from the database. Upon successful execution, the user will be logged out, and the refresh token invalidated.",
            tags = { "User", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @Parameters({
            @Parameter(name = "refreshToken", description = "The refreshToken of the current login user", required = true, in = ParameterIn.QUERY),
    })
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

    @Operation(
            summary = "Initiate Password Recovery",
            description = "This endpoint triggers the password recovery process by sending an email to the user associated with the provided email address. If the email exists in the system, the user will receive instructions on how to securely reset their password.",
            tags = { "User", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "forgotPasswordDto", description = "forgotPasswordDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ForgotPasswordDto.class)))
    })
    @PostMapping("/auth/forgot-password")
    ResponseEntity<String> sendPasswordResetEmail(@RequestBody @Valid ForgotPasswordDto forgotPasswordDto) throws MessagingException {
        userService.sendResetPasswordEmail(forgotPasswordDto.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Email sended");
    }

    @Operation(
            summary = "Reset User Password",
            description = " This endpoint allows users to securely reset their password by providing a valid reset token along with the new password. The reset token is typically obtained through an email sent during the password recovery process.",
            tags = { "User", "patch" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "recoverPasswordDto", description = "recoverPasswordDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RecoverPasswordDto.class)))
    })
    @PatchMapping("/auth/reset-password")
    ResponseEntity<String> resetPassword(@RequestBody @Valid RecoverPasswordDto recoverPasswordDto) {
        userService.resetPassword(recoverPasswordDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Password updated sucessfully");
    }

    @Operation(
            summary = "User Registration",
            description = "This endpoint allows users to sign up by providing necessary registration details. Upon successful registration, the user is saved in the database, and access and refresh tokens are generated and returned for immediate authentication.",
            tags = { "User", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = UserSignedInDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "409", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "createUserDto", description = "createUserDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateUserDto.class)))
    })
    @PostMapping("/users")
    public ResponseEntity<UserSignedInDto> signUp(@RequestBody @Valid CreateUserDto createUserDto) {
        return status(HttpStatus.CREATED).body(userService.createUser(createUserDto).get());
    }

    @Operation(
            summary = "Refresh Access Token",
            description = "This endpoint allows users to obtain a new access token by providing a valid refresh token. The refresh token is used to extend the user's session without requiring reauthentication.",
            tags = { "User", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UserSignedInDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema(implementation = Error.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = Error.class)) }) })
    @Parameters({
            @Parameter(name = "refreshTokenDto", description = "refreshTokenDto object", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RefreshTokenDto.class)))
    })
    @PostMapping("/auth/token/refresh")
    ResponseEntity<UserSignedInDto> getAccessToken(@RequestBody @Valid RefreshTokenDto refreshTokenDto) {
        return ok(userService.getAccessToken(refreshTokenDto).orElseThrow(InvalidRefreshTokenException::new));
    }
}
