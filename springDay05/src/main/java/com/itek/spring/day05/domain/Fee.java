/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.domain;

import java.util.Date;
import java.util.Objects;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 16:22
 **/
public class Fee {
    private Integer id;
    private String name;
    private Integer baseDuration;
    private Double baseCost;
    private Double unitCost;
    private Integer status;
    private String descr;
    private Date createTime;
    private Date startTime;
    private Integer costType;

    public Fee() {


    }

    public Fee(Integer id, String name,
               Integer baseDuration,
               Double baseCost,
               Double unitCost,
               Date createTime,
               Date startTime,
               Integer status) {
        this.id = id;
        this.name = name;
        this.baseDuration = baseDuration;
        this.baseCost = baseCost;
        this.unitCost = unitCost;
        this.createTime = createTime;
        this.startTime = startTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseDuration=" + baseDuration +
                ", baseCost=" + baseCost +
                ", unitCost=" + unitCost +
                ", status=" + status +
                ", descr='" + descr + '\'' +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", costType=" + costType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fee fee = (Fee) o;
        return Objects.equals(id, fee.id) &&
                Objects.equals(name, fee.name) &&
                Objects.equals(baseDuration, fee.baseDuration) &&
                Objects.equals(baseCost, fee.baseCost) &&
                Objects.equals(unitCost, fee.unitCost) &&
                Objects.equals(status, fee.status) &&
                Objects.equals(descr, fee.descr) &&
                Objects.equals(createTime, fee.createTime) &&
                Objects.equals(startTime, fee.startTime) &&
                Objects.equals(costType, fee.costType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, baseDuration, baseCost, unitCost, status, descr, createTime, startTime, costType);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }
}
