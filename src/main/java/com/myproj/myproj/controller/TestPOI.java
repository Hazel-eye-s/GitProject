package com.myproj.myproj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproj.myproj.dao.ColumnRuleDao;
import com.myproj.myproj.repository.ColumnRuleRepository;
import com.myproj.myproj.tespoi.TestPoi;
import com.myproj.myproj.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by wangjinyu on 2018/12/13 16:49.
 */
@Controller
public class TestPOI {

    @Autowired
    ColumnRuleRepository columnRuleRepository;
    @Autowired
    ColumnRuleDao columnRuleDao;

    @RequestMapping(method = GET, path = "/productInfoListPOI", produces = "application/json")
    @ResponseBody
    public ResponseEntity productInfoList(
                                          HttpServletRequest request) {
        long l1 = System.currentTimeMillis();
        ResponseEntity responseEntity = new ResponseEntity();

        //pageable默认的第一页从0开始，PageHelper默认的第一页从1开始 所以+1

        //List<Map<String, Object>> list = columnRuleDao.querySysAreaInfo();
        List<Map<String, Object>> list = columnRuleDao.queryProductInfoPage();
        //Optional<ColumnRuleEntity> byId = columnRuleRepository.findById("10201");

        //ResponseEntity直接入参pageInfo代表code=0 成功状态
        responseEntity.setResult(list);
        //System.out.println(list);
       /* List<HashMap<String, Object>> listMap = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> dataMap = new HashMap<>();
            dataMap.put("dbTableName", list.get(i).get("dbTableName"));
            dataMap.put("createdDate", list.get(i).get("createdDate"));
            dataMap.put("columnNameComments", list.get(i).get("columnNameComments"));
            dataMap.put("dbColumnName", list.get(i).get("dbColumnName"));
            dataMap.put("dataLength", list.get(i).get("dataLength"));
            listMap.add(dataMap);
        }*/

      /*  String title = "测试POI区域信息";
        String[] rowsName = new String[]{"序号","行政区划名称", "拼音", "区号", "简称","备注信息","邮编"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs = null;
        for (int i = 0; i <list.size(); i++) {
            Map<String, Object> stringObjectMap = list.get(i);
            objs = new Object[rowsName.length];
            objs[0] = i;
            objs[1] = stringObjectMap.get("name");
            objs[2] = stringObjectMap.get("pinyin");
            objs[3] = stringObjectMap.get("areaCode");
            objs[4] = stringObjectMap.get("shortName");
            objs[5] = stringObjectMap.get("longDesc");
            objs[6] = stringObjectMap.get("postCode");
            dataList.add(objs);
        }*/
        String title = "测试POI";
        String[] rowsName = new String[]{"序号","行政区划名称", "拼音", "区号", "简称","备注信息","邮编"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs = null;
        for (int i = 0; i <list.size(); i++) {
            Map<String, Object> stringObjectMap = list.get(i);
            objs = new Object[rowsName.length];
            objs[0] = i;
            objs[1] = stringObjectMap.get("name");
            objs[2] = stringObjectMap.get("pinyin");
            objs[3] = stringObjectMap.get("areaCode");
            objs[4] = stringObjectMap.get("shortName");
            objs[5] = stringObjectMap.get("longDesc");
            objs[6] = stringObjectMap.get("postCode");
            dataList.add(objs);
        }
        TestPoi ex = new TestPoi(title, rowsName, dataList);
        try {
            String export = ex.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long l2 = System.currentTimeMillis();
        System.out.println((l2-l1)/1000.0);
        return responseEntity;
    }
}


