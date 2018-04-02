package com.service.manager.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import java.util.Date;

/**
 * Created by Druid on 2018/3/25.
 *
 */
@Document(indexName = "monitor-instance", type = "instance")
public class InstanceMonitorBo extends MonitorBaseBo {

    @Id
    private String id;

    private String instanceId;

    // cpu使用率 百分比
    private Float cpuUsage;

    // 内存使用率  百分比
    private Float memoryUsage;

    // 系统盘吞吐量(读) 单位：B/s
    private Integer osDiskReadThroughput;

    // 系统盘吞吐量(写) 单位：B/s
    private Integer osDiskWriteThroughput;

    // 系统盘IOPS(读)  单位：IOPS
    private Integer osDiskReadIops;

    // 系统盘IOPS(写)  单位：IOPS
    private Integer osDiskWriteIops;

    // 系统盘mount路径
    private String osDiskMount;

    // 系统盘使用率 百分比
    private Float osDiskUsage;

    // 系统盘已用空间  单位：MB
    private Double osDiskUsed;

    // 系统盘可用空间  单位：MB
    private Double osDiskFree;

    // 网络读
    private Float netRead;

    // 网络写
    private Float netWrite;

    // 网络读写 KB/S
    private Float netReadWrite;

    // 系统盘吞吐量(读写) 单位：KB/s
    private Integer osDiskReadWriteThroughput;

    private Date monitorTime;

    public InstanceMonitorBo(String id, Float cpuUsage, Float memoryUsage, Date monitorTime) {
        this.id = id;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.monitorTime = monitorTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Float getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Float cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Float getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Float memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Integer getOsDiskReadThroughput() {
        return osDiskReadThroughput;
    }

    public void setOsDiskReadThroughput(Integer osDiskReadThroughput) {
        this.osDiskReadThroughput = osDiskReadThroughput;
    }

    public Integer getOsDiskWriteThroughput() {
        return osDiskWriteThroughput;
    }

    public void setOsDiskWriteThroughput(Integer osDiskWriteThroughput) {
        this.osDiskWriteThroughput = osDiskWriteThroughput;
    }

    public Integer getOsDiskReadIops() {
        return osDiskReadIops;
    }

    public void setOsDiskReadIops(Integer osDiskReadIops) {
        this.osDiskReadIops = osDiskReadIops;
    }

    public Integer getOsDiskWriteIops() {
        return osDiskWriteIops;
    }

    public void setOsDiskWriteIops(Integer osDiskWriteIops) {
        this.osDiskWriteIops = osDiskWriteIops;
    }

    public String getOsDiskMount() {
        return osDiskMount;
    }

    public void setOsDiskMount(String osDiskMount) {
        this.osDiskMount = osDiskMount;
    }

    public Float getOsDiskUsage() {
        return osDiskUsage;
    }

    public void setOsDiskUsage(Float osDiskUsage) {
        this.osDiskUsage = osDiskUsage;
    }

    public Double getOsDiskUsed() {
        return osDiskUsed;
    }

    public void setOsDiskUsed(Double osDiskUsed) {
        this.osDiskUsed = osDiskUsed;
    }

    public Double getOsDiskFree() {
        return osDiskFree;
    }

    public void setOsDiskFree(Double osDiskFree) {
        this.osDiskFree = osDiskFree;
    }

    public Float getNetRead() {
        return netRead;
    }

    public void setNetRead(Float netRead) {
        this.netRead = netRead;
    }

    public Float getNetWrite() {
        return netWrite;
    }

    public void setNetWrite(Float netWrite) {
        this.netWrite = netWrite;
    }

    public Float getNetReadWrite() {
        return netReadWrite;
    }

    public void setNetReadWrite(Float netReadWrite) {
        this.netReadWrite = netReadWrite;
    }

    public Integer getOsDiskReadWriteThroughput() {
        return osDiskReadWriteThroughput;
    }

    public void setOsDiskReadWriteThroughput(Integer osDiskReadWriteThroughput) {
        this.osDiskReadWriteThroughput = osDiskReadWriteThroughput;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    @Override
    public String toString() {
        return "InstanceMonitor{" +
                "id='" + id + '\'' +
                ", cpuUsage='" + cpuUsage + '\'' +
                ", memoryUsage='" + memoryUsage + '\'' +
                ", monitorTime='" + monitorTime + '\'' +
                '}';
    }
}
