package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Message;

import java.util.List;

public interface MassageService {
    public Result add(Message message);
    public DataResult<List<Message>> getAll();
}
