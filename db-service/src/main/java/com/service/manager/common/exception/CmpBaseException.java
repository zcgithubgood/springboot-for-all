package com.service.manager.common.exception;

/**
 * Created by Druid on 2018/4/11.
 *
 */
public class CmpBaseException extends Exception {

    private String retCode;

    private String detailMessage;

    private String[] msgParamers;

    public CmpBaseException(String retCode, String msg, String... msgParamers){
        super(msg);
        this.retCode = retCode;
        this.msgParamers = msgParamers;
    }

    public CmpBaseException(String retCode, String msg, String detailMessage, String... msgParamers){
        super(msg);
        this.retCode = retCode;
        this.detailMessage = detailMessage;
        this.msgParamers = msgParamers;
    }

    public CmpBaseException(String retCode, String msg, String detailMessage){
        super(msg);
        this.retCode = retCode;
        this.detailMessage = detailMessage;
    }

    public CmpBaseException(String retCode, String msg, Throwable throwable, String... msgParamers){
        super(msg, throwable);
        this.retCode = retCode;
        this.msgParamers = msgParamers;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
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
