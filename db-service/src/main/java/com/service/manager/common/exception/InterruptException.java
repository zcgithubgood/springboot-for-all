package com.service.manager.common.exception;

/**
 * Created by Druid on 2018/4/11.
 *
 */
public class InterruptException extends RuntimeException {

    private String retCode;

    private String[] msgParamers;

    public InterruptException(String retCode, String msg, String... msgParamers){
        super(msg);
        this.retCode = retCode;
        this.msgParamers = msgParamers;
    }

    public InterruptException(String retCode, String msg, Throwable throwable, String... msgParamers){
        super(msg, throwable);
        this.retCode = retCode;
        this.msgParamers = msgParamers;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String[] getMsgParamers() {
        return msgParamers;
    }

    public void setMsgParamers(String[] msgParamers) {
        this.msgParamers = msgParamers;
    }
}
