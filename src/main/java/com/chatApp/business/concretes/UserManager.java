package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.UserService;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.RoleDao;
import com.chatApp.dataAccess.abstracts.UserDao;
import com.chatApp.entities.concretes.ERole;
import com.chatApp.entities.concretes.Role;
import com.chatApp.entities.concretes.User;
import com.chatApp.entities.dtos.request.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserManager implements UserService {

    private UserDao userDao;
    private PasswordEncoder encoder;
    private RoleDao roleDao;


    @Override
    public Result save(SignupRequest signupRequest) {

        // Create new user's account
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRoles();
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

        return new SuccessResult("Successfully added");
    }



}
