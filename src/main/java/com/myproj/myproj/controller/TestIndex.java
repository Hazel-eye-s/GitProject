package com.myproj.myproj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproj.myproj.dao.ColumnRuleDao;
import com.myproj.myproj.entity.ColumnRuleEntity;
import com.myproj.myproj.repository.ColumnRuleRepository;
import com.myproj.myproj.utils.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by wangjinyu on 2018/11/17 10:23.
 */
@Controller
public class TestIndex {
    private static final Logger logger = LoggerFactory.getLogger(TestIndex.class);

    @Autowired
    ColumnRuleRepository columnRuleRepository;
    @Autowired
    ColumnRuleDao columnRuleDao;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public ColumnRuleEntity getInfo() {
        ColumnRuleEntity byDbTableNameAndDbColumnName =
                columnRuleRepository.findByDbTableNameAndDbColumnName("T_RECEIVABLE_DETAIL", "SPLR_FULLNM");
        System.out.println(byDbTableNameAndDbColumnName);
        return byDbTableNameAndDbColumnName;
    }

    @RequestMapping(method = GET, path = "/productInfoList", produces = "application/json")
    @ResponseBody
    public ResponseEntity productInfoList(@PageableDefault Pageable pageable,
                                          HttpServletRequest request) {
        ResponseEntity responseEntity = new ResponseEntity();

        //pageable默认的第一页从0开始，PageHelper默认的第一页从1开始 所以+1
        PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        List<Map<String, Object>> list = columnRuleDao.queryProductInfoPage();
        //Optional<ColumnRuleEntity> byId = columnRuleRepository.findById("10201");
        PageInfo<Map<String, Object>> pageInfo = new PageInfo(list);
        //ResponseEntity直接入参pageInfo代表code=0 成功状态
        responseEntity.setResult(pageInfo);
        System.out.println(list);


        return responseEntity;
    }

    //单个图片上传
    public void uploadPhotoUtil(String uploadDir, MultipartFile file) throws Exception {
        //上传文件名字
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        File servletFile = new File(uploadDir + filename);
        file.transferTo(servletFile);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request, MultipartFile file) {
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //上传文件名字
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String filename = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
            File servletFile = new File(uploadDir + filename);

            file.transferTo(servletFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }

    @RequestMapping(value = "/uploadMultity", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultity(HttpServletRequest request, MultipartFile[] file, Model model) {
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            System.out.println(file.length+"****");
            for (int i = 0; i <file.length; i++) {
                if (file[i] != null) {
                    uploadPhotoUtil(uploadDir, file[i]);
                    model.addAttribute("uploadDir",uploadDir);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
