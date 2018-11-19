package com.myproj.myproj.entity;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字段访问规则
 * Created by wangjinyu on 2018/11/17 10:23.
 */
@Table(name = "COLUMN_RULE")
@Entity
public class ColumnRuleEntity extends AbstractAuditablePersistable<String> {

    //columns START

    /**
     * 数据库表名
     */
    @Column(name = "DB_TABLE_NAME")
    String dbTableName;

    /**
     * 数据库字段名
     */
    @Column(name = "DB_COLUMN_NAME")
    String dbColumnName;

    /**
     * 允许查询
     */
    @Column(name = "ALLOW_ACCESS")
    String allowAccess;

    /**
     * 脱敏方式 0=无 1=遮盖(适用于字符串)
     */
    @Column(name = "RULE_TYPE")
    String ruleType;

    /**
     * 规则内容。mode=0时此字段无意义。
     * Mode = 1时，#表示不遮盖，*表示遮盖。例：
     * ######*****    适用于电话号码只显示前6位
     */
    @Column(name = "SENSITIVE_RULE")
    String sensitiveRule;

    /**
     * 删除标识  Y：是  N：否
     */
    @Column(name = "DELETE_FLAG")
    String deleteFlag;

    /**
     * 删除时间
     */
    @Column(name = "DELETE_TIME")
    @Convert(converter = InstantConverter.class)
    java.time.Instant deleteTime;
    //columns END

    /**
     * 字段注释
     */
    @Column(name = "COLUMN_NAME_COMMENTS")
    String columnNameComments;

    /**
     * 字段类型
     */
    @Column(name = "DATA_TYPE")
    String dataType;

    /**
     * 字段长度
     */
    @Column(name = "DATA_LENGTH")
    long dataLength;

    public String getColumnNameComments() {
        return columnNameComments;
    }

    public void setColumnNameComments(String columnNameComments) {
        this.columnNameComments = columnNameComments;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public long getDataLength() {
        return dataLength;
    }

    public void setDataLength(long dataLength) {
        this.dataLength = dataLength;
    }

    public void setDbTableName(String value) {
        this.dbTableName = value;
    }

    public String getDbTableName() {
        return this.dbTableName;
    }

    public void setDbColumnName(String value) {
        this.dbColumnName = value;
    }

    public String getDbColumnName() {
        return this.dbColumnName;
    }

    public void setAllowAccess(String value) {
        this.allowAccess = value;
    }

    public String getAllowAccess() {
        return this.allowAccess;
    }

    public void setRuleType(String value) {
        this.ruleType = value;
    }

    public String getRuleType() {
        return this.ruleType;
    }

    public void setSensitiveRule(String value) {
        this.sensitiveRule = value;
    }

    public String getSensitiveRule() {
        return this.sensitiveRule;
    }

    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
    }

    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteTime(java.time.Instant value) {
        this.deleteTime = value;
    }

    public java.time.Instant getDeleteTime() {
        return this.deleteTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ColumnRuleEntity{");
        sb.append("dbTableName='").append(dbTableName).append('\'');
        sb.append(", dbColumnName='").append(dbColumnName).append('\'');
        sb.append(", allowAccess='").append(allowAccess).append('\'');
        sb.append(", ruleType='").append(ruleType).append('\'');
        sb.append(", sensitiveRule='").append(sensitiveRule).append('\'');
        sb.append(", deleteFlag='").append(deleteFlag).append('\'');
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", columnNameComments='").append(columnNameComments).append('\'');
        sb.append(", dataType='").append(dataType).append('\'');
        sb.append(", dataLength=").append(dataLength);
        sb.append('}');
        return sb.toString();
    }
}

