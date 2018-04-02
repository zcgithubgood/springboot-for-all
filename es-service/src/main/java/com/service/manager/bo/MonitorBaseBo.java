package com.service.manager.bo;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;


/**
 * Created by Druid on 2018/2/25.
 *
 */
public class MonitorBaseBo extends Object {

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String resourceId;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String businessId;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String cloudId;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String zoneId;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String resourceType;

    // 监控项类型  cpu、内存、硬盘、网络。。。。
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String monitorType;


    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCloudId() {
        return cloudId;
    }

    public void setCloudId(String cloudId) {
        this.cloudId = cloudId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }
}
