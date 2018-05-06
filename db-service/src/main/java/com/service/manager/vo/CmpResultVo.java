package com.service.manager.vo;

import java.util.List;

/**
 * Created by Druid on 2018/5/6.
 *
 */
public class CmpResultVo {

    private String retCode;

    private String retMessage;

    private String requestId;

    private List retList;

    private String jobId;

    public CmpResultVo(){}

    public CmpResultVo(String retCode, String retMessage, List retList, String requestId) {
        this.retCode = retCode;
        this.retMessage = retMessage;
        this.retList = retList;
        this.requestId = requestId;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List getRetList() {
        return retList;
    }

    public void setRetList(List retList) {
        this.retList = retList;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
