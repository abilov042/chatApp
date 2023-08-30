package com.chatApp.core.untilitues.result;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String massage) {
        super(false, massage);
    }
}
