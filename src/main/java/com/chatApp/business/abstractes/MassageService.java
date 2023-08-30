package com.chatApp.business.abstractes;

import com.chatApp.core.untilitues.result.DataResult;
import com.chatApp.core.untilitues.result.Result;
import com.chatApp.entities.concretes.Massage;

import java.util.List;

public interface MassageService {
    public Result add(Massage massage);
    public DataResult<List<Massage>> getAll();
}
