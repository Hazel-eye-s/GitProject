package com.myproj.myproj.dao;


import com.myproj.myproj.entity.ColumnRuleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 字段访问规则
 * Created by wangjinyu on 2018/11/17 10:23.
 */
@Mapper
@Repository
public interface ColumnRuleDao {

    List<Map<String, Object>> queryProductInfoPage();


}



