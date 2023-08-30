package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.User;

import java.util.List;

public interface UserService {
    public Result add(User user);
    public DataResult<List<User>> getAll();
}
