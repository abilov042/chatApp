package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.MessageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.MessageDao;
import com.chatApp.entities.concretes.Message;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageManager implements MessageService {

    private final MessageDao messageDao;
    @Override
    public Result add(Message message) {
        this.messageDao.save(message);
        return new SuccessResult("added massage");
    }

    @Override
    public DataResult<List<Message>> getMessageByRoomId(int id) {
        return new SuccessDataResult<List<Message>>(this.messageDao.getMessageByRoom_Id(id), "Found message");
    }

//    @Override
//    public DataResult<List<Message>> getAll(String roomName) {
//        return new SuccessDataResult<List<Message>>(this.messageDao.findMessagesByRoomName(roomName), "Massage is listed");
//    }
}
