package com.myproj.myproj.serviceImpl;


import com.myproj.myproj.dao.ColumnRuleDao;
import com.myproj.myproj.repository.ColumnRuleRepository;
import com.myproj.myproj.service.ColumnRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字段访问规则
 * <p>
 * Created by wangjinyu on 2018/11/17 10:23.
 */
@Service
public class JpaColumnRuleService implements ColumnRuleService {

    private static final Logger logger = LoggerFactory.getLogger(JpaColumnRuleService.class);

    @Autowired
    ColumnRuleRepository columnRuleRepository;

    @Autowired
    ColumnRuleDao columnRuleDao;


}



