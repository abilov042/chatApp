package com.chatApp.core.untilitues.result;

import lombok.Getter;

public class Result {
    @Getter
    private boolean success;
    @Getter
    private String massage;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, String massage){
        this.success = success;
        this.massage = massage;
    }




}
