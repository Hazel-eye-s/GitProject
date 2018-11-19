package com.myproj.myproj.repository;

import com.myproj.myproj.entity.ColumnRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 字段访问规则
 * Created by wangjinyu on 2018/11/17 10:23.
 */
@Repository
public interface ColumnRuleRepository extends JpaRepository<ColumnRuleEntity, String>,
        JpaSpecificationExecutor<ColumnRuleEntity> {


    ColumnRuleEntity findByDbTableNameAndDbColumnName(String dbTableName, String dbColumnName);


}



