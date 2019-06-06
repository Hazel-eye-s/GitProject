/*
package com.myproj.myproj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

@RestController
//@Slf4j
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	*/
/*@Autowired
	private FastDFSClient fastDFSClient;
*//*

	@RequestMapping(value = "/pic/upload", method = RequestMethod.POST) // new
																		// annotation
																		// since
																		// 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		
        long l = System.currentTimeMillis();
        byte[] bytes = multipartFile.getBytes();
        long size = multipartFile.getSize();
        System.out.println(bytes);
        System.out.println(size);

		String[] typeImg = {"jpeg", "png", "jpg"};
        String fileName = null;//原文件名
        String ext = null;//文件扩展名
        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
            ext = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
        }
        if (ext != null) {
            boolean booIsType = false;
            for (int i = 0; i < typeImg.length; i++) {
                if (typeImg[i].equals(ext.toLowerCase(Locale.ENGLISH))) {
                    booIsType = true;
                }
            }
            //类型正确时上传
            if (booIsType) {
                InputStream inputStream = multipartFile.getInputStream();
                int len1 = inputStream.available();
                byte[] file_buff = new byte[len1];
                try {
                    int read = inputStream.read(file_buff);
                    if (read == -1) {
                    	logger.info("图片输入流传输不能为空");
                    }
                } catch (IOException e) {
                	logger.error("读取图片流异常", e);
                }
              */
/*  FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
                String[] fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
                if (fileAbsolutePath.length == 0) {
                	logger.error("upload file failed,please upload again!");
                }*//*

                //String path = fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
//                String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];

                return "";
            } else {
            	logger.info("图片类型校验失败：" + ext);
                return null;
            }
        } else {
        	logger.info("图片扩展名不能为空");
            return null;
        }
	}


}*/
