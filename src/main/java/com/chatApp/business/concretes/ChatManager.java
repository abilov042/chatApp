package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.ChatService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.ChatDao;
import com.chatApp.entities.concretes.Chat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatManager implements ChatService {

    private final ChatDao chatDao;

    @Override
    public Result add(Chat chat) {
        this.chatDao.save(chat);
        return new SuccessResult("Chat created");
    }

    @Override
    public DataResult<List<Chat>> getAll() {
        return new SuccessDataResult<List<Chat>>(this.chatDao.findAll(), "Chat is listed");
    }
}
