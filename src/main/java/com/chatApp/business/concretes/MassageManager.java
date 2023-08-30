package com.chatApp.business.concretes;

import com.chatApp.business.abstractes.MassageService;
import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.core.untilitues.result.SuccessDataResult;
import com.chatApp.core.untilitues.result.SuccessResult;
import com.chatApp.dataAccess.abstracts.MassageDao;
import com.chatApp.entities.concretes.Massage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MassageManager implements MassageService {

    private final MassageDao massageDao;
    @Override
    public Result add(Massage massage) {
        this.massageDao.save(massage);
        return new SuccessResult("Created massage");
    }

    @Override
    public DataResult<List<Massage>> getAll() {
        return new SuccessDataResult<List<Massage>>(this.massageDao.findAll(), "Massage is listed");
    }
}
