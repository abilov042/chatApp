package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Message;

import java.util.List;

public interface MessageService {
    Result add(Message message);
    DataResult<List<Message>> getMessageByRoomId(int id);

}
