package com.service.manager.common.bo;

import javax.persistence.Id;

/**
 * Created by Druid on 2018/4/11.
 *
 */
public abstract class BaseBo {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseBo{" +
                "id='" + id + '\'' +
                '}';
    }
}
