package com.myproj.myproj.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.Instant;

/**
 Created by wangjinyu on 2018/11/17 10:23.
 */
public class AbstractAuditablePersistable<ID extends Serializable> extends AbstractPersistable<ID> {

    @Column(updatable = false)
    @CreatedDate
    @Convert(converter = InstantConverter.class)
    @Temporal(TemporalType.TIMESTAMP)
    protected Instant createdDate;

    @Column(updatable = false)
    @CreatedBy
    protected String createdBy;

    @Column
    @LastModifiedDate
    @Convert(converter = InstantConverter.class)
    @Temporal(TemporalType.TIMESTAMP)
    protected Instant lastModifiedDate;

    @Column
    @LastModifiedBy
    protected String lastModifiedBy;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
