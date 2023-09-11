package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.UserService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.dataAccess.abstracts.UserDao;
import com.chatApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserManager implements UserService {
    @Autowired
    UserDao  userDao;
    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Listed users");
    }
}
