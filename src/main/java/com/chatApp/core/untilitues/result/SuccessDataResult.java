package com.chatApp.core.untilitues.result;

public class SuccessDataResult<T> extends DataResult<T>{


    public SuccessDataResult(T data) {
        super(data, true);
    }
    public SuccessDataResult(T data, String massage) {
        super(data, true, massage);
    }
}
