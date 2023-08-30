package com.chatApp.core.untilitues.result;

public class SuccessResult extends Result{
    public SuccessResult() {
        super(true);
    }
    public SuccessResult(String massage) {
        super(true,massage);
    }

}
