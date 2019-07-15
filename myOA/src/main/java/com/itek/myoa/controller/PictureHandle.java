/**
 * @Author xlyu
 * @Date 2019/7/13
 * @Description
 */
package com.itek.myoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-13 08:51
 **/
@Controller
public class PictureHandle {


    @RequestMapping("headHandle")
    public String headHandle() {
        return "personalInfo";
    }

    @ResponseBody
    @RequestMapping(value = "addDevice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addDevice(@RequestParam("file") MultipartFile file) {
        // 获取原始文件名
        String fileName = file.getOriginalFilename();

        System.out.println(fileName);
        //获取文件类型
        String type = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "F:/360MoveData/Users/Administrator/Desktop/myOaPicture";
        // 重新生成随机文件名
        fileName = UUID.randomUUID() + type;
        System.out.println(fileName);
        System.out.println(filePath);
        String newFileName = filePath+"/"+fileName;
        System.out.println(newFileName);

        //创建该文件
        File file1 = new File(newFileName);

        try {
            file.transferTo(file1);
        } catch (IOException e) {
            System.out.println();
            e.printStackTrace();
        }finally {
            System.out.println("写入本地磁盘");
        }
        return "文件上传成功";
    }
}
