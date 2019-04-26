package com.myproj.myproj.tespoi;

import com.github.pagehelper.util.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangjinyu on 2019/1/28 8:52.
 */
public class TestPoi001 {

    public String addExcel(@RequestParam("attach") MultipartFile attach)
            throws Exception {
        Integer sumCount = 0;//导入总数量
        Integer okCount = 0;//成功数量
        Integer index = 0;
        Integer errorCount = 0;//错误数量
        Integer repeatCount = 0;//重复数量
        List<Map<String, String>> coverList = new ArrayList<>();
        Map<String, String> resultMap = null;
        String fNme = attach.getOriginalFilename();
        String prefix = fNme.substring(fNme.lastIndexOf(".") + 1);
        if (prefix.equals("xlsx")) {
            int last = fNme.lastIndexOf(".");
            String ext = fNme.substring(last);
            // 判断文件name是否合法
            //  Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
            //Matcher mtchr = pattern.matcher(ext);
            //  ext = mtchr.replaceAll(""); // 将匹配到的非法字符以空替换
            String fePath = System.currentTimeMillis() + ext;
            String pth = "123";
            pth += "/" + fePath;
            File fle = new File(pth);
            attach.transferTo(fle);

            List<List> list = ExcelReadUtil.readExcel(fle);
            Map<String, String> map = new HashMap<String, String>();
            if (list != null && !list.isEmpty()) {
                List contentList = list.get(1);
                if (contentList != null) {
                    for (Object obj : contentList) {
                        Map item = (Map) obj;
                        if (index++ < 1) {
                            continue;
                        }
                        // 若内容中出现非法的html内容，则用spring的htmlEscapeDecimal方法转换为数据转义表示
                        map.put("excelId", HtmlUtils.htmlEscapeDecimal(item.get("0").toString()));
                        String excelId = map.get("excelId");
                        if (StringUtil.isEmpty(excelId)) {
                            break;
                        }
                        map.put("cstNm", HtmlUtils.htmlEscapeDecimal(item.get("1").toString()));
                        map.put("crdtTp", HtmlUtils.htmlEscapeDecimal(item.get("2").toString()));
                        map.put("crdtNo", HtmlUtils.htmlEscapeDecimal(item.get("3").toString()));
                        map.put("bgnPrdBal", HtmlUtils.htmlEscapeDecimal(item.get("4").toString()));
                        map.put("endOfPrdBal", HtmlUtils.htmlEscapeDecimal(item.get("5").toString()));
                        map.put("rcvbIncBal", HtmlUtils.htmlEscapeDecimal(item.get("6").toString()));
                        map.put("rcvbDecBal", HtmlUtils.htmlEscapeDecimal(item.get("7").toString()));
                        map.put("dt", HtmlUtils.htmlEscapeDecimal(item.get("8").toString()));
                        map.put("entpCrdtTp", HtmlUtils.htmlEscapeDecimal(item.get("9").toString()));
                        map.put("entpCrdtNo", HtmlUtils.htmlEscapeDecimal(item.get("10").toString()));
                        map.put("coreEntpNm", HtmlUtils.htmlEscapeDecimal(item.get("11").toString()));
                        map.put("ygStmSplrEcd", HtmlUtils.htmlEscapeDecimal(item.get("12").toString()));
                        map.put("ccy", HtmlUtils.htmlEscapeDecimal(item.get("13").toString()));
                        map.put("udtTm", HtmlUtils.htmlEscapeDecimal(item.get("14").toString()));
                        map.put("qcfx", HtmlUtils.htmlEscapeDecimal(item.get("15").toString()));
                        map.put("qmfx", HtmlUtils.htmlEscapeDecimal(item.get("16").toString()));
                        map.put("rcvbDataSources", "0");//数据来源0：erp；1：excel导入
                        map.put("aprvStCd", "0");//审批状态（0：未审批；1：审批通过；2：审批中;3：审批不通过；）
                    }
                }
            }
        } else {
            resultMap = new HashMap<String, String>();
            resultMap.put("flag", "");
            resultMap.put("message", "请选择.xlsx文件 !");
        }

        return "redirect:/crg/rcvbBal";
    }
}
