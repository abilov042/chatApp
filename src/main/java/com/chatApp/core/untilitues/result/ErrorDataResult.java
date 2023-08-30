package com.chatApp.core.untilitues.result;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(T data) {
        super(data, false);
    }
    public ErrorDataResult(T data, String massage) {
        super(data, false, massage);
    }
}
