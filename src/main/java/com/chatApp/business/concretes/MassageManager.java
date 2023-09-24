package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.MassageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.MessageDao;
import com.chatApp.entities.concretes.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MassageManager implements MassageService {

    private final MessageDao messageDao;
    @Override
    public Result add(Message message) {
        this.messageDao.save(message);
        return new SuccessResult("Created massage");
    }

    @Override
    public DataResult<List<Message>> getAll() {
        return new SuccessDataResult<List<Message>>(this.messageDao.findAll(), "Massage is listed");
    }
}
