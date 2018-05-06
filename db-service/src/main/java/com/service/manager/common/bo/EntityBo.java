package com.service.manager.common.bo;

import java.util.Date;

/**
 * Created by Druid on 2018/4/11.
 *
 */
public abstract class EntityBo extends BaseBo {

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String searchWord;

    private Integer isDeleted;

    private String description;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CmpEntityBo{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", searchWord='" + searchWord + '\'' +
                ", isDeleted=" + isDeleted +
                ", description='" + description + '\'' +
                super.toString() +
                '}';
    }
}
