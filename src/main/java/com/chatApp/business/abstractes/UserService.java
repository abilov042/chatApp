package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.User;
import com.chatApp.entities.dtos.request.SignupRequest;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

}
