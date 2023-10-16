package com.chatApp.api.controllers;

import com.chatApp.core.security.entities.UserDetailsImpl;
import com.chatApp.core.security.jwt.JWTUtils;
import com.chatApp.core.untilitues.result.ErrorDataResult;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.dataAccess.abstracts.RoleDao;
import com.chatApp.dataAccess.abstracts.UserDao;
import com.chatApp.entities.concretes.ERole;
import com.chatApp.entities.concretes.Role;
import com.chatApp.entities.concretes.User;
import com.chatApp.entities.dtos.request.LoginRequest;
import com.chatApp.entities.dtos.request.SignupRequest;
import com.chatApp.entities.dtos.response.UserInfoResponse;
import com.chatApp.entities.dtos.response.UserInfoVerificationDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class UserAuthController {


    private AuthenticationManager authenticationManager;

    private UserDao userDao;

    private RoleDao roleDao;

    private PasswordEncoder encoder;

    private JWTUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        User user = userDao.findByUsername(loginRequest.getUsername()).orElseThrow();
        UserInfoVerificationDto userInfoVerificationDto = new UserInfoVerificationDto(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isVerify());

        if(!userInfoVerificationDto.isVerify()){

            return ResponseEntity.badRequest().body(new ErrorDataResult<UserInfoVerificationDto>(userInfoVerificationDto, "User isn't verified"));
        }

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateJwtToken(authentication);



        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        jwtToken,
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userDao.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        if (userDao.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleDao.findByName(ERole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleDao.findByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleDao.findByName(ERole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userDao.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }




    @GetMapping("test")
    public ResponseEntity<String> getHello(){
        System.out.println(encoder.encode("123"));

        return ResponseEntity.ok("OK");
    }




}
