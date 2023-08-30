package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Chat;

import java.util.List;

public interface ChatService {
    public Result add(Chat chat);
    public DataResult<List<Chat>> getAll();
}
