package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.dtos.request.SignupRequest;

public interface UserService {
    Result save(SignupRequest signupRequest);

}
